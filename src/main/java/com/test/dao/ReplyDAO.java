package com.test.dao;

import com.test.entity.Replies;

/**
 * Created by Kalana on 26/07/2021
 */

public interface ReplyDAO {
    Replies addReply(String reply, String username, int commentId);
}
