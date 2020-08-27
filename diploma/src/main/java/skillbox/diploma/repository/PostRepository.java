package skillbox.diploma.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.Post;

import java.util.List;


@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {

    @Query(value = "SELECT * FROM posts WHERE is_active=true and moderation_status='ACCEPTED' " +
            "and time <= NOW() ORDER BY time ASC", nativeQuery = true)
    List<Post> findAllByIsActiveAndModerationStatusOrderByTimeAsc(Pageable pageable);

    @Query(value = "SELECT * FROM posts WHERE is_active=true and moderation_status='ACCEPTED' " +
            "and time <= NOW() ORDER BY time DESC ", nativeQuery = true)
    List<Post> findAllByIsActiveAndModerationStatusOrderByTimeDesc(Pageable pageable);

    @Query(value = "SELECT * FROM posts p WHERE is_active=true and moderation_status='ACCEPTED' " +
            " and time <= NOW() ORDER BY (SELECT COUNT(*) FROM post_comments pc WHERE pc.id = p.id) DESC",
            nativeQuery = true)
    List<Post> findAllByIsActiveAndModerationStatusOrderByPostComments(Pageable pageable);

    @Query(value = "SELECT * FROM posts p WHERE is_active=true and moderation_status='ACCEPTED' " +
            "and time <= NOW() ORDER BY (SELECT COUNT(*) FROM post_votes pc WHERE pc.id = p.id and pc.value = 1) DESC",
            nativeQuery = true)
    List<Post> findAllByIsActiveAndModerationStatusOrderByPostVotes(Pageable pageable);

    @Query(value = "select p from posts p where p.title like %:query% or p.text like %:query% " +
            "and p.isActive = 1 and p.moderationStatus = 'ACCEPTED' and p.time <= current_timestamp")
    List<Post> findAllByTitleOrTextAndIsActiveAndModerationStatus(@Param("query") String query, Pageable pageable);

    @Query(value = "select p from posts p where p.time = :date and p.isActive = 1 and p.moderationStatus = 'ACCEPTED' " +
            "and p.time <= current_timestamp")
    List<Post> findAllByTimeAndIsActiveAndModerationStatus(@Param("date") String date, Pageable pageable);

    @Query(value = "select p from posts p where p.id = :id and p.isActive = 1 and p.moderationStatus = 'ACCEPTED' " +
            "and p.time <= current_timestamp")
    Post findByIdAndIsActiveAndModerationStatus(@Param("id") int id);

}
