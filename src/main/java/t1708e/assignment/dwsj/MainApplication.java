package t1708e.assignment.dwsj;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.crypto.password.PasswordEncoder;
import t1708e.assignment.dwsj.entity.User;
import t1708e.assignment.dwsj.service.*;
import t1708e.assignment.dwsj.util.HibernateUtil;
import t1708e.assignment.dwsj.util.bcrypt.BCryptPasswordEncoder;

import javax.xml.ws.Endpoint;

public class MainApplication {
    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        // Fixed account Admin
        fixedAccountAdmin(session);

        // Publish Endpoint Web service
        String address = "http://localhost:9000";
        // Image
        Endpoint.publish(address + "/image", new ImageService());
        //Comment
        Endpoint.publish(address + "/comment", new CommentService());
        // Place
        Endpoint.publish(address + "/place", new PlaceService());
        //Rating
        Endpoint.publish(address + "/rating", new RatingService());
        // User
        Endpoint.publish(address + "/user", new UserService());
        System.out.println("Server is running!");
    }

    private static void fixedAccountAdmin(Session session) {
        Criteria criteria = session.createCriteria(User.class)
                .add(Restrictions.eq("role", "ADMIN"));
        Object result = criteria.uniqueResult();
        if (result == null){
           session.beginTransaction();
           session.save(User.Builder.newBuilder()
                   .setUsername("admin")
                   .setPassword(passwordEncoder.encode("Abc/123456"))
                   .setRole("ADMIN")
                   .build());
           session.getTransaction().commit();
        }
    }

}
