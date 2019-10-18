package t1708e.travel.service;
import t1708e.travel.entity.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService
public class ImageService {
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
    public boolean deleteImage(){
        return true;
    }
}
