package skillbox.diploma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
}
