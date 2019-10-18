package t1708e.travel;

import org.hibernate.Session;
import t1708e.travel.service.*;
import t1708e.travel.util.HibernateUtil;

import javax.xml.ws.Endpoint;

public class MainApplication {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
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
}
