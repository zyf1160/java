<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改新闻</title>
    <script type="text/javascript" src="kindeditor-4.1.10/kindeditor.js"></script>
    <script type="text/javascript">
        KindEditor.ready(function(K) {
            K.create('#content', {
                uploadJson : 'kindeditor-4.1.10/jsp/upload_json.jsp',
                fileManagerJson : 'kindeditor-4.1.10/jsp/file_manager_json.jsp',
                allowFileManager : true
            });
        });
    </script>
</head>
<body>
<form action="Hello" method="post">
    <input type="hidden" value="${news.newsId}" name="id"/>
    <input type="hidden" name="oprate" value="updatenews"/>
    <input type="text" name="newstitle" value="${news.newsTitle}" placeholder="请输入标题"/><br/>
    新闻栏目
    <select name="newstype">

        <option <c:if test="${news.newsType==\"html\"}">selected</c:if> value="html">html</option>
        <option <c:if test="${news.newsType==\"Javascript\"}">selected</c:if> value="Javascript">Javascript</option>
        <option <c:if test="${news.newsType==\"oracle\"}">selected</c:if> value="oracle">oracle</option>
    </select>
    <br/>
    <textarea id="content" name="newscontent" rows="8" cols="70">${news.newsContent}</textarea><br/>
    <input type="submit" value="确定修改"/>
</form>
</body>
</html>
