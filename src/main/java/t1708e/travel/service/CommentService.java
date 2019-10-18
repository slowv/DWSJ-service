package t1708e.travel.service;

import t1708e.travel.entity.Comment;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class CommentService {
    @WebMethod
    public Comment createComment(Comment comment) {
        return comment;
    }

}
