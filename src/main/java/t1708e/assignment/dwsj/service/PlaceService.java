package t1708e.assignment.dwsj.service;

import t1708e.assignment.dwsj.entity.Place;

import javax.jws.WebMethod;
import javax.jws.WebService;
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
