package com.test.service;

import com.test.entity.Replies;

/**
 * Created by Kalana on 26/07/2021
 */

public interface ReplyService {
    Replies addReply(String reply, String username, int commentId);
}
