package com.byx.dao;

import com.byx.domain.Book;
import com.byx.query.BookQuery;

import java.util.List;

/**
 * 电子书数据访问接口
 */
public interface IBookDao
{
    /**
     * 查询符合条件的电子书数量
     * @param query 封装查询条件的查询对象
     * @return 数量
     */
    int count(BookQuery query);

    /**
     * 获取符合条件的所有电子书
     * @param query 封装查询条件的查询对象
     * @return 电子书列表
     */
    List<Book> query(BookQuery query);

    /**
     * 搜索建议
     * @param keyword 搜索关键字
     * @param count 数量
     * @return 搜索建议列表
     */
    List<Book> getSearchSuggestion(String keyword, int count);

    /**
     * 同类推荐
     * @param categoryId 类别id
     * @param count 数量
     * @return 推荐列表
     */
    List<Book> getSimilarRecommend(int categoryId, int count);
}
