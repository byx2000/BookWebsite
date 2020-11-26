package com.byx.dao;

import com.byx.domain.Comment;
import com.byx.query.CommentQuery;

import java.util.List;

/**
 * 评论dao接口
 */
public interface ICommentDao
{
    /**
     * 查询满足条件的评论数量
     * @param query 查询条件
     * @return 结果总数，若查询失败，返回-1
     */
    int count(CommentQuery query);

    /**
     * 根据条件查询评论
     * @param query 查询条件
     * @return 查询结果
     */
    List<Comment> query(CommentQuery query);

    /**
     * 保存评论
     * @param comment 评论数据
     * @return 影响行数，若保存失败，则返回-1
     */
    int save(Comment comment);
}
