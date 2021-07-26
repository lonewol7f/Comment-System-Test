package com.test.service;

import com.test.dao.ReplyDAO;
import com.test.entity.Replies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kalana on 26/07/2021
 */

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDAO replyDAO;

    @Override
    @Transactional
    public Replies addReply(String reply, String username, int commentId) {
        return replyDAO.addReply(reply, username, commentId);
    }
}
