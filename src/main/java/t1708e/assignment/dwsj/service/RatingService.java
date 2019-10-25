package t1708e.assignment.dwsj.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import t1708e.assignment.dwsj.entity.*;
import t1708e.assignment.dwsj.util.HibernateUtil;
import t1708e.assignment.dwsj.util.StringConst;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public class RatingService {
    private Session session = HibernateUtil.getSession();
    @WebMethod
    public Rating createRating(Rating rating, Object obj, String type, User user) {
        session.beginTransaction();
        if (StringConst.TYPE_PLACE.equals(type)){
            Place place = (Place) obj;
            rating.setPlace(place);
        }else if(StringConst.TYPE_IMAGE.equals(type)){
            Image image = (Image) obj;
            rating.setImage(image);
        }
        rating.setUser(user);
        session.saveOrUpdate(rating);
        session.getTransaction().commit();
        return rating;
    }
    @WebMethod
    public Rating findByPlaceOrImage(Object o, String type){
        String sql = "select r from Rating as r";
        if (StringConst.TYPE_PLACE.equals(type)){
            Place place = (Place) o;
            return session.createQuery(sql + " where r.place = :place", Rating.class)
                    .setParameter("place", place).uniqueResult();
        }else if(StringConst.TYPE_IMAGE.equals(type)){
            Image image = (Image) o;
            return session.createQuery(sql + " where r.image = :image", Rating.class)
                    .setParameter("image", image).uniqueResult();
        }
        return null;
    }
}
