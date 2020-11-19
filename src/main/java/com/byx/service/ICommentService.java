package com.byx.service;

import com.byx.domain.ResultInfo;
import com.byx.query.CommentQuery;

/**
 * 评论服务接口
 */
public interface ICommentService
{
    ResultInfo query(CommentQuery query);
}
