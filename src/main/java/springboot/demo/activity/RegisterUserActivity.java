package springboot.demo.activity;

import springboot.demo.dao.UserRepositoryDao;
import springboot.demo.model.User;


public class RegisterUserActivity {

    private final UserRepositoryDao userRepositoryDao;
    public RegisterUserActivity(UserRepositoryDao userRepositoryDao){
        this.userRepositoryDao = userRepositoryDao;
    }

    public String handleRequest(User user){
        if(userRepositoryDao.existsUserInfoByUserId(user.getUserId())){
            throw new IllegalArgumentException("The User Id needs to be Unique");
        }
        user.validate();
        userRepositoryDao.save(user);
        return "User Succesfully Registered";
    }
}
