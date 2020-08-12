package skillbox.diploma;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import skillbox.diploma.model.Post;
import skillbox.diploma.model.PostComment;
import skillbox.diploma.model.PostVote;
import skillbox.diploma.model.Tag;
import skillbox.diploma.model.User;
import skillbox.diploma.model.enums.PostTypes;
import skillbox.diploma.repository.PostCommentRepository;
import skillbox.diploma.repository.PostRepository;
import skillbox.diploma.repository.PostVoteRepository;
import skillbox.diploma.repository.TagRepository;
import skillbox.diploma.repository.UserRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
@AllArgsConstructor
public class DiplomaApplication {

    UserRepository userRepository;
    PostRepository postRepository;
    TagRepository tagRepository;
    PostCommentRepository postCommentRepository;
    PostVoteRepository postVoteRepository;

    public static void main(String[] args) {
        SpringApplication.run(DiplomaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {

        return args -> {

            User user1 = User
                    .builder()
                    .id(1)
                    .isModerator((byte) 1)
                    .regTime(Timestamp.from(Instant.now()))
                    .name("Vasilich")
                    .email("vasilich@gmail.com")
                    .password("password").code(null).photo(null).postComments(null).posts(null).postVotes(null).build();

            User user2 = User
                    .builder()
                    .id(2)
                    .isModerator((byte) 0)
                    .regTime(Timestamp.from(Instant.now()))
                    .name("Petrovich")
                    .email("petrovich@gmail.com")
                    .password("password").code(null).photo(null).postComments(null).posts(null).postVotes(null).build();

            Post post1 = Post
                    .builder()
                    .id(1)
                    .isActive((byte) 0)
                    .moderationStatus(PostTypes.NEW)
                    .moderatorId(1)
                    .postComments(null)
                    .postVotes(null)
                    .tagList(null)
                    .text("Lorem Hrenolem Ipsum")
                    .time(Timestamp.from(Instant.now()))
                    .title("Boogie-Woogie")
                    .user(user1)
                    .viewCount(22)
                    .build();

            Post post2 = Post
                    .builder()
                    .id(2)
                    .isActive((byte) 1)
                    .moderationStatus(PostTypes.ACCEPTED)
                    .moderatorId(null)
                    .postComments(null)
                    .postVotes(null)
                    .tagList(null)
                    .text("Text for post 2")
                    .time(Timestamp.from(Instant.now()))
                    .title("Rock'n'Roll")
                    .user(user2)
                    .viewCount(12)
                    .build();

            Tag tag1 = Tag
                    .builder()
                    .id(1)
                    .name("Hopa")
                    .postList(null)
                    .build();

            Tag tag2 = Tag
                    .builder()
                    .id(2)
                    .name("Popa")
                    .postList(null)
                    .build();
//
            PostVote postVote1 = PostVote
                    .builder()
                    .id(1)
                    .post(post1)
                    .time(Timestamp.from(Instant.now()))
                    .value((byte) 1)
                    .user(user1)
                    .build();

            PostVote postVote2 = PostVote
                    .builder()
                    .id(2)
                    .post(post2)
                    .time(Timestamp.from(Instant.now()))
                    .value((byte) -1)
                    .user(user2)
                    .build();
//
            PostComment postComment1 = PostComment
                    .builder()
                    .id(1)
                    .parentId(null)
                    .post(post1)
                    .text("Opa hopa i vot ona Evropa")
                    .time(Timestamp.from(Instant.now()))
                    .user(user1)
                    .build();

            PostComment postComment2 = PostComment
                    .builder()
                    .id(2)
                    .parentId(null)
                    .post(post2)
                    .text("O! Nea.")
                    .time(Timestamp.from(Instant.now()))
                    .user(user2)
                    .build();
            userRepository.save(user1);
            userRepository.save(user2);
            postRepository.save(post1);
            postRepository.save(post2);
            tagRepository.saveAll(Arrays.asList(tag1, tag2));

            user1.setPosts(Arrays.asList(post1));
            user2.setPosts(Arrays.asList(post2));

            userRepository.save(user1);
            userRepository.save(user2);
            postVoteRepository.saveAll(Arrays.asList(postVote1, postVote2));
            user1.setPostVotes(Arrays.asList(postVote1));
            user2.setPostVotes(Arrays.asList(postVote2));
            postCommentRepository.saveAll(Arrays.asList(postComment1, postComment2));

            user1.setPostComments(Arrays.asList(postComment1));
            user2.setPostComments(Arrays.asList(postComment2));
            post1.setPostComments(Arrays.asList(postComment1));
            post1.setPostVotes(Arrays.asList(postVote1));
            post2.setPostComments(Arrays.asList(postComment2));
            post2.setPostVotes(Arrays.asList(postVote2));
            userRepository.save(user1);
            userRepository.save(user2);
            postRepository.save(post1);
            postRepository.save(post2);
            tagRepository.saveAll(Arrays.asList(tag1, tag2));
            postVoteRepository.saveAll(Arrays.asList(postVote1, postVote2));
            postCommentRepository.saveAll(Arrays.asList(postComment1, postComment2));


        };
    }

}
