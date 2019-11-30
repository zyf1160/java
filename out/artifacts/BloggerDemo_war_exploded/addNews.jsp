<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新闻</title>
    <script type="text/javascript" src = "kindeditor-4.1.10/kindeditor.js"></script>
    <script type="text/javascript">
        KindEditor.ready(function (K) {
            K.create('#content',{
                uploadJson:'kindeditor-4.1.10/jsp/upload_json.jsp',
                fileManagerJson:'Kindeditor-4.1.10/jsp/file_manager_jsp',
                allowFileManager:true
            });

        });
    </script>
</head>
<body>
    <form action = "Hello" method="post">
        <input type="hidden" name="oprate" value="addnews"/>
        <input type="text" name = "newstitle" placeholder="请输入标题"/><br/>
        新闻栏目
        <select name="newstype">
            <option value="html">html</option>
            <option value="Javascript">Javascript</option>
            <option value="oracle">oracle=</option>
        </select>
        <br/>
        <textarea id= "content" name="newscontent" rows="70" cols="8"></textarea><br/>
        <input type="submit" value="添加"/>
    </form>
</body>
</html>
