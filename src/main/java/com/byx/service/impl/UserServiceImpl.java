package com.byx.service.impl;

import com.byx.dao.IUserDao;
import com.byx.domain.ResultInfo;
import com.byx.domain.User;
import com.byx.service.IUserService;

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
}
