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
        $(document).ready(function() {
            toPage(1);
        });

        function toPage(pageNum) {
            $.ajax({
                url: "Select",
                data: "pageNum=" + pageNum,
                type: "post",
                success: function (result) {
                    var jsonobj= eval('(' + result + ')');
                    build_table(jsonobj);
                    build_page_info(jsonobj);
                    build_page_nave(jsonobj);
                }
            });
        }

        function build_table(result) {
            //构建之前都要清空
            $("#user_table tbody").empty();

            var users = result.list;
            $.each(users, function (index, item) {
                var userid = $("<td></td>").append(item.id);
                var username = $("<td></td>").addClass("value").append(item.name);
                var userage = $("<td></td>").addClass("value").append(item.age);

                $("<tr></tr>").append(userid).append(username).append(userage)
                    .appendTo("#user_table tbody");
            });
        }

        function build_page_info(result) {
            $("#page_info").empty();
            $("#page_info")
                .append("当前第" + result.pageNum + "页，" +
                    "共" + result.pages + " 页，" +
                    "共" + result.total + "条记录")
        }

        function build_page_nave(result) {
            $("#page_nav").empty();

            var firstPage = $("<li></li>")
                .append($("<a></a>").append("首页").attr("href", "#"));
            var lastPage = $("<li></li>")
                .append($("<a></a>").append("尾页").attr("href", "#"));

            var prePage = $("<li></li>")
                .append($("<a></a>").append("Prev").attr("href", "#"));
            var nextPage = $("<li></li>")
                .append($("<a></a>").append("Next").attr("href", "#"));

            if (result.hasPreviousPage == false) {
                firstPage.addClass("disabled");
                prePage.addClass("disabled");
            }
            else {
                firstPage.click(function () {
                    toPage(1);
                });
                prePage.click(function () {
                    toPage(result.pageNum - 1);
                });
            }

            if (result.hasNextPage == false) {
                lastPage.addClass("disabled");
                nextPage.addClass("disabled");
            }
            else {
                nextPage.click(function () {
                    toPage(result.pageNum + 1);
                });
                lastPage.click(function () {
                    toPage(result.pages);
                });
            }


            $("#page_nav").append(firstPage).append(prePage);
            $.each(result.navigatepageNums, function (index, item) {
                var numli = $("<li></li>")
                    .append($("<a></a>").append(item).attr("href", "#"));
                if (result.pageNum == item) {
                    numli.addClass("active");
                }
                numli.click(function () {
                    toPage(item);
                });
                $("#page_nav").append(numli);
            });

            $("#page_nav").append(nextPage).append(lastPage);
        }
    </script>
</head>
<body>
    <div class="span5">
        <div class="pagination pull-left">
            <br>
            <div id="page_info" style="font-size: 20px;">
            </div>
        </div>

        <div class="pagination pull-right">
            <ul id="page_nav" class="pagination">
            </ul>
        </div>
    </div>
    <div class="span10">
        <div class="slate">
            <table class="orders-table table" id="user_table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th class="value">姓名</th>
                    <th class="actions">年龄</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
