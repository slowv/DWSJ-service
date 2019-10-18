package t1708e.travel.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import t1708e.travel.entity.User;
import t1708e.travel.util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService
public class UserService {
    private static Session session = HibernateUtil.getSession();

    @WebMethod
    public User register(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println(user.getUsername());
        return user;
    }

    @WebMethod
    public User login(User user) {
        User userResult = findByUsername(user.getUsername());
        System.out.println(userResult.getUsername());
        return userResult;
    }

    @WebMethod
    public User updateUser(User user) {
        return user;
    }

    @WebMethod
    public List<User> getListUser() {
        List<User> users = new ArrayList<>();
        return users;
    }

    @WebMethod
    public boolean deleteUser() {
        return true;
    }


    public User findByUsername(String username) {
        Criteria criteria = session.createCriteria(User.class)
                .add(Restrictions.eq("username", username));
        Object result = criteria.uniqueResult();
        if (result != null){
            return (User) result;
        }
        return null;
    }
}
