package t1708e.assignment.dwjsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import t1708e.assignment.dwjsservice.entity.Comment;
import t1708e.assignment.dwjsservice.entity.User;
import t1708e.assignment.dwjsservice.repository.UserRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @WebMethod
    public User register(User user) {
        String oldPass = user.getPassword();
        user.setPassword(passwordEncoder.encode(oldPass));
        userRepository.save(user);
        return user;
    }
    @WebMethod
    public User login(){
        return null;
    }
    @WebMethod
    public User updateUser(User user){
        return user;
    }

    @WebMethod
    public List<User> getListUser(){
        List<User> users = new ArrayList<>();
        return users;
    }

    @WebMethod
    public boolean deleteUser(){
        return true;
    }


    public static void main(String[] argv) {
        Object implementor = new UserService();
        String address = "http://localhost:9000/user";
        Endpoint.publish(address, implementor);
    }
}
