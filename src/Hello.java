import com.newsmanager.dao.NewsDao;
import com.newsmanager.entity.News;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "com.newsmanager.Hello")
public class Hello extends HttpServlet {

    private NewsDao newsDao;

    @Override
    public void init() throws ServletException {
        newsDao = new NewsDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doget 请求：org.apache.jasper.JasperException: 无法在web.xml或使用此应用程序部署的jar文件中解析绝对uri：[http://java.sun.con/jsp/jstl/core]\n");
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String oprate = request.getParameter("oprate");

        //如果该次请求是addnews，则是添加新闻请求
        if ("addnews".equals(oprate)) {
            String newstitle = request.getParameter("newstitle");
            String newstype = request.getParameter("newstype");
            String newscontent = request.getParameter("newscontent");

            int row = newsDao.addNews(newstitle, newstype, newscontent);
            //response.sendRedirect("NewsServlet");

        } else if ("delete".equals(oprate)) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            int row = newsDao.deleteNewsById(id);
            //response.sendRedirect("NewsServlet");
        }else if ("pishan".equals(oprate)){
            String[] deleteId = request.getParameterValues("deleteId");
            for (String string : deleteId){
                Integer did = Integer.valueOf(string);
                newsDao.deleteNewsById(did);
            }
            //response.sendRedirect("NewsServlet");
        }else if ("pishenhe1".equals(oprate)){
            String[] deleteId = request.getParameterValues("deleteId");
            for (String string : deleteId){
                Integer did = Integer.valueOf(string);
                newsDao.deleteNewsById(did);
            }
            //response.sendRedirect("NewsServlet");
        }else if ("toupdate".equals(oprate)){
            Integer id = Integer.valueOf(request.getParameter("id"));
            News news = newsDao.getNews(id);
            request.setAttribute("news",news);
            request.getRequestDispatcher("newsupdate.jsp").forward(request,response);
        }else if ("updatenews".equals(oprate)){
            Integer id =Integer.valueOf(request.getParameter("id"));
            String newsTrtle = request.getParameter("newstitle");
            String newsType = request.getParameter("newstype");
            String newsContent = request.getParameter("newscontent");
            int row = newsDao.updateNews(id,newsTrtle,newsType,newsContent);
            //response.sendRedirect("Hello");
        }

        Integer pageNumber = 1;
        String pn = request.getParameter("pageNumber");
        if (pn != null) {
            pageNumber = Integer.valueOf(pn);
        }
        if (pageNumber < -1) {
            pageNumber = 1;
        }
        int count = newsDao.getCount();
        Integer pageSize = 10;
        int pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        if (pageNumber > pageCount) {
            pageNumber = pageCount;
        }

        //调用查询新闻集合的方法
        List<News> newsList = newsDao.getNewsList(pageNumber, pageSize);
        //添加到request作用域
        request.setAttribute("newsList", newsList);
//        request.getAttribute("ne")

        request.setAttribute("pageNumber", pageNumber);
        request.setAttribute("pageCount", pageCount);

        //转发到newsList.jsp页面
        request.getRequestDispatcher("newsList.jsp").forward(request, response);
    }


}


