package skillbox.diploma.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.Tag;

import java.util.List;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tag, Integer> {

    @Query(value = "select t from tags t join tag2post on t.id = tag2post.tagId join posts on tag2post.postId = posts.id " +
            "where tags.name = :tagName and posts.isActive = 1 and posts.moderationStatus = 'ACCEPTED'")
    List<Tag> findAllByName(@Param("tagName") String tag, Pageable pageable);
}
