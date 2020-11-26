package com.byx.service.impl;

import com.byx.dao.ICommentDao;
import com.byx.domain.Comment;
import com.byx.domain.PageBean;
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
        /*List<Comment> comments = commentDao.query(query);
        if (comments == null) return ResultInfo.fail("服务器内部错误");
        return ResultInfo.success(comments);*/

        // 获取查询结果列表
        List<Comment> comments = commentDao.query(query);
        if (comments == null) return ResultInfo.fail("服务器内部错误");

        // 不带分页的查询：直接返回结果列表
        if (query.getPageSize() == null || query.getCurrentPage() == null)
        {
            return ResultInfo.success(comments);
        }
        // 带分页的查询：返回PageBean
        else
        {
            // 获取每页大小和当前页
            int pageSize = query.getPageSize();
            int currentPage = query.getCurrentPage();

            // 计算总页数
            query.setPageSize(null);
            query.setCurrentPage(null);
            int totalCount = commentDao.count(query);
            if (totalCount < 0) return ResultInfo.fail("服务器内部错误");

            // 组装PageBean
            PageBean<Comment> pageBean = new PageBean<>();
            pageBean.setPageSize(pageSize);
            pageBean.setCurrentPage(currentPage);
            pageBean.setTotalCount(totalCount);
            int totalPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
            pageBean.setTotalPage(totalPage);
            pageBean.setData(comments);

            return ResultInfo.success(pageBean);
        }
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
