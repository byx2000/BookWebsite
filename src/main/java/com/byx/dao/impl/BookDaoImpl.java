package com.byx.dao.impl;

import com.byx.dao.BaseDao;
import com.byx.dao.IBookDao;
import com.byx.domain.Book;
import com.byx.query.BookQuery;
import com.byx.util.JDBCTemplate;
import com.byx.handler.ResultSetToInt;
import com.byx.handler.ResultSetToList;

import java.util.List;

public class BookDaoImpl extends BaseDao implements IBookDao
{
    @Override
    public int count(BookQuery query)
    {
        Integer cnt = JDBCTemplate.query("SELECT COUNT(*) AS cnt FROM books " + query.getQueryString(),
                new ResultSetToInt(),
                query.getParameters().toArray());
        return cnt == null ? -1 : cnt;
    }

    @Override
    public List<Book> query(BookQuery query)
    {
        return JDBCTemplate.query("SELECT * FROM books " + query.getQueryString(),
                new ResultSetToList<>(Book.class),
                query.getParameters().toArray());
    }

    @Override
    public List<Book> getRandomBooks(int count)
    {
        return JDBCTemplate.query("SELECT * FROM books ORDER BY RANDOM() LIMIT ?",
                new ResultSetToList<>(Book.class),
                count);
    }

    @Override
    public List<Book> getSearchSuggestion(String keyword, int count)
    {
        return JDBCTemplate.query("SELECT * FROM (SELECT * FROM books ORDER BY heat DESC LIMIT ?) ORDER BY RANDOM() LIMIT ?",
                new ResultSetToList<>(Book.class),
                2 * count, count);
    }

    @Override
    public List<Book> getSimilarRecommend(int categoryId, int count)
    {
        return JDBCTemplate.query("SELECT * FROM books WHERE categoryId == ? ORDER BY score DESC LIMIT ?",
                new ResultSetToList<>(Book.class),
                categoryId, count);
    }
}
