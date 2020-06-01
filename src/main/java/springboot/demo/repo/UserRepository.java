package springboot.demo.repo;

import org.springframework.stereotype.Repository;
import springboot.demo.model.User;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public boolean existsUserInfosByUserId(String userId);

    public User getUserByUserId(String userId);
}
