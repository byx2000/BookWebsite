package com.byx.web.servlet;

import com.byx.dao.impl.UserDaoImpl;
import com.byx.domain.ResultInfo;
import com.byx.domain.User;
import com.byx.query.UserQuery;
import com.byx.service.IUserService;
import com.byx.service.impl.UserServiceImpl;
import com.byx.util.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户相关接口
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet
{
    private final IUserService userService = new UserServiceImpl(new UserDaoImpl());

    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null)
        {
            responseFailResult(response, "参数错误");
            return;
        }

        ResultInfo resultInfo = userService.login(username, password);
        if (resultInfo.isFlag()) // 登录成功
        {
            request.getSession().setAttribute("user", resultInfo.getData());
        }

        responseResult(response, resultInfo);
    }

    public void current(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null)
        {
            responseFailResult(response, "当前没有登录用户");
            return;
        }

        responseSuccessResult(response, user);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().invalidate();
        responseSuccessResult(response, null);
    }

    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UserQuery userQuery = new UserQuery();
        BeanUtils.populate(userQuery, request.getParameterMap());
        ResultInfo resultInfo = userService.query(userQuery);
        responseResult(response, resultInfo);
    }
}
