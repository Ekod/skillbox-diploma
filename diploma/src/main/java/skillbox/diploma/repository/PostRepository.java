package skillbox.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.Post;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
}
