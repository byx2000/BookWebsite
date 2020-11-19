package com.byx.query;

/**
 * 用户查询类
 */
public class UserQuery extends Query
{
    private Integer userId;
    private String username;

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    protected void customizeQuery()
    {
        if (userId != null)
            addWhereCondition("id == ?", userId);

        if (username != null)
            addWhereCondition("username == ?", username);
    }
}
