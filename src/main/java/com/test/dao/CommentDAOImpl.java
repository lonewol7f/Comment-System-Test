package com.test.dao;

import com.test.entity.Comments;
import com.test.entity.Replies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kalana on 20/07/2021
 */

@Repository
public class CommentDAOImpl implements CommentDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<List<Object>> getComments() {

        Session session = sessionFactory.getCurrentSession();

        List<List<Object>> mainList = new ArrayList<>();

        Query<Comments> commentsQuery = session.createQuery("from Comments",Comments.class);

        List<Comments> comments = commentsQuery.getResultList();

        for (Comments comment :comments) {
            List<Object> secondaryList = new ArrayList<>();
            Query<Replies> repliesQuery = session.createQuery("from Replies where comment_id = :commentId",Replies.class);
            repliesQuery.setParameter("commentId", comment.getId());

            List<Replies> replies = repliesQuery.getResultList();

            secondaryList.add(comment);
            secondaryList.add(replies);

            mainList.add(secondaryList);
        }

        return mainList;

    }
}
