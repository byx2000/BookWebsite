package com.byx.service;

import com.byx.domain.ResultInfo;
import com.byx.query.CategoryQuery;

public interface ICategoryService
{
    ResultInfo query(CategoryQuery query);
}
