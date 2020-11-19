package com.byx.web.servlet;

import com.byx.dao.ICategoryDao;
import com.byx.dao.ICommentDao;
import com.byx.dao.IUserDao;
import com.byx.dao.impl.BookDaoImpl;
import com.byx.dao.impl.CategoryDaoImpl;
import com.byx.dao.impl.CommentDaoImpl;
import com.byx.dao.impl.UserDaoImpl;
import com.byx.domain.*;
import com.byx.query.BookQuery;
import com.byx.query.CategoryQuery;
import com.byx.query.CommentQuery;
import com.byx.query.UserQuery;
import com.byx.service.IBookService;
import com.byx.service.impl.BookServiceImpl;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet("/debug")
public class DebugServlet extends BaseServlet
{
    public void debug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        IUserDao dao = new UserDaoImpl();
        UserQuery query = new UserQuery();
        query.setUsername("fff");
        List<User> users = dao.query(query);
        System.out.println(users.size());
        for (User u : users)
        {
            System.out.println(u);
        }
    }
}
