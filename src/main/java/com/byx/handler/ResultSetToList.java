package com.byx.handler;

import com.byx.util.BeanUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public final class ResultSetToList<T> implements IResultSetHandler<List<T>>
{
    private final Class<T> type;

    public ResultSetToList(Class<T> type)
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
    public List<T> handle(ResultSet rs) throws Exception
    {
        List<T> ts = new ArrayList<>();
        while (rs.next())
        {
            T t = type.getDeclaredConstructor().newInstance();
            BeanUtils.populate(t, resultSetToMap(rs));
            ts.add(t);
        }
        return ts;
    }
}
