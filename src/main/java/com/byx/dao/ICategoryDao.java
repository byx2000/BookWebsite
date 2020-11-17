package com.byx.dao;

import com.byx.domain.Category;
import com.byx.query.CategoryQuery;

import java.util.List;

public interface ICategoryDao
{
    List<Category> query(CategoryQuery query);
}
