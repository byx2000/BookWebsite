package com.byx.util;

import com.byx.handler.IResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class JDBCTemplate
{
    /**
     * 执行查询操作
     * @param sql 带占位符的sql语句
     * @param resultSetHandler 结果集处理器
     * @param params sql语句的参数
     * @param <T> 返回类型
     * @return 查询结果
     */
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

    /**
     * 执行增、删、改操作
     * @param sql 带占位符的sql语句
     * @param params sql语句的参数
     * @return 影响行数，若执行失败，则返回-1
     */
    public static int update(String sql, Object... params)
    {
        System.out.println("sql: " + sql);
        System.out.println("params: " + Arrays.toString(params));

        Connection conn = null;
        PreparedStatement stmt = null;
        try
        {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);

            // 设置sql参数
            for (int i = 0; i < params.length; ++i)
            {
                stmt.setObject(i + 1, params[i]);
            }

            return stmt.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
        finally
        {
            DBCPUtils.close(stmt, conn);
        }
    }
}
