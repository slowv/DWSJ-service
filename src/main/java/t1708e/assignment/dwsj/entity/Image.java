package t1708e.assignment.dwsj.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String source;
    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "placeId")
    private Place place;
    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL)
    private Set<Rating> ratings;
    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL)
    private Set<Comment> comments;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;

    public Image() {
        long now = System.currentTimeMillis();
        this.createdAt = now;
        this.updatedAt = now;
        this.status = 1;
    }
}
