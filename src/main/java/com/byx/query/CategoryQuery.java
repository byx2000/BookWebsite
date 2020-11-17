package com.byx.query;

public class CategoryQuery extends Query
{
    private Integer categoryId;

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }

    @Override
    protected void customizeQuery()
    {
        if (categoryId != null)
        {
            addWhereCondition("id == ?", categoryId);
        }
    }
}
