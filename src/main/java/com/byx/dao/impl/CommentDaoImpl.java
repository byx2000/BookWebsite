package com.byx.dao.impl;

import com.byx.dao.ICommentDao;
import com.byx.domain.Comment;
import com.byx.handler.ResultSetToInt;
import com.byx.handler.ResultSetToList;
import com.byx.handler.ResultSetToSingle;
import com.byx.query.CommentQuery;
import com.byx.util.JDBCTemplate;

import java.util.List;

/**
 * 评论dao实现类
 */
public class CommentDaoImpl implements ICommentDao
{
    @Override
    public int count(CommentQuery query)
    {
        Integer cnt = JDBCTemplate.query("SELECT COUNT(*) FROM comments " + query.getQueryString(),
                new ResultSetToSingle<>(),
                query.getParameters().toArray());
        return cnt == null ? -1 : cnt;
    }

    @Override
    public List<Comment> query(CommentQuery query)
    {
        return JDBCTemplate.query("SELECT * FROM comments " + query.getQueryString(),
                new ResultSetToList<>(Comment.class),
                query.getParameters().toArray());
    }

    @Override
    public int save(Comment comment)
    {
        return JDBCTemplate.update("INSERT INTO comments (bookId, userId, content, time) VALUES (?, ?, ?, ?)",
                comment.getBookId(), comment.getUserId(), comment.getContent(), comment.getTime());
    }
}
