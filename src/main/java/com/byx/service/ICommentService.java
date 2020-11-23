package com.byx.service;

import com.byx.domain.Comment;
import com.byx.domain.ResultInfo;
import com.byx.query.CommentQuery;

/**
 * 评论服务接口
 */
public interface ICommentService
{
    /**
     * 根据条件查询评论
     * @param query 查询条件
     * @return 查询结果
     */
    ResultInfo query(CommentQuery query);

    /**
     * 保存评论
     * @param comment 评论数据
     * @return 执行结果
     */
    ResultInfo save(Comment comment);
}
