package skillbox.diploma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.PostComment;

@Repository
public interface PostCommentRepository extends CrudRepository<PostComment, Integer> {
}
