package skillbox.diploma.service.impl;

import lombok.AllArgsConstructor;
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

    PostRepository postRepository;

    @Override
    public PostResponse getPosts() {
        PostResponse responsePost = new PostResponse();
        ArrayList<PostResponseList> listOfPosts = new ArrayList<>();
        Iterable<Post> allPosts = postRepository.findAll();
        for (Post post : allPosts) {
            PostResponseList postResponseList = new PostResponseList();
            postResponseList.setId(post.getId());
            postResponseList.setTimestamp(post.getTime());
            postResponseList.setUser(new PostResponseListUser(post.getUser().getId(), post.getUser().getName()));
            postResponseList.setTitle(post.getTitle());
            postResponseList.setAnnounce(post.getText());
            postResponseList.setLikeCount((int) post.getPostVotes().stream().filter(vote -> vote.getValue() == 1).count());
            postResponseList.setDislikeCount((int) post.getPostVotes().stream().filter(vote -> vote.getValue() == -1).count());
            postResponseList.setCommentCount(post.getPostComments().size());
            postResponseList.setViewCount(post.getViewCount());

            listOfPosts.add(postResponseList);
        }
        responsePost.setCount(listOfPosts.size());
        responsePost.setPosts(listOfPosts);
        return responsePost;
    }
}
