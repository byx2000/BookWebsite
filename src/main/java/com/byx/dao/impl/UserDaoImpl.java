package com.byx.dao.impl;

import com.byx.dao.BaseDao;
import com.byx.dao.IUserDao;
import com.byx.domain.User;
import com.byx.handler.ResultSetToList;
import com.byx.query.UserQuery;
import com.byx.util.JDBCTemplate;
import com.byx.handler.ResultSetToObject;

import java.util.List;

/**
 * 用户dao实现类
 */
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

    @Override
    public List<User> query(UserQuery query)
    {
        return JDBCTemplate.query("SELECT * FROM users " + query.getQueryString(),
                new ResultSetToList<>(User.class),
                query.getParameters().toArray());
    }
}
