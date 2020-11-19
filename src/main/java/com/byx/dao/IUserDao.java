package com.byx.dao;

import com.byx.domain.User;
import com.byx.query.UserQuery;

import java.util.List;

/**
 * 用户dao接口
 */
public interface IUserDao
{
    User getUser(String username);
    User getUser(String username, String password);
    List<User> query(UserQuery query);
}
