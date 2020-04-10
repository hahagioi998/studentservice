package swu.zhj.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swu.zhj.model.Home_data;
import swu.zhj.model.Home_nongchang;
import swu.zhj.model.Home_yin;
import swu.zhj.model.Lunbo;
import swu.zhj.model.News;
import swu.zhj.service.NewsService;

/**
 * Servlet implementation class ListNews
 */
@WebServlet("/ListNews")
public class ListNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<News> news_list=new ArrayList<News>();
		List<Lunbo> lunbo_list=new ArrayList<Lunbo>();
		List<Home_nongchang> home_nongchang_list=new ArrayList<Home_nongchang>();
		List<Home_data> home_data_list=new ArrayList<Home_data>();
		List<Home_yin> home_yin_list=new ArrayList<Home_yin>();
		
		news_list=NewsService.getAllNews();
		lunbo_list=NewsService.getAllLunbo();
		home_nongchang_list=NewsService.getAllHome_nongchang();
		home_data_list=NewsService.getAllHome_data();
		home_yin_list=NewsService.getAllHome_yin();
		
		request.setAttribute("news_list",news_list);
		request.setAttribute("lunbo_list",lunbo_list);
		request.setAttribute("home_nongchang_list",home_nongchang_list);
		request.setAttribute("home_data_list",home_data_list);
		request.setAttribute("home_yin_list",home_yin_list);
		System.out.println(news_list.size());
		request.getRequestDispatcher("admin/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
