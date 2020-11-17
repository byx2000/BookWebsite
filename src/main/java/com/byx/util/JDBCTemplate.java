package com.byx.util;

import com.byx.handler.IResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class JDBCTemplate
{
    public static <T> T query(String sql, IResultSetHandler<T> resultSetHandler, Object... params)
    {
        System.out.println("sql: " + sql);
        System.out.println("params: " + Arrays.toString(params));

        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conn = null;
        try
        {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);

            // 设置sql参数
            for (int i = 0; i < params.length; ++i)
            {
                stmt.setObject(i + 1, params[i]);
            }

            rs = stmt.executeQuery();
            return resultSetHandler.handle(rs);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DBCPUtils.close(rs, stmt, conn);
        }
    }
}
