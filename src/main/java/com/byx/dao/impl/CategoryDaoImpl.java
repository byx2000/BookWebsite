package com.byx.dao.impl;

import com.byx.dao.BaseDao;
import com.byx.dao.ICategoryDao;
import com.byx.domain.Category;
import com.byx.query.CategoryQuery;
import com.byx.util.JDBCTemplate;
import com.byx.handler.ResultSetToList;

import java.util.List;

public class CategoryDaoImpl extends BaseDao implements ICategoryDao
{
    @Override
    public List<Category> query(CategoryQuery query)
    {
        return JDBCTemplate.query("SELECT * FROM categories " + query.getQueryString(),
                new ResultSetToList<>(Category.class),
                query.getParameters().toArray());
    }
}
