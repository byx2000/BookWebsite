package com.byx.service.impl;

import com.byx.dao.ICategoryDao;
import com.byx.domain.Category;
import com.byx.domain.ResultInfo;
import com.byx.query.CategoryQuery;
import com.byx.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService
{
    private final ICategoryDao categoryDao;

    public CategoryServiceImpl(ICategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
    }

    @Override
    public ResultInfo query(CategoryQuery query)
    {
        List<Category> categories = categoryDao.query(query);
        if (categories == null) return ResultInfo.fail("服务器内部错误");
        if (categories.isEmpty()) return ResultInfo.fail("类别不存在");
        return ResultInfo.success(categories);
    }
}
