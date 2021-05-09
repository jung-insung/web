<%@ page import="kr.mjc.junginsung.web.dao.Article" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<body>
<nav><a href="./articleForm">게시글-쓰기</a> <a href="./getArticle">게시글-상세보기</a></nav>
<h3>게시글 목록</h3>
<%
    List<Article> articleList = (List<Article>) request.getAttribute("articleList");
    for (Article article : articleList) {%>
<p><%= article %>
</p>
<%
    }
%>
</body>
</html>
