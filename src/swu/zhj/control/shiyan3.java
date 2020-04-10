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

import swu.zhj.model.Chengjidaochu;
import swu.zhj.model.Kecheng_chengji;
import swu.zhj.model.Studentusers;
import swu.zhj.service.NewsService;
import swu.zhj.util.shiyan;

/**
 * Servlet implementation class shiyan2
 */
@WebServlet("/shiyan3")
public class shiyan3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shiyan3() {
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
		 int renwu_id=Integer.parseInt(request.getParameter("renwu_id"));
		 List<Kecheng_chengji> kecheng_chengji_list=new ArrayList<Kecheng_chengji>();
		 kecheng_chengji_list=NewsService.getAllKecheng_chengjiByrenwu_id(renwu_id);
		 List<Chengjidaochu> chengjidaochu_list=new ArrayList<Chengjidaochu>();
		 int i=1;
		 for(Kecheng_chengji map:kecheng_chengji_list) {
			 Chengjidaochu chengjidaochu=new Chengjidaochu();
			 chengjidaochu.setId(i);
			 chengjidaochu.setStudent_xuehao(map.getStudent_xuehao());
			 chengjidaochu.setKecheng_name(NewsService.getKechengBykecheng_id(NewsService.getKechengrenwuByid(renwu_id).getKecheng_id()).getKe_name());
			 chengjidaochu.setRenwu(NewsService.getKechengrenwuByid(renwu_id).getName());
			 chengjidaochu.setChengji(map.getChengji());
			 chengjidaochu_list.add(chengjidaochu);
		     i++;
		 }
		 System.out.println(kecheng_chengji_list.size());
		 String filename= new String("document1.xls".getBytes(),"iso-8859-1");//�����ļ�������ʹ�ô˾仰
		 response.setContentType("application/octet-stream");
	        response.setContentType("application/OCTET-STREAM;charset=UTF-8");
	        response.setHeader("Content-Disposition", "attachment;filename="+filename );

	        String[] headers = { "���","ѧ��","�γ�","����", "�ɼ�"};  //���ı�����
	        try {
	            shiyan<Chengjidaochu> ex = new shiyan<Chengjidaochu>();  //���쵼����

	            OutputStream  out = new BufferedOutputStream(response.getOutputStream());
                
	            String  title =NewsService.getKechengrenwuByid(renwu_id).getName();  //title��Ҫ�Լ�ָ�� ����дSheet

	            ex.exportExcel(title,headers, chengjidaochu_list, out);  //title��excel���еײ���ʾ�ı��������Sheet
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
