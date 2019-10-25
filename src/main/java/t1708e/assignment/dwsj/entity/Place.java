package t1708e.assignment.dwsj.entity;

import lombok.Data;
import t1708e.assignment.dwsj.service.ImageService;
import t1708e.assignment.dwsj.service.PlaceService;
import t1708e.assignment.dwsj.service.RatingService;
import t1708e.assignment.dwsj.util.StringConst;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Image> images;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private Set<Rating> ratings;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private Set<Comment> comments;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;

    private static ImageService imageService = null;
    private static RatingService ratingService = null;

    public Place() {
        long now = System.currentTimeMillis();
        this.createdAt = now;
        this.updatedAt = now;
        this.status = 1;
    }

    public Rating getRatingBiggest(Place place){
        if (ratingService == null){
            ratingService =  new RatingService();
        }
        return ratingService.findByPlaceOrImage(place, StringConst.TYPE_PLACE);
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public List<Image> getImages(Place place){
        if (imageService == null){
            imageService = new ImageService();
        }
        return imageService.getImagesByPlace(place);
    }
}
