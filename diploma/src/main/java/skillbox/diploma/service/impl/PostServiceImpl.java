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
import skillbox.diploma.model.Tag;
import skillbox.diploma.model.enums.PostTypes;
import skillbox.diploma.repository.PostRepository;
import skillbox.diploma.repository.TagRepository;
import skillbox.diploma.service.PostService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final int LIKE_VALUE = 1;
    private final int DISLIKE_VALUE = -1;

    PostRepository postRepository;
    TagRepository tagRepository;

    @Override
    public PostResponse getPosts(int offset, int limit, String mode) {
        Pageable pageable = PageRequest.of(offset, limit, sortRequest(mode));
        PostResponse responsePost = new PostResponse();
        ArrayList<PostResponseList> listOfPosts = new ArrayList<>();
        Iterable<Post> allPosts = postRepository.findAllByIsActiveAndModerationStatus(pageable);
        for (Post post : allPosts) {
            PostResponseList postResponseList = mapToPost(post);
            listOfPosts.add(postResponseList);
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }

    @Override
    public PostResponse getPostsSearch(int offset, int limit, String query) {
        Pageable pageable = PageRequest.of(offset, limit);
        PostResponse responsePost = new PostResponse();
        ArrayList<PostResponseList> listOfPosts = new ArrayList<>();
        List<Post> allPosts = postRepository.findAllByTitleOrTextAndIsActiveAndModerationStatus(query, pageable);
        for (Post post : allPosts) {
            PostResponseList postResponseList = mapToPost(post);
            listOfPosts.add(postResponseList);
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }

    @Override
    public PostResponse getPostsDate(int offset, int limit, String date) {
        Pageable pageable = PageRequest.of(offset, limit);
        PostResponse responsePost = new PostResponse();
        ArrayList<PostResponseList> listOfPosts = new ArrayList<>();
        List<Post> allPosts = postRepository.findAllByTimeAndIsActiveAndModerationStatus(date, pageable);
        for (Post post : allPosts) {
            PostResponseList postResponseList = mapToPost(post);
            listOfPosts.add(postResponseList);
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }

    @Override
    public PostResponse getPostsTag(int offset, int limit, String tag) {
        Pageable pageable = PageRequest.of(offset, limit);
        PostResponse responsePost = new PostResponse();
        ArrayList<PostResponseList> listOfPosts = new ArrayList<>();
        List<Tag> tagList = tagRepository.findAllByName(tag, pageable);
        for (Tag tags : tagList) {
            tags.getPostList().stream().forEach(post -> {
                if (post.getIsActive() == 1 && post.getModerationStatus() == PostTypes.ACCEPTED) {
                    PostResponseList postResponseList = mapToPost(post);
                    listOfPosts.add(postResponseList);
                }
            });
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }

    //==============================Util methods=============================================================================
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
        String noHTMLAnnounce = post.getText().replaceAll(htmlRemoverRegEx, "").trim();
        if (noHTMLAnnounce.length() > 150) {
            return noHTMLAnnounce.substring(0, 149);
        }
        return noHTMLAnnounce;
    }


}
