package com.byx.web.servlet;

import com.byx.dao.impl.CommentDaoImpl;
import com.byx.domain.ResultInfo;
import com.byx.query.CommentQuery;
import com.byx.service.ICommentService;
import com.byx.service.impl.CommentServiceImpl;
import com.byx.util.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 评论相关接口
 */
@WebServlet("/comment/*")
public class CommentServlet extends BaseServlet
{
    private final ICommentService commentService = new CommentServiceImpl(new CommentDaoImpl());

    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CommentQuery commentQuery = new CommentQuery();
        BeanUtils.populate(commentQuery, request.getParameterMap());
        ResultInfo resultInfo = commentService.query(commentQuery);
        responseResult(response, resultInfo);
    }
}
