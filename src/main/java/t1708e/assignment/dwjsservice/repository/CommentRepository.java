package t1708e.assignment.dwjsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t1708e.assignment.dwjsservice.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
