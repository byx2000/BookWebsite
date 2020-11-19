package com.byx.dao;

import com.byx.domain.Comment;
import com.byx.query.CommentQuery;

import java.util.List;

/**
 * 评论dao接口
 */
public interface ICommentDao
{
    List<Comment> query(CommentQuery query);
}
