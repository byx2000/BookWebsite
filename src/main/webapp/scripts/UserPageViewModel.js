$(function()
{
    let app = new Vue(
        {
            el: "#content",
            data:
            {
                tabNames: ["我的评论", "我的收藏", "我的点赞"],
                tabLinks: ["./user_page.html?tab=my_comments", "./user_page.html?tab=my_favorites", "./user_page.html?tab=my_likes"],
                selectedTabIndex: 0
            },
            methods:
            {

            },
            mounted: function()
            {
                let tabParam = getUrlParameter("tab");
                if (tabParam === "my_comments")
                    this.selectedTabIndex = 0;
                else if (tabParam === "my_favorites")
                    this.selectedTabIndex = 1;
                else
                    this.selectedTabIndex = 2;
            }
        }
    );
});