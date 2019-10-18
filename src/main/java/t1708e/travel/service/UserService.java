package t1708e.travel.service;
import t1708e.travel.entity.User;

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
}
