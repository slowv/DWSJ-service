package t1708e.assignment.dwsj.service;

import t1708e.assignment.dwsj.entity.Comment;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CommentService {
    @WebMethod
    public Comment createComment(Comment comment) {
        return comment;
    }

}
