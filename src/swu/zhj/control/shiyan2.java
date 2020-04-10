package swu.zhj.control;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.zhj.model.Studentusers;
import swu.zhj.util.shiyan;

/**
 * Servlet implementation class shiyan2
 */
@WebServlet("/shiyan2")
public class shiyan2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shiyan2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session=request.getSession();
		 List<Studentusers> student_user_list=new ArrayList<Studentusers>();
		 student_user_list=(List<Studentusers>) session.getAttribute("student_user_list");
		 System.out.println(student_user_list.size());
		 String filename= new String("document.xls".getBytes(),"iso-8859-1");//中文文件名必须使用此句话
		 response.setContentType("application/octet-stream");
	        response.setContentType("application/OCTET-STREAM;charset=UTF-8");
	        response.setHeader("Content-Disposition", "attachment;filename="+filename );

	        String[] headers = { "编号","姓名", "密码", "电话","学号", "专业" ,"图片","班级","寝室","qq","年级"};  //表格的标题栏
	        try {
	            shiyan<Studentusers> ex = new shiyan<Studentusers>();  //构造导出类

	            OutputStream  out = new BufferedOutputStream(response.getOutputStream());

	            String  title = student_user_list.get(0).getName();  //title需要自己指定 比如写Sheet

	            ex.exportExcel(title,headers, student_user_list, out);  //title是excel表中底部显示的表格名，如Sheet
	            out.close();
	            //JOptionPane.showMessageDialog(null, "导出成功!");
	            System.out.println("excel导出成功！");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        response.sendRedirect("ListStudentUser");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
