package t1708e.assignment.dwjsservice.service;

import t1708e.assignment.dwjsservice.entity.Comment;
import t1708e.assignment.dwjsservice.entity.Place;
import t1708e.assignment.dwjsservice.entity.Place;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService
public class PlaceService {
    @WebMethod
    public Place createPlace(Place place) {
        return place;
    }

    @WebMethod
    public Place updatePlace(Place place){
        return place;
    }

    @WebMethod
    public List<Place> getListPlace(){
        List<Place> places = new ArrayList<>();
        return places;
    }

    @WebMethod
    public boolean deletePlace(){
        return true;
    }

    public static void main(String[] argv) {
        Object implementor = new PlaceService();
        String address = "http://localhost:9000/place";
        Endpoint.publish(address, implementor);
    }
}
