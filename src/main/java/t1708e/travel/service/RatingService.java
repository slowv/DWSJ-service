package t1708e.travel.service;

import t1708e.travel.entity.Rating;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class RatingService {
    @WebMethod
    public Rating createRating(Rating rating) {
        return rating;
    }
}
