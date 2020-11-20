package com.byx.web.servlet;

import com.byx.dao.impl.BookDaoImpl;
import com.byx.domain.ResultInfo;
import com.byx.query.BookQuery;
import com.byx.service.IBookService;
import com.byx.service.impl.BookServiceImpl;
import com.byx.util.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 电子书相关接口
 */
@WebServlet("/book/*")
public class BookServlet extends BaseServlet
{
    private final IBookService bookService = new BookServiceImpl(new BookDaoImpl());

    /**
     * 查询电子书
     * @param request
     * @param response
     * @throws Exception
     */
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        BookQuery bookQuery = new BookQuery();
        BeanUtils.populate(bookQuery, request.getParameterMap());
        ResultInfo resultInfo = bookService.query(bookQuery);
        responseResult(response, resultInfo);
    }

    /**
     * 搜索建议
     * @param request
     * @param response
     * @throws Exception
     */
    public void searchSuggestion(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String keyword = request.getParameter("keyword");
        if (keyword == null)
        {
            responseFailResult(response, "参数错误");
            return;
        }

        int count;
        try
        {
            count = Integer.parseInt(request.getParameter("count"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            responseFailResult(response, "参数错误");
            return;
        }

        ResultInfo resultInfo = bookService.getSearchSuggestion(keyword, count);
        responseResult(response, resultInfo);
    }

    /**
     * 同类推荐
     * @param request
     * @param response
     * @throws Exception
     */
    public void similarRecommend(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        int categoryId, count;
        try
        {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));
            count = Integer.parseInt(request.getParameter("count"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            responseFailResult(response, "参数错误");
            return;
        }

        ResultInfo resultInfo = bookService.getSimilarRecommend(categoryId, count);
        responseResult(response, resultInfo);
    }
}
