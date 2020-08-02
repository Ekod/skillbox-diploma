package skillbox.diploma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.Posts;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Integer> {
}
