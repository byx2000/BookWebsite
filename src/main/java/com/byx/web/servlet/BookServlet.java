package com.byx.web.servlet;

import com.byx.dao.impl.BookDaoImpl;
import com.byx.query.BookQuery;
import com.byx.domain.ResultInfo;
import com.byx.service.IBookService;
import com.byx.service.impl.BookServiceImpl;
import com.byx.util.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 电子书相关接口
 */
@WebServlet("/book/*")
public class BookServlet extends BaseServlet
{
    private final IBookService bookService = new BookServiceImpl(new BookDaoImpl());

    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        BookQuery bookQuery = new BookQuery();
        BeanUtils.populate(bookQuery, request.getParameterMap());
        ResultInfo resultInfo = bookService.query(bookQuery);
        responseResult(response, resultInfo);
    }
}
