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
        return JDBCTemplate.query("SELECT COUNT(*) AS cnt FROM books " + query.getQueryString(),
                new ResultSetToInt(),
                query.getParameters().toArray());
    }

    @Override
    public List<Book> query(BookQuery query)
    {
        return JDBCTemplate.query("SELECT * FROM books " + query.getQueryString(),
                new ResultSetToList<>(Book.class),
                query.getParameters().toArray());
    }
}
