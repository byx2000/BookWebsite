package com.byx.service;

import com.byx.domain.*;
import com.byx.query.BookQuery;

public interface IBookService
{
    ResultInfo query(BookQuery query);
}
