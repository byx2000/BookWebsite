package com.byx.service;

import com.byx.domain.ResultInfo;
import com.byx.query.BookQuery;

public interface IBookService
{
    /**
     * 多条件查询电子书
     * @param query 封装查询条件的查询对象
     * @return 返回客户端的结果
     */
    ResultInfo query(BookQuery query);

    /**
     * 获取指定数量的随机电子书
     * @param count 数量
     * @return 返回客户端的结果
     */
    ResultInfo getRandomBooks(int count);

    /**
     * 搜索建议
     * @param keyword 搜索关键词
     * @param count 建议条数
     * @return 返回客户端的结果
     */
    ResultInfo getSearchSuggestion(String keyword, int count);

    /**
     * 同类推荐
     * @param categoryId 类别id
     * @param count 数量
     * @return 返回客户端的结果
     */
    ResultInfo getSimilarRecommend(int categoryId, int count);
}
