package skillbox.diploma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
