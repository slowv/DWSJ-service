package t1708e.travel.service;

import t1708e.travel.entity.Place;

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
}
