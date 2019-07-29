<%--
  Created by IntelliJ IDEA.
  User: 11959
  Date: 2019/7/28
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        // $(document).ready(function() {
        //     toPage(1);
        //
        //     $("#1").click(function () {
        //         window.location.href = "Select?pageNum=1";
        //     });
        // });
        //
        // function toPage(pageNum) {
        //     $.ajax({
        //         url: "Select",
        //         data: "pageNum=" + pageNum,
        //         type: "post",
        //         success: function (result) {
        //             build_table(result);
        //             build_pageinfo(result);
        //             build_page_nave(result);
        //         }
        //     });
        // }
        // function build_table(result) {
        //     //构建之前都要清空
        //     $("#user_table tbody").empty();
        //
        //     var users = result.data.pageInfo.list;
        //     $.each(users, function (index, item) {
        //         var userid = $("<td></td>").append(item.id);
        //         var username = $("<td></td>").addClass("value").append(item.name);
        //         var userage = $("<td></td>").addClass("value").append(item.age);
        //
        //         var href = $("<a></a>").attr("href", "#").addClass("btn btn-small btn-primary").append("Action");
        //         var action = $("<td></td>").addClass("actions").append(href);
        //         $("<tr></tr>").append(userid).append(username).append(userage).append(action)
        //             .appendTo("#user_table tbody");
        //     });
        // }
        //
        // function build_pageinfo(result) {
        //     $("#pageinfo").empty();
        //     $("#pageinfo")
        //         .append("当前第" + result.data.pageInfo.pageNum + "页，" +
        //             "共" + result.data.pageInfo.pages + " 页，" +
        //             "共" + result.data.pageInfo.total + "条记录")
        // }
        //
        // function build_page_nave(result) {
        //     $("#page_nav").empty();
        //
        //     var firstPage = $("<li></li>")
        //         .append($("<a></a>").append("首页").attr("href", "#"));
        //     var lastPage = $("<li></li>")
        //         .append($("<a></a>").append("尾页").attr("href", "#"));
        //
        //     var prePage = $("<li></li>")
        //         .append($("<a></a>").append("Prev").attr("href", "#"));
        //     var nextPage = $("<li></li>")
        //         .append($("<a></a>").append("Next").attr("href", "#"));
        //
        //     if (result.data.pageInfo.hasPreviousPage == false) {
        //         firstPage.addClass("disabled");
        //         prePage.addClass("disabled");
        //     }
        //     else {
        //         //首页的点击事件
        //         firstPage.click(function () {
        //             toPage(1);
        //         });
        //         //Prev的点击事件
        //         prePage.click(function () {
        //             toPage(result.data.pageInfo.pageNum - 1);
        //         });
        //     }
        //
        //     if (result.data.pageInfo.hasNextPage == false) {
        //         lastPage.addClass("disabled");
        //         nextPage.addClass("disabled");
        //     }
        //     else {
        //         //Next的点击事件
        //         nextPage.click(function () {
        //             toPage(result.data.pageInfo.pageNum + 1);
        //         });
        //         //尾页的点击事件
        //         lastPage.click(function () {
        //             toPage(result.data.pageInfo.pages);
        //         });
        //     }
        //
        //
        //     $("#page_nav")
        //         .append(firstPage).append(prePage);
        //     $.each(result.data.pageInfo.navigatepageNums, function (index, item) {
        //         var numli = $("<li></li>")
        //             .append($("<a></a>").append(item).attr("href", "#"));
        //         if (result.data.pageInfo.pageNum == item) {
        //             numli.addClass("active");
        //         }
        //
        //         //数字翻页的点击事件
        //         numli.click(function () {
        //             toPage(item);
        //         });
        //         $("#page_nav").append(numli);
        //     });
        //
        //     $("#page_nav").append(nextPage).append(lastPage);
        // }
    </script>
</head>
<body>
    <div class="span5">
        <div class="pagination pull-left">
            <div>
                当前${pageInfo.pageNum}页,
                共${pageInfo.pages}页,
                共${pageInfo.total}条记录
            </div>

            <a href="Select?pageNum=${pageInfo.firstPage}">首页</a>
            <c:if test="${pageInfo.hasPreviousPage}">
                <a href="Select?pageNum=${pageInfo.pageNum-1}">Prev</a>
            </c:if>

            <c:forEach items="${pageInfo.navigatepageNums}" var="pagenum">
                <c:if test="${pagenum==pageInfo.pageNum}">
                    <a href="javascript:void(0)">${pagenum}</a>
                </c:if>
                <c:if test="${pagenum!=pageInfo.pageNum}">
                    <a href="Select?pageNum=${pagenum}">${pagenum}</a>
                </c:if>
            </c:forEach>

            <c:if test="${pageInfo.hasNextPage}">
                <a href="Select?pageNum=${pageInfo.pageNum+1}">Next</a>
            </c:if>
            <a href="Select?pageNum=${pageInfo.lastPage}">尾页</a>
        </div>
    </div>
    <div class="span10">
        <div class="slate">
            <table class="orders-table table">
                <thead>
                <tr>
                    <th>编号</th>
                    <th class="value">姓名</th>
                    <th class="actions">年龄</th>
                </tr>
                </thead>
                <%--查询开始--%>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="users">
                    <tr>
                        <td> ${users.id}</td>
                        <td class="value">${users.name}</td>
                        <td class="value">${users.age}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
