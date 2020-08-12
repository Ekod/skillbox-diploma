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

    @Query(value = "select p from posts p where p.isActive = 1 and p.moderationStatus = 'ACCEPTED'")
    List<Post> findAllByIsActiveAndModerationStatus(Pageable pageable);

    @Query(value = "select p from posts p where p.title like %:query% or p.text like %:query% and p.isActive = 1 and p.moderationStatus = 'ACCEPTED'")
    List<Post> findAllByTitleOrTextAndIsActiveAndModerationStatus(@Param("query") String query, Pageable pageable);

    @Query(value = "select p from posts p where p.time = :date and p.isActive = 1 and p.moderationStatus = 'ACCEPTED'")
    List<Post> findAllByTimeAndIsActiveAndModerationStatus(@Param("date") String date, Pageable pageable);

}
