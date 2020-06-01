package springboot.demo.model;

import lombok.Value;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Value
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "Password")
    private String password;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "time")
    private String time;

    public User(){
        time = "";
        email = "";
        name = "";
        userId = "";
        password = "";
        id = 0;

    }

    public void validate(){
        if(userId == null || userId.trim().equals("")){
            throw new IllegalArgumentException("User Id cannot be left blank");
        }
        if(password == null || password.trim().equals("")){
            throw new IllegalArgumentException("Password cannot be left blank");
        }
        if(name == null || name.trim().equals("")){
            throw new IllegalArgumentException("Name cannot be left blank");
        }
        if(email == null || email.trim().equals("") || !isValidEmail()){
            throw new IllegalArgumentException("Invalid Email");
        }
    }

    private boolean isValidEmail() {
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        return email.matches(regex);
    }
}
