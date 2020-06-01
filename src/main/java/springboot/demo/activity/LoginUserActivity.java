package springboot.demo.activity;

import springboot.demo.dao.UserRepositoryDao;
import springboot.demo.model.User;

import java.util.Map;

public class LoginUserActivity {
    private final UserRepositoryDao userRepositoryDao;

    public LoginUserActivity(UserRepositoryDao userRepositoryDao){
        this.userRepositoryDao = userRepositoryDao;
    }

    public String handleRequest(Map<String, String> loginDetails){
        validate(loginDetails);
        if(!userRepositoryDao.existsUserInfoByUserId(loginDetails.get("userId"))){
            throw new IllegalArgumentException("The User Id provided doesnt exist");
        }

        String userId = loginDetails.get("userId");
        User user = userRepositoryDao.getUserByUserId(userId);
        if(!user.getPassword().equals(loginDetails.get("password"))){
            throw new IllegalArgumentException("Invalid Password");
        }
        return "User Succesfully Logged In";
    }

    private void validate(Map<String, String> loginDetails) {
        if(loginDetails.get("userId") == null){
            throw new IllegalArgumentException("A user Id is needed");
        }
        if(loginDetails.get("password") == null){
            throw new IllegalArgumentException("A password is needed");
        }
    }
}
