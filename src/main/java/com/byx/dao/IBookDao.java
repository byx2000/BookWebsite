package com.byx.dao;

import com.byx.domain.Book;
import com.byx.query.BookQuery;

import java.util.List;

public interface IBookDao
{
    /**
     * 获取符合条件的电子书数量
     * @param query 封装查询条件的查询对象
     * @return 数目数量
     */
    int count(BookQuery query);

    /**
     * 获取符合条件的所有电子书
     * @param query 封装查询条件的查询对象
     * @return 电子书列表
     */
    List<Book> query(BookQuery query);

    /**
     * 获取搜索建议
     * @param keyword 搜索关键字
     * @param count 建议条数
     * @return 搜索建议列表
     */
    List<Book> getSearchSuggestion(String keyword, int count);
}
