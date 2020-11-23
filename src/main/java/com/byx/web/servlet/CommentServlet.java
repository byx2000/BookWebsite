package com.byx.web.servlet;

import com.byx.dao.impl.CommentDaoImpl;
import com.byx.domain.Comment;
import com.byx.domain.ResultInfo;
import com.byx.domain.User;
import com.byx.query.CommentQuery;
import com.byx.service.ICommentService;
import com.byx.service.impl.CommentServiceImpl;
import com.byx.util.BeanUtils;
import org.sqlite.util.StringUtils;

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

    /**
     * 查询评论
     * @param request
     * @param response
     * @throws Exception
     */
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CommentQuery commentQuery = new CommentQuery();
        BeanUtils.populate(commentQuery, request.getParameterMap());
        ResultInfo resultInfo = commentService.query(commentQuery);
        responseResult(response, resultInfo);
    }

    /**
     * 添加评论
     * @param request
     * @param response
     * @throws Exception
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // 检查当前是否登录
        User user = (User)request.getSession().getAttribute("user");
        if (user == null)
        {
            responseFailResult(response, "当前未登录");
            return;
        }

        int bookId;
        try
        {
            bookId = Integer.parseInt(request.getParameter("bookId"));

        }
        catch (Exception e)
        {
            responseFailResult(response, "参数错误");
            return;
        }

        String content = request.getParameter("content");
        if (content == null || "".equals(content))
        {
            responseFailResult(response, "参数错误");
            return;
        }

        Comment comment = new Comment();
        comment.setBookId(bookId);
        comment.setUserId(user.getId());
        comment.setContent(content);

        ResultInfo resultInfo = commentService.save(comment);
        responseResult(response, resultInfo);
    }
}
