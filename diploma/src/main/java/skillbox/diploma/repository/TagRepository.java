package skillbox.diploma.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.Tag;

import java.util.List;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tag, Integer> {
    List<Tag> findAllByName(String tag, Pageable pageable);
}
