package swu.zhj.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.zhj.service.NewsService;
import swu.zhj.service.UserService;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("id");
		System.out.println(id+"Delect");
		session.setAttribute("id",id);
		int jianzhi_id=Integer.parseInt(request.getParameter("jianzhi_id"));
		String action=request.getParameter("action");
		boolean flag = false;
		if(action.equals("bumenmenber")) {
			flag=NewsService.deleteBumenmenberById(jianzhi_id);
		}
		else if(action.equals("student")) {
			flag=NewsService.deleteStudentById(jianzhi_id);
			if(flag){
				request.getRequestDispatcher("ListStudentUser").forward(request, response);
		
		    }
		}
		else if(action.equals("lunbo")) {
			flag=NewsService.deleteLunboById(jianzhi_id);
		}
		else if(action.equals("yijian")) {
			flag=NewsService.deleteYijianById(jianzhi_id);
			if(flag){
				request.getRequestDispatcher("ListYijian").forward(request, response);
		
		    }
		}
		else if(action.equals("home_yin")) {
			flag=NewsService.deleteHome_yinById(jianzhi_id);
		}
		else if(action.equals("home_data")) {
			flag=NewsService.deleteHome_dataById(jianzhi_id);
		}
		else if(action.equals("home_nongchang")) {
			flag=NewsService.deleteHome_nongchangById(jianzhi_id);
		}
		else if(action.equals("gamelei")) {
			flag=NewsService.deleteGameleiById(jianzhi_id);
		}
		else if(action.equals("user")) {
			flag=UserService.deleteUserById(jianzhi_id);
		}
		else if(action.equals("jianzhi")) {
			flag=UserService.deleteJianzhiById(jianzhi_id);
			if(flag) {
				System.out.println("a");
				request.getRequestDispatcher("ListJianzhi").forward(request, response);
			}
		}
		if(flag){
				request.getRequestDispatcher("ListBumenmenber").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
