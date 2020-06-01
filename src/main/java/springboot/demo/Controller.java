package springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import springboot.demo.activity.LoginUserActivity;
import springboot.demo.activity.RegisterUserActivity;
import springboot.demo.dao.UserRepositoryDao;
import springboot.demo.model.User;
import springboot.demo.repo.UserRepository;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    UserRepository userRepository;
    UserRepositoryDao userRepositoryDao;

    @Bean
    public String createUserRepoDao(){
        userRepositoryDao= new UserRepositoryDao(userRepository);
        return "";
    }

    @PostMapping("/login")
    public String loginRequest(@RequestBody(required=true)Map<String, String> credentials){
        new LoginUserActivity(userRepositoryDao).handleRequest(credentials);
        return "Logged in";
    }

    @PostMapping("/register")
    public String registerRequest(@RequestBody(required=true) User user){
        new RegisterUserActivity(userRepositoryDao).handleRequest(user);
        return "Success";
    }

}
