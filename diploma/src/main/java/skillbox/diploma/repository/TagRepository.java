package skillbox.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.Tag;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tag, Integer> {


}
