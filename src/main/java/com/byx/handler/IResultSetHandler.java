package com.byx.handler;

import java.sql.ResultSet;

public interface IResultSetHandler<T>
{
    T handle(ResultSet rs) throws Exception;
}
