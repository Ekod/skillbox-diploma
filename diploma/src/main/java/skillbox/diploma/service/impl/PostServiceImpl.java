package skillbox.diploma.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import skillbox.diploma.api.response.PostResponse;
import skillbox.diploma.api.response.PostResponseList;
import skillbox.diploma.model.Post;
import skillbox.diploma.model.Tag;
import skillbox.diploma.model.enums.PostTypes;
import skillbox.diploma.repository.PostRepository;
import skillbox.diploma.repository.TagRepository;
import skillbox.diploma.service.PostService;
import skillbox.diploma.utils.PostServiceUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    PostRepository postRepository;
    TagRepository tagRepository;

    PostServiceUtils postServiceUtils;

    @Override
    public PostResponse getPosts(int offset, int limit, String mode) {
        Pageable pageable = PageRequest.of(offset, limit);
        PostResponse responsePost = new PostResponse();
        ArrayList<PostResponseList> listOfPosts = new ArrayList<>();
        List<Post> allPosts = postServiceUtils.requestsWithSorting(mode, pageable, postRepository);
        for (Post post : allPosts) {
            PostResponseList postResponseList = postServiceUtils.mapToPost(post);
            listOfPosts.add(postResponseList);
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }

    @Override
    public PostResponse getPostsBySearch(int offset, int limit, String query) {
        Pageable pageable = PageRequest.of(offset, limit);
        PostResponse responsePost = new PostResponse();
        ArrayList<PostResponseList> listOfPosts = new ArrayList<>();
        List<Post> allPosts = postRepository.findAllByTitleOrTextAndIsActiveAndModerationStatus(query, pageable);
        for (Post post : allPosts) {
            PostResponseList postResponseList = postServiceUtils.mapToPost(post);
            listOfPosts.add(postResponseList);
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }

    @Override
    public PostResponse getPostsByDate(int offset, int limit, String date) {
        Pageable pageable = PageRequest.of(offset, limit);
        PostResponse responsePost = new PostResponse();
        ArrayList<PostResponseList> listOfPosts = new ArrayList<>();
        List<Post> allPosts = postRepository.findAllByTimeAndIsActiveAndModerationStatus(date, pageable);
        for (Post post : allPosts) {
            PostResponseList postResponseList = postServiceUtils.mapToPost(post);
            listOfPosts.add(postResponseList);
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }

    @Override
    public PostResponse getPostsByTag(int offset, int limit, String tag) {
        Pageable pageable = PageRequest.of(offset, limit);
        PostResponse responsePost = new PostResponse();
        ArrayList<PostResponseList> listOfPosts = new ArrayList<>();
        List<Tag> tagList = tagRepository.findAllByName(tag, pageable);
        for (Tag tags : tagList) {
            tags.getPostList().stream().forEach(post -> {
                if (post.getIsActive() == 1 && post.getModerationStatus() == PostTypes.ACCEPTED) {
                    PostResponseList postResponseList = postServiceUtils.mapToPost(post);
                    listOfPosts.add(postResponseList);
                }
            });
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }

    @Override
    public PostResponse getPostById(String id) {
        return null;
    }


}
