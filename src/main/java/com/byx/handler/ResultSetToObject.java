package com.byx.handler;

import com.byx.util.BeanUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

public class ResultSetToObject<T> implements IResultSetHandler<T>
{
    private final Class<T> type;

    public ResultSetToObject(Class<T> type)
    {
        this.type = type;
    }

    private Map<String, Object> resultSetToMap(ResultSet rs) throws SQLException
    {
        Map<String, Object> map = new Hashtable<>();
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        for (int i = 1; i <= count; i++)
        {
            String key = rsmd.getColumnLabel(i);
            Object value = rs.getObject(i);
            map.put(key, value);
        }
        return map;
    }

    @Override
    public T handle(ResultSet rs) throws Exception
    {
        T t = type.getDeclaredConstructor().newInstance();
        BeanUtils.populate(t, resultSetToMap(rs));
        return t;
    }
}
