package skillbox.diploma.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import skillbox.diploma.api.response.PostResponse;
import skillbox.diploma.api.response.PostResponseList;
import skillbox.diploma.api.response.PostResponseListUser;
import skillbox.diploma.model.Post;
import skillbox.diploma.repository.PostRepository;
import skillbox.diploma.service.PostService;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final int LIKE_VALUE = 1;
    private final int DISLIKE_VALUE = -1;

    PostRepository postRepository;

    @Override
    public PostResponse getPosts(int offset, int limit, String mode) {
        Pageable pageable = PageRequest.of(offset, limit, sortRequest(mode));
        PostResponse responsePost = new PostResponse();
        ArrayList<PostResponseList> listOfPosts = new ArrayList<>();
        Iterable<Post> allPosts = postRepository.findAll(pageable);
        for (Post post : allPosts) {
            PostResponseList postResponseList = mapToPost(post);
            listOfPosts.add(postResponseList);
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }


    private PostResponseList mapToPost(Post post) {
        return PostResponseList
                .builder()
                .id(post.getId())
                .timestamp(post.getTime())
                .user(constructUser(post))
                .title(post.getTitle())
                .announce(postAnnouncementCreator(post))
                .likeCount(getLikesAndDislikes(post, LIKE_VALUE))
                .dislikeCount(getLikesAndDislikes(post, DISLIKE_VALUE))
                .commentCount(post.getPostComments().size())
                .viewCount(post.getViewCount())
                .build();
    }

    private Sort sortRequest(String mode) {
        switch (mode) {
            case "recent":
                return Sort.by("time").descending();
            case "popular":
                return Sort.by("");
            case "best":
                return Sort.by("");
            case "early":
                return Sort.by("time").ascending();
            default:
                return null;
        }
    }

    private int getLikesAndDislikes(Post post, int value) {
        return (int) post.getPostVotes().stream().filter(vote -> vote.getValue() == value).count();
    }

    private PostResponseListUser constructUser(Post post) {
        return PostResponseListUser
                .builder()
                .id(post.getUser().getId())
                .name(post.getUser().getName())
                .build();
    }

    private String postAnnouncementCreator(Post post) {
        String htmlRemoverRegEx = "<[^>]*>";
        return post.getText().replaceAll(htmlRemoverRegEx, "").trim().substring(0, 149);
    }

    @Override
    public PostResponse getPostsSearch(int offset, int limit, String query) {
        return null;
    }

    @Override
    public PostResponse getPostsDate(int offset, int limit, String date) {
        return null;
    }

    @Override
    public PostResponse getPostsTag(int offset, int limit, String tag) {
        return null;
    }

}
