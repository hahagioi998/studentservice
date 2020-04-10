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
		 String filename= new String("document.xls".getBytes(),"iso-8859-1");//�����ļ�������ʹ�ô˾仰
		 response.setContentType("application/octet-stream");
	        response.setContentType("application/OCTET-STREAM;charset=UTF-8");
	        response.setHeader("Content-Disposition", "attachment;filename="+filename );

	        String[] headers = { "���","����", "����", "�绰","ѧ��", "רҵ" ,"ͼƬ","�༶","����","qq","�꼶"};  //���ı�����
	        try {
	            shiyan<Studentusers> ex = new shiyan<Studentusers>();  //���쵼����

	            OutputStream  out = new BufferedOutputStream(response.getOutputStream());

	            String  title = student_user_list.get(0).getName();  //title��Ҫ�Լ�ָ�� ����дSheet

	            ex.exportExcel(title,headers, student_user_list, out);  //title��excel���еײ���ʾ�ı��������Sheet
	            out.close();
	            //JOptionPane.showMessageDialog(null, "�����ɹ�!");
	            System.out.println("excel�����ɹ���");
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
