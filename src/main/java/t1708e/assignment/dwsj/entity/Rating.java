package t1708e.assignment.dwsj.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double point;
    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "placeId")
    private Place place;
    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "imageId")
    private Image image;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;

    public Rating() {
        long now = System.currentTimeMillis();
        this.createdAt = now;
        this.updatedAt = now;
        this.status = 1;
    }
}
