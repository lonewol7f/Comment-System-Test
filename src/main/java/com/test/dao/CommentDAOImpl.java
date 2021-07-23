package com.test.dao;

import com.test.entity.Comments;
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

    @Override
    public List<Comments> getComments() {

        Session session = sessionFactory.getCurrentSession();
        
        Query<Comments> commentsQuery = session.createQuery("from Comments order by id desc", Comments.class);
        List<Comments> comments = commentsQuery.getResultList();
        
        return comments;

    }
}
