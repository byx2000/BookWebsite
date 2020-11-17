// 发起请求
function request(url, parameters, success, fail = e => alert(e))
{
    $.get(url, parameters, 
    function(response)
    {
        if (response.flag) success(response.data);
        else fail(response.errMsg);
    });
}

// 查询电子书分类
function queryCategories(conditions, success, fail)
{
    request("category/query", conditions, success, fail);
}

// 查询电子书
function queryBooks(conditions, success, fail)
{
    request("book/query", conditions, success, fail);
}

// 登录
function login(username, password, success, fail)
{
    request("user/login", 
    { 
        username: username,
        password: password
    }, 
    success, fail);
}

// 获取当前登录用户
function getCuurentUser(success, fail)
{
    request("user/current", {}, success, fail);
}

// 注销
function logout(success, fail)
{
    request("user/logout", {}, success, fail);
}