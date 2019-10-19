package t1708e.assignment.dwsj.service;
import t1708e.assignment.dwsj.entity.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
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
