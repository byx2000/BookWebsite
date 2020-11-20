package com.byx.service.impl;

import com.byx.dao.IBookDao;
import com.byx.domain.Book;
import com.byx.query.BookQuery;
import com.byx.domain.PageBean;
import com.byx.domain.ResultInfo;
import com.byx.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService
{
    private final IBookDao bookDao;

    public BookServiceImpl(IBookDao bookDao)
    {
        this.bookDao = bookDao;
    }

    @Override
    public ResultInfo query(BookQuery query)
    {
        // 获取查询结果列表
        List<Book> books = bookDao.query(query);
        if (books == null) return ResultInfo.fail("服务器内部错误");

        // 不带分页的查询：直接返回结果列表
        if (query.getPageSize() == null || query.getCurrentPage() == null)
        {
            return ResultInfo.success(books);
        }
        // 带分页的查询：返回PageBean
        else
        {
            // 获取每页大小和当前页
            int pageSize = query.getPageSize();
            int currentPage = query.getCurrentPage();

            // 计算总页数
            query.setPageSize(null);
            query.setCurrentPage(null);
            int totalCount = bookDao.count(query);
            if (totalCount < 0) return ResultInfo.fail("服务器内部错误");

            // 组装PageBean
            PageBean<Book> pageBean = new PageBean<>();
            pageBean.setPageSize(pageSize);
            pageBean.setCurrentPage(currentPage);
            pageBean.setTotalCount(totalCount);
            int totalPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
            pageBean.setTotalPage(totalPage);
            pageBean.setData(books);

            return ResultInfo.success(pageBean);
        }
    }

    @Override
    public ResultInfo getSearchSuggestion(String keyword, int count)
    {
        List<Book> books = bookDao.getSearchSuggestion(keyword, count);
        if (books == null) return ResultInfo.fail("服务器内部错误");
        return ResultInfo.success(books);
    }

    @Override
    public ResultInfo getSimilarRecommend(int categoryId, int count)
    {
        List<Book> books = bookDao.getSimilarRecommend(categoryId, count);
        if (books == null) return ResultInfo.fail("服务器内部错误");
        return ResultInfo.success(books);
    }
}
