package t1708e.assignment.dwsj.service;

import t1708e.assignment.dwsj.entity.Rating;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RatingService {
    @WebMethod
    public Rating createRating(Rating rating) {
        return rating;
    }
}
