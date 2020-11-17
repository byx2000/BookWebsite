package com.byx.web.servlet;

import com.byx.dao.ICategoryDao;
import com.byx.dao.impl.BookDaoImpl;
import com.byx.dao.impl.CategoryDaoImpl;
import com.byx.domain.*;
import com.byx.query.BookQuery;
import com.byx.query.CategoryQuery;
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
    private DataSource getDataSource()
    {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.sqlite.JDBC");
        ds.setUrl("jdbc:sqlite:D:/Programs/项目-2020/JavaWeb/BookWebsite/test.db");
        return ds;
    }

    public void debug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            DataSource ds = getDataSource();
            Connection conn = ds.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM books");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            for (int i = 0; i < 10; ++i)
            {
                System.out.println(rs.getObject("name"));
                rs.next();
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
