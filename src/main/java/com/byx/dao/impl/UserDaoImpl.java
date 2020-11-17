package com.byx.dao.impl;

import com.byx.dao.BaseDao;
import com.byx.dao.IUserDao;
import com.byx.domain.User;
import com.byx.util.JDBCTemplate;
import com.byx.handler.ResultSetToObject;

public class UserDaoImpl extends BaseDao implements IUserDao
{
    @Override
    public User getUser(String username)
    {
        return JDBCTemplate.query("SELECT * FROM users WHERE username == ?",
                new ResultSetToObject<>(User.class),
                username);
    }

    @Override
    public User getUser(String username, String password)
    {
        return JDBCTemplate.query("SELECT * FROM users WHERE username == ? AND password == ?",
                new ResultSetToObject<>(User.class),
                username, password);
    }
}
