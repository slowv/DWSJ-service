package t1708e.assignment.dwsj.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import t1708e.assignment.dwsj.entity.Comment;
import t1708e.assignment.dwsj.entity.Image;
import t1708e.assignment.dwsj.entity.Place;
import t1708e.assignment.dwsj.entity.User;
import t1708e.assignment.dwsj.util.HibernateUtil;
import t1708e.assignment.dwsj.util.StringConst;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@WebService
public class CommentService {
    private Session session = HibernateUtil.getSession();
    @WebMethod
    public Comment createComment(Comment comment, Object obj, String type, User user) {
        session.beginTransaction();
        if (StringConst.TYPE_PLACE.equals(type)){
            Place place = (Place) obj;
            comment.setPlace(place);
        }else if(StringConst.TYPE_IMAGE.equals(type)){
            Image image = (Image) obj;
            comment.setImage(image);
        }
        comment.setUser(user);
        session.saveOrUpdate(comment);
        session.getTransaction().commit();
        return comment;
    }

    @WebMethod
    public List<Comment> getCommentByPlaceOrImage (String type, Object obj){
        String sql = "select c from Comment as c";
        Query query = null;
        if (StringConst.TYPE_PLACE.equals(type)){
            Place place = (Place) obj;
            query = session.createQuery(sql + " where c.place = :place", Comment.class).setParameter("place", place);
        }else if(StringConst.TYPE_IMAGE.equals(type)){
            Image image = (Image) obj;
            query = session.createQuery(sql + " where c.image = :image", Comment.class).setParameter("image", image);
        }
        return query == null ? new ArrayList<>() : query.getResultList();
    }

}
