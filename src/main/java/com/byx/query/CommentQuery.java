package com.byx.query;

/**
 * 评论查询类
 */
public class CommentQuery extends Query
{
    private Integer bookId = null;
    private Integer userId = null;
    private Integer pageSize = null;
    private Integer currentPage = null;

    public Integer getBookId()
    {
        return bookId;
    }

    public void setBookId(Integer bookId)
    {
        this.bookId = bookId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
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

    @Override
    protected void customizeQuery()
    {
        if (bookId != null)
            addWhereCondition("bookId == ?", bookId);

        if (userId != null)
            addWhereCondition("userId == ?", userId);

        if (pageSize != null && currentPage != null)
        {
            addLimit(pageSize);
            addOffset(pageSize * (currentPage - 1));
        }

        addOrderCondition("time DESC");
    }
}
