package skillbox.diploma.utils;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import skillbox.diploma.api.response.PostResponseList;
import skillbox.diploma.api.response.PostResponseListUser;
import skillbox.diploma.model.Post;
import skillbox.diploma.repository.PostRepository;

import java.util.List;

@Component
public class PostServiceUtils {

    private final int LIKE_VALUE = 1;
    private final int DISLIKE_VALUE = -1;

    public PostResponseList mapToPost(Post post) {
        return PostResponseList
                .builder()
                .id(post.getId())
                .timestamp(post.getTime().getTime() / 1000)
                .user(constructUser(post))
                .title(post.getTitle())
                .announce(postAnnouncementCreator(post))
                .likeCount(getLikesAndDislikes(post, LIKE_VALUE))
                .dislikeCount(getLikesAndDislikes(post, DISLIKE_VALUE))
                .commentCount(post.getPostComments().size())
                .viewCount(post.getViewCount())
                .build();
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

    private int getLikesAndDislikes(Post post, int value) {
        return (int) post.getPostVotes().stream().filter(vote -> vote.getValue() == value).count();
    }

    public List<Post> requestsWithSorting(String mode, Pageable pageable, PostRepository postRepository) {
        switch (mode) {
            case "recent":
                return postRepository.findAllByIsActiveAndModerationStatusOrderByTimeAsc(pageable);
            case "popular":
                return postRepository.findAllByIsActiveAndModerationStatusOrderByPostComments(pageable);
            case "best":
                return postRepository.findAllByIsActiveAndModerationStatusOrderByPostVotes(pageable);
            case "early":
                return postRepository.findAllByIsActiveAndModerationStatusOrderByTimeDesc(pageable);
            default:
                return null;
        }
    }

}
