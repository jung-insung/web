<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 변경</h3>
<form action="updateArticle" method="post">
    <p><input type="text" name="title" placeholder="게시글 제목" required autofocus/></p>
    <p><input type="text" name="content" placeholder="게시글 내용" required/></p>
    <p>
        <button type="submit">변경</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>