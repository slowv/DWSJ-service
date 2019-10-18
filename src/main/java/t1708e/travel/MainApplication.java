package t1708e.travel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import t1708e.travel.entity.User;
import t1708e.travel.service.*;
import t1708e.travel.util.HibernateUtil;

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
           session.save(User.Builder.anUser()
                   .setUsername("admin2019")
                   .setPassword(passwordEncoder.encode("admin"))
                   .setRole("ADMIN")
                   .build());
           session.getTransaction().commit();
        }
    }

}
