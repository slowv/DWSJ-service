package t1708e.assignment.dwjsservice.service;

import t1708e.assignment.dwjsservice.entity.Comment;
import t1708e.assignment.dwjsservice.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService
public class UserService {
    @WebMethod
    public User createUser(User user) {
        return user;
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
