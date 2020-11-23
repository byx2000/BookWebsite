package com.byx.web.servlet;

import com.byx.dao.IUserDao;
import com.byx.dao.impl.UserDaoImpl;
import com.byx.domain.User;
import com.byx.handler.ResultSetToList;
import com.byx.query.UserQuery;
import com.byx.util.JDBCTemplate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/debug")
public class DebugServlet extends BaseServlet
{
    public void debug(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

    }
}
