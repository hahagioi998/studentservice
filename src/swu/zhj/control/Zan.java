package swu.zhj.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.zhj.service.TiebaService;

/**
 * Servlet implementation class Zan
 */
@WebServlet("/Zan")
public class Zan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Zan() {
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
		System.out.println(id+"shi");
		session.setAttribute("id",id);
		int jianzhi_id=Integer.parseInt(request.getParameter("id"));
		int zan=Integer.parseInt(request.getParameter("zan"));
		zan++;
		System.out.println(id+"--"+zan);
		  //先看zan表里是否有
		 boolean flag=TiebaService.CheckzanBystudent_id(id,jianzhi_id);
		 if(flag) {
			 response.sendRedirect("Jianzhi");
		 }else {
      		boolean flag1=TiebaService.UpdatezanById(zan,jianzhi_id);
 		    if(flag1) {
			  response.sendRedirect("Jianzhi");
		   }
		 }
	}    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   
	}

}
