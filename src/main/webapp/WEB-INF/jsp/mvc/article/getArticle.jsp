<%@ page import="kr.mjc.junginsung.web.dao.Article" %>

<!DOCTYPE html>
<html>
<body>
<h3>게시글 상세보기</h3>
<%
    Article article = (Article) request.getAttribute("articleGet");
%>
<p><%= article %>
</p>
</body>
</html>