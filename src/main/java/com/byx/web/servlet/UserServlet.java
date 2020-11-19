package com.byx.web.servlet;

import com.byx.dao.impl.UserDaoImpl;
import com.byx.domain.ResultInfo;
import com.byx.domain.User;
import com.byx.query.UserQuery;
import com.byx.service.IUserService;
import com.byx.service.impl.UserServiceImpl;
import com.byx.util.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户相关接口
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet
{
    private final IUserService userService = new UserServiceImpl(new UserDaoImpl());

    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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

    /**
     * 获取当前登录用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void current(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null)
        {
            responseFailResult(response, "当前没有登录用户");
            return;
        }

        responseSuccessResult(response, user);
    }

    /**
     * 注销
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getSession().invalidate();
        responseSuccessResult(response, null);
    }

    /**
     * 查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UserQuery userQuery = new UserQuery();
        BeanUtils.populate(userQuery, request.getParameterMap());
        ResultInfo resultInfo = userService.query(userQuery);
        responseResult(response, resultInfo);
    }
}
