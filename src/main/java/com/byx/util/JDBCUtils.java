package com.byx.util;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils
{
    private static String url;
    private static String username;
    private static String password;

    static
    {
        try
        {
            // 读取db.properties
            String path = Thread.currentThread().getContextClassLoader().getResource("../../db.properties").getPath();
            Properties prop = new Properties();
            prop.load(new FileReader(path));

            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            String driver = prop.getProperty("driverClassName");

            Class.forName(driver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, username, password);
    }

    public static void close(Statement stmt, Connection conn)
    {
        if (stmt != null)
        {
            try
            {
                stmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn)
    {
        if (rs != null)
        {
            try
            {
                rs.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        if (stmt != null)
        {
            try
            {
                stmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
