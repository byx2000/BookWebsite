package com.byx.dao;

import com.byx.domain.User;

public interface IUserDao
{
    User getUser(String username);
    User getUser(String username, String password);
}
