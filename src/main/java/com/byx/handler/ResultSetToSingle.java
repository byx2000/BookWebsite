package com.byx.handler;

import java.sql.ResultSet;

@SuppressWarnings("all")
public class ResultSetToSingle<T> implements IResultSetHandler<T>
{
    @Override
    public T handle(ResultSet rs) throws Exception
    {
        return rs.next() ? (T) rs.getObject(1) : null;
    }
}
