package t1708e.assignment.dwjsservice.service;

import t1708e.assignment.dwjsservice.entity.Comment;
import t1708e.assignment.dwjsservice.entity.Rating;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class RatingSerice {
    @WebMethod
    public Rating createRating(Rating rating) {
        return rating;
    }

    public static void main(String[] argv) {
        Object implementor = new RatingSerice();
        String address = "http://localhost:9000/rating";
        Endpoint.publish(address, implementor);
    }
}
