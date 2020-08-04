package skillbox.diploma.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import skillbox.diploma.api.response.ApiPostResponse;
import skillbox.diploma.api.response.ForApiPostResponse;
import skillbox.diploma.api.response.UserForApiPostResponse;
import skillbox.diploma.model.Post;
import skillbox.diploma.repository.PostRepository;
import skillbox.diploma.service.PostService;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    PostRepository postRepository;
    ApiPostResponse responsePost;

    @Override
    public ApiPostResponse getPosts() {

        ArrayList<ForApiPostResponse> listOfPosts = new ArrayList<>();
        Iterable<Post> allPosts = postRepository.findAll();
        for (Post post : allPosts) {
            ForApiPostResponse forApiPostResponse = new ForApiPostResponse();
            forApiPostResponse.setId(post.getId());
            forApiPostResponse.setTimestamp(post.getTime());
            forApiPostResponse.setUser(new UserForApiPostResponse(post.getUser().getId(), post.getUser().getName()));
            forApiPostResponse.setTitle(post.getTitle());
            forApiPostResponse.setAnnounce(post.getText());
//            forApiPostResponse.setLikeCount();
//            forApiPostResponse.setDislikeCount();
//            forApiPostResponse.setCommentCount();
            forApiPostResponse.setViewCount(post.getViewCount());

            listOfPosts.add(forApiPostResponse);
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }
}
