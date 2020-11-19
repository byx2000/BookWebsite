package com.byx.service.impl;

import com.byx.dao.IUserDao;
import com.byx.domain.ResultInfo;
import com.byx.domain.User;
import com.byx.query.UserQuery;
import com.byx.service.IUserService;

import java.util.List;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements IUserService
{
    private final IUserDao userDao;

    public UserServiceImpl(IUserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public ResultInfo login(String username, String password)
    {
        User user = userDao.getUser(username, password);
        if (user == null)
        {
            return ResultInfo.fail("用户名或密码不正确");
        }
        return ResultInfo.success(user);
    }

    @Override
    public ResultInfo query(UserQuery query)
    {
        List<User> users = userDao.query(query);
        if (users == null) return ResultInfo.fail("服务器内部错误");
        return ResultInfo.success(users);
    }
}
