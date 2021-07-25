package com.test.dao;

import com.test.entity.Comments;
import com.test.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kalana on 20/07/2021
 */

@Repository
public class CommentDAOImpl implements CommentDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<Comments> getComments() {

        Session session = sessionFactory.getCurrentSession();
        
        Query<Comments> commentsQuery = session.createQuery("from Comments order by id desc", Comments.class);
        List<Comments> comments = commentsQuery.getResultList();
        
        return comments;

    }

    @Override
    public Comments addComment(String username, String comment) {

        Session session = sessionFactory.getCurrentSession();

        Users user = userDAO.getUser(username);

        Comments newComment = new Comments();
        newComment.setComment(comment);
        newComment.setUser(user);

        int id = (Integer) session.save(newComment);

        return getCommentById(id);

    }


    private Comments getCommentById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Comments> commentsQuery = session.createQuery("from Comments where id =: id", Comments.class);
        commentsQuery.setParameter("id", id);

        return commentsQuery.getSingleResult();
    }
}
