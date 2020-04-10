package swu.zhj.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.zhj.model.Bumen_baoming;
import swu.zhj.service.NewsService;

/**
 * Servlet implementation class XiangSearch
 */
@WebServlet("/XiangSearch")
public class XiangSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiangSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("id");
		session.setAttribute("id",id);
		String first=request.getParameter("first");
		String two=request.getParameter("two");
		String tiao=request.getParameter("tiao");
		System.out.println(first+two+tiao);
        List<Bumen_baoming> bumen_baoming_list=new ArrayList<Bumen_baoming>();
		if(first!=null&&two!=null&&tiao!=null) {
			bumen_baoming_list=NewsService.ChazhaoByFirst1(first,two,tiao);
			request.setAttribute("bumen_baoming_list",bumen_baoming_list);
		}
		if(first!=null&&two!=null&&tiao.isEmpty()) {
			bumen_baoming_list=NewsService.ChazhaoByFirst2(first,two);
			request.setAttribute("bumen_baoming_list",bumen_baoming_list);
		}
		if(first!=null&&two.isEmpty()&&tiao!=null) {
			bumen_baoming_list=NewsService.ChazhaoByFirst3(first,tiao);
			request.setAttribute("bumen_baoming_list",bumen_baoming_list);
		}
		if(first!=null&&two.isEmpty()&&tiao.isEmpty()) {
			System.out.println("j");
			bumen_baoming_list=NewsService.ChazhaoByFirst4(first);
			request.setAttribute("bumen_baoming_list",bumen_baoming_list);
		}
		if(first.isEmpty()&&two!=null&&tiao!=null) {
			bumen_baoming_list=NewsService.ChazhaoByFirst5(two,tiao);
			request.setAttribute("bumen_baoming_list",bumen_baoming_list);
		}
        if(first.isEmpty()&&two!=null&&tiao.isEmpty()) {
			bumen_baoming_list=NewsService.ChazhaoByFirst6(two);
			request.setAttribute("bumen_baoming_list",bumen_baoming_list);
        }
        if(first.isEmpty()&&two.isEmpty()&&tiao!=null) {
        	bumen_baoming_list=NewsService.ChazhaoByFirst7(tiao);
        	request.setAttribute("bumen_baoming_list",bumen_baoming_list);
        } 
        if(first.isEmpty()&&two.isEmpty()&&tiao.isEmpty()) {
        	bumen_baoming_list=NewsService.getAllBumen_baoming();
    		request.setAttribute("bumen_baoming_list",bumen_baoming_list);
    		
        }
		request.getRequestDispatcher("admin/list2.jsp").forward(request, response);
	}

}
