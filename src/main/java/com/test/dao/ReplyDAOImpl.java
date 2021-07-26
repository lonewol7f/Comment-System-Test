package com.test.dao;

import com.test.entity.Comments;
import com.test.entity.Replies;
import com.test.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Kalana on 26/07/2021
 */

@Repository
public class ReplyDAOImpl implements ReplyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Replies addReply(String reply, String username, int commentId) {

        Session session = sessionFactory.getCurrentSession();

        Users user = userDAO.getUser(username);
        Comments comment = session.get(Comments.class, commentId);

        Replies newReply = new Replies();
        newReply.setReply(reply);
        newReply.setUser(user);
        newReply.setComment(comment);

        int id = (Integer) session.save(newReply);

        return getReplyById(id);
    }

    private Replies getReplyById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Replies.class, id);
    }
}
