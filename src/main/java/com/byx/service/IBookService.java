package com.byx.service;

import com.byx.domain.*;
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
     * 获取搜索建议
     * @param keyword 搜索关键词
     * @param count 建议条数
     * @return 返回客户端的结果
     */
    ResultInfo getSearchSuggestion(String keyword, int count);
}
