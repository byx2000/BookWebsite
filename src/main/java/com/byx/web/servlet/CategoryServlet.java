package com.byx.web.servlet;

import com.byx.dao.impl.CategoryDaoImpl;
import com.byx.domain.ResultInfo;
import com.byx.query.CategoryQuery;
import com.byx.service.ICategoryService;
import com.byx.service.impl.CategoryServiceImpl;
import com.byx.util.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 电子书类型相关接口
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet
{
    private final ICategoryService categoryService = new CategoryServiceImpl(new CategoryDaoImpl());

    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CategoryQuery categoryQuery = new CategoryQuery();
        BeanUtils.populate(categoryQuery, request.getParameterMap());
        ResultInfo resultInfo = categoryService.query(categoryQuery);
        responseResult(response, resultInfo);
    }
}
