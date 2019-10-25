package t1708e.assignment.dwsj.service;

import org.hibernate.Session;
import t1708e.assignment.dwsj.entity.Image;
import t1708e.assignment.dwsj.entity.Place;
import t1708e.assignment.dwsj.util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@WebService
public class PlaceService {
    private static Session session = HibernateUtil.getSession();


    @WebMethod
    public Place createPlace(Place place, ArrayList<Image> images) {
        session.beginTransaction();
        session.saveOrUpdate(place);
        for (Image image : images) {
            image.setPlace(place);
            session.saveOrUpdate(image);
        }
        session.getTransaction().commit();
        return place;
    }

    @WebMethod
    public Place updatePlace(Place place) {
        return place;
    }

    @WebMethod
    public List<Place> getListPlace() {
        return session.createQuery("select p from Place as p", Place.class).getResultList();
    }

    @WebMethod
    public boolean deletePlace() {
        return true;
    }

    @WebMethod
    public Place findById(long id){
        return session.createQuery("select p from Place as p where p.id = :id", Place.class)
                .setParameter("id", id).uniqueResult();
    }
//
//    public static void main(String[] args) {
//        List<Place> places = session.createQuery("select p from Place as p", Place.class).getResultList();
//        for (Place place: places) {
//            for (Image image: place.getImages(place)) {
//                System.out.println(image.getName());
//            }
//        }
//    }
}
