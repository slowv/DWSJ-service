package t1708e.assignment.dwjsservice.service;

import example.HelloWorld;
import t1708e.assignment.dwjsservice.entity.Comment;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class CommentService {
    @WebMethod
    public Comment createComment(Comment comment) {
        return comment;
    }

    public static void main(String[] argv) {
        Object implementor = new CommentService();
        String address = "http://localhost:9000/comment";
        Endpoint.publish(address, implementor);
    }
}
