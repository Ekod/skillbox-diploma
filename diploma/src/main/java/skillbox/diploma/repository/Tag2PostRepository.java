package skillbox.diploma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.Tag2Post;

@Repository
public interface Tag2PostRepository extends CrudRepository<Tag2Post, Integer> {
}
