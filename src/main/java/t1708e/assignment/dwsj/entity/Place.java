package t1708e.assignment.dwsj.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private Set<Image> images;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private Set<Rating> ratings;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private Set<Comment> comments;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;

    public Place() {
        long now = System.currentTimeMillis();
        this.createdAt = now;
        this.updatedAt = now;
        this.status = 1;
    }
}
