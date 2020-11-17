package com.byx.dao;

import com.byx.domain.Book;
import com.byx.query.BookQuery;

import java.util.List;

public interface IBookDao
{
    int count(BookQuery query);
    List<Book> query(BookQuery query);
}
