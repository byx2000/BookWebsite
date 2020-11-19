package com.byx.service;

import com.byx.domain.ResultInfo;
import com.byx.query.UserQuery;

/**
 * 用户服务接口
 */
public interface IUserService
{
    ResultInfo login(String username, String password);
    ResultInfo query(UserQuery query);
}
