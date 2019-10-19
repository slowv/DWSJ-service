package t1708e.assignment.dwsj.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Comment> comments;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Rating> ratings;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;

    public User() {
        long now = System.currentTimeMillis();
        this.createdAt = now;
        this.updatedAt = now;
        this.status = 1;
    }

    public static final class Builder {
        private String username;
        private String password;
        private String role;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            return user;
        }
    }
}
