package com.byx.handler;

import java.sql.ResultSet;

public class ResultSetToInt implements IResultSetHandler<Integer>
{
    @Override
    public Integer handle(ResultSet rs) throws Exception
    {
        return rs.next() ? rs.getInt(1) : -1;
    }
}
