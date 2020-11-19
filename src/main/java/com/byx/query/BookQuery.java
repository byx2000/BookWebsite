package com.byx.query;

import com.byx.util.DateUtils;

/**
 * 电子书查询条件封装类
 */
public class BookQuery extends Query
{
    private Integer bookId = null;
    private Integer categoryId = null;
    private Integer daysAgo = null;
    private String keyword = null;
    private Integer pageSize = null;
    private Integer currentPage = null;
    private Integer random = null;
    private String orderBy = null;

    public Integer getBookId()
    {
        return bookId;
    }

    public void setBookId(Integer bookId)
    {
        this.bookId = bookId;
    }

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }

    public Integer getDaysAgo()
    {
        return daysAgo;
    }

    public void setDaysAgo(Integer daysAgo)
    {
        this.daysAgo = daysAgo;
    }

    public String getKeyword()
    {
        return keyword;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage)
    {
        this.currentPage = currentPage;
    }

    public Integer getRandom()
    {
        return random;
    }

    public void setRandom(Integer random)
    {
        this.random = random;
    }

    public String getOrderBy()
    {
        return orderBy;
    }

    public void setOrderBy(String orderBy)
    {
        this.orderBy = orderBy;
    }

    private boolean queryByPage()
    {
        return pageSize != null && currentPage != null;
    }

    @Override
    protected void customizeQuery()
    {
        // where 条件
        if (bookId != null)
            addWhereCondition("id == ?", bookId);

        if (categoryId != null)
            addWhereCondition("categoryId == ?", categoryId);

        if (daysAgo != null && daysAgo > 0)
            addWhereCondition("updateTime >= ?", DateUtils.daysAgo(daysAgo));

        if (keyword != null)
            addWhereCondition("name LIKE ? OR author LIKE ? OR description LIKE ?",
                    "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");

        // order by 条件
        if (orderBy != null)
        {
            switch (orderBy)
            {
                case "updateTime": // 按更新时间排序
                    addOrderCondition("updateTime DESC");
                    break;
                case "wordCount": // 按字数排序
                    addOrderCondition("wordCount DESC");
                    break;
                case "heat": // 按热度排序
                    addOrderCondition("(likeCount + dislikeCount) DESC");
                    break;
                case "score": // 按得分排序
                    addOrderCondition("CASE WHEN likeCount + dislikeCount == 0 THEN 1.0 ELSE likeCount * 1.0 / (likeCount + dislikeCount) END DESC");
                    break;
            }
        }

        if (!queryByPage() && random != null)
        {
            addOrderCondition("RANDOM()");
            addLimit(random);
        }

        if (random == null && queryByPage())
        {
            addLimit(pageSize);
            addOffset(pageSize * (currentPage - 1));
        }
    }
}
