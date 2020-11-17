$(function()
{
    // 加载vue组件
    let app = new Vue(
    {
        el: "#book_info",
        data: 
        {
            book: null,
            category: null
        },
        methods:
        {

        },
        mounted: function()
        {
            // 从url获取电子书id
            let bookId = getUrlParameter("bookId");

            // 获取电子书详情
            queryBooks(
            {
                bookId: bookId
            },
            function(books)
            {
                app.book = books[0];
                // 获取类别信息
                queryCategories(
                {
                    categoryId: app.book.categoryId
                },
                function(categories)
                {
                    app.category = categories[0];
                });
            });
        }
    });
});