package kr.mjc.junginsung.web.mvc;

import kr.mjc.junginsung.web.dao.Article;
import kr.mjc.junginsung.web.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ArticleController {
    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }


    /**
     * 게시글 목록
     */
    public void articleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("articleList", articleDao.listArticles(0, 100));

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 상세보기
     */
    public void getArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("articleGet", articleDao.getArticle(607));

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/getArticle.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 쓰기 화면
     */
    public void articleForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleForm.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 쓰기 액션
     */
    public void addArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(584);
        article.setName(request.getParameter("name"));

        try {
            articleDao.addArticle(article);
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        } catch (DuplicateKeyException e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleForm?msg=fail");
        }
    }
    /**
     * 게시글 변경 화면
     */
    public void updateArticleForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/updateArticleForm.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 변경 액션
     */
    public void updateArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Article article = new Article();
        article.setArticleId(607);
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(584);

        try {
            articleDao.updateArticle(article);
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        } catch (DuplicateKeyException e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleForm?msg=fail");
        }
    }

    /**
     * 게시글 삭제 화면
     */
    public void deleteArticleForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/deleteArticleForm.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 삭제 액션
     */
    public void deleteArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            articleDao.deleteArticle(612, 584);
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        } catch (DuplicateKeyException e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleForm?msg=fail");
        }
    }
 }
