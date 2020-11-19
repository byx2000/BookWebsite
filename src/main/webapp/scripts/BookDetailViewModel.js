$(function()
{
    // 加载vue组件
    let app = new Vue(
    {
        el: "#content",
        data: 
        {
            book: null,
            category: null,
            comments: [],
            users: []
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
                    }
                );

                // 获取评论
                queryComments(
                    {
                        bookId: books[0].id
                    },
                    function(comments)
                    {
                        app.comments = comments;

                        for (let comment of comments)
                        {
                            // 获取用户信息
                            queryUsers(
                                {
                                    userId: comment.userId
                                },
                                function(users)
                                {
                                    app.users.push(users[0]);
                                }
                            );
                        }
                    }
                );
            });
        }
    });
});