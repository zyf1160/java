
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>新闻列表</title>
    <script type="text/javascript">
        function quanxuan(qx) {

            var deleteId= document.getElementsByName("deleteId");
            for (var i =0;i<deleteId.length;i++ ){
                deleteId[i].checked=qx.checked;
            }
        }
        function changeForm() {
            document.getElementById("oprate").value="pishenhe";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<form action="Hello" method="post">
    <input type="submit" value="批量删除"/>

    <input type="button" value="批量审核" onclick="changeForm()">
    <input type="hidden" id="oprate" name="oprate" value="pishan"/>
    <table width="1000px" cellpadding="0px" cellspacing="0px" cellspacing="0px" border="1px" style="border: 1px solid gray; border-collapse: collapse ">
        <tr>
            <th><input type="checkbox" name="qx" onclick="quanxuan(this)"/></th>
            <th>文章ID</th>
            <th>文章标题</th>
            <th>所属栏目</th>
            <th>创建时间</th>
            <th>是否审核</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${newsList}" var="news">
            <tr>
                <td><input type="checkbox" name="deleteId" value="${news.newsId}"></td>
                <td>${news.newsId}</td>
                <td>${news.newsTitle}</td>
                <td>${news.newsType}</td>
                <td>${news.createTime}</td>
                <td>${news.newsStatus}</td>
                <td>
                    <a href="Hello?oprate=toupdate&id=${news.newsId}"> 编辑</a>
                            |
            <a href="Hello?oprate=delete&id=${news.newsId}">删除</a> </td>
            </tr>
        </c:forEach>
            <td colspan="6">
            <a href="Hello?pageNumber=1">首页</a>
            <a href="Hello?pageNumber=${pageNumber-1}">上一页</a>
            <a href="Hello?pageNumber=${pageNumber+1}">下一页</a>
            <a href="Hello?pageNumber=${pageCount}">尾页</a>
            </td>
    </table>
    </form>
</body>
</html>
