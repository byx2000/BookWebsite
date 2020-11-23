package com.byx.service.impl;

import com.byx.dao.ICommentDao;
import com.byx.domain.Comment;
import com.byx.domain.ResultInfo;
import com.byx.query.CommentQuery;
import com.byx.service.ICommentService;
import com.byx.util.DateUtils;

import java.util.List;

/**
 * 评论服务实现类
 */
public class CommentServiceImpl implements ICommentService
{
    private final ICommentDao commentDao;

    public CommentServiceImpl(ICommentDao commentDao)
    {
        this.commentDao = commentDao;
    }

    @Override
    public ResultInfo query(CommentQuery query)
    {
        List<Comment> comments = commentDao.query(query);
        if (comments == null) return ResultInfo.fail("服务器内部错误");
        return ResultInfo.success(comments);
    }

    @Override
    public ResultInfo save(Comment comment)
    {
        comment.setTime(DateUtils.now());
        int count = commentDao.save(comment);
        if (count < 0) return ResultInfo.fail("服务器内部错误");
        return ResultInfo.success(null);
    }
}
