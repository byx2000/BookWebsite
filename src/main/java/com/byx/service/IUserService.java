package com.byx.service;

import com.byx.domain.ResultInfo;

public interface IUserService
{
    ResultInfo login(String username, String password);
}
