package t1708e.assignment.dwsj.service;
import org.hibernate.Session;
import t1708e.assignment.dwsj.entity.Image;
import t1708e.assignment.dwsj.entity.Place;
import t1708e.assignment.dwsj.util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class ImageService {
    private static Session session = HibernateUtil.getSession();
    @WebMethod
    public Image createImage(Image image) {
        return image;
    }

    @WebMethod
    public Image updateImage(Image image){
        return image;
    }

    @WebMethod
    public List<Image> getListImage(){
        List<Image> images = new ArrayList<>();
        return images;
    }

    @WebMethod
    public List<Image> getImagesByPlace(Place place){
        return session.createQuery("select i from Image as i where i.place = :place", Image.class)
                .setParameter("place", place).getResultList();
    }

    @WebMethod
    public boolean deleteImage(){
        return true;
    }
}
