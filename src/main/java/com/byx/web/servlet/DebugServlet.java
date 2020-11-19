package com.byx.web.servlet;

import com.byx.dao.IUserDao;
import com.byx.dao.impl.UserDaoImpl;
import com.byx.domain.User;
import com.byx.query.UserQuery;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/debug")
public class DebugServlet extends BaseServlet
{
    public void debug(HttpServletRequest request, HttpServletResponse response) throws Exception
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
