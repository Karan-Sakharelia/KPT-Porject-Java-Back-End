package springboot.demo.dao;

import springboot.demo.model.User;
import springboot.demo.repo.UserRepository;

public class UserRepositoryDao {

    private final UserRepository userRepository;

    public UserRepositoryDao (UserRepository userRepository){
        System.out.println(userRepository);
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public boolean existsUserInfoByUserId(String userId){
        return userRepository.existsUserInfosByUserId(userId);
    }

    public User getUserByUserId(String userId){
        return userRepository.getUserByUserId(userId);
    }
}
