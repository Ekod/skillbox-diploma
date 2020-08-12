package skillbox.diploma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.PostVote;

@Repository
public interface PostVoteRepository extends CrudRepository<PostVote, Integer> {
}
