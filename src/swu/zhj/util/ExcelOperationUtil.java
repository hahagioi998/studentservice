package swu.zhj.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import swu.zhj.model.Studentusers;

public class ExcelOperationUtil {
	public List<Studentusers> readExcelFileToDB(String filePath){
		List<Studentusers> list = new ArrayList<Studentusers>();
		try{
			FileInputStream fis = new FileInputStream(filePath);
			POIFSFileSystem fs  = new POIFSFileSystem(fis);
			HSSFWorkbook workbook = new HSSFWorkbook(fs);//创建Excel工作簿对象	
			HSSFSheet sheet = workbook.getSheetAt(0);//获取第1个工作表
			HSSFPatriarch patriarch = sheet.getDrawingPatriarch();
		
			for(int i=2;i<=sheet.getLastRowNum();i++){//循环Excel文件的每一行
				Studentusers emp = new Studentusers();
				HSSFRow row = sheet.getRow(i);//获取第i行
				//for(int j=1;j<=sheet.getRow(i).getPhysicalNumberOfCells();j++) {
				HSSFCell cell1 = row.getCell(0);//获取第i行第一列
				HSSFCell cell2 = row.getCell(1);
				HSSFCell cell3 = row.getCell(2);
				HSSFCell cell4 = row.getCell(3);
				HSSFCell cell5 = row.getCell(4);
				HSSFCell cell6 = row.getCell(5);
				HSSFCell cell7 = row.getCell(6);
				HSSFCell cell8 = row.getCell(7);
				HSSFCell cell9 = row.getCell(8);
				cell1.setCellType(cell1.CELL_TYPE_STRING);
				String name = cell1.getStringCellValue();//获取第i行的第1个单元格的数据
				System.out.println(name);
				emp.setName(name);
				cell2.setCellType(cell2.CELL_TYPE_STRING);
				String password = cell2.getStringCellValue();//获取第i行的第2个单元格的数据
				emp.setPassword(password);
				cell3.setCellType(cell3.CELL_TYPE_STRING);
				String phone = cell3.getStringCellValue();//获取第i行的第3个单元格的数据
				emp.setPhone(phone);
				cell4.setCellType(cell4.CELL_TYPE_STRING);
				String xuehao = cell4.getStringCellValue();//获取第i行的第4个单元格的数据
				emp.setXuehao(xuehao);
				cell5.setCellType(cell5.CELL_TYPE_STRING);
				String zhuanye = cell5.getStringCellValue();//获取第i行的第4个单元格的数据
				emp.setZhuanye(zhuanye);
				cell6.setCellType(cell6.CELL_TYPE_STRING);
				String cla = cell6.getStringCellValue();//获取第i行的第4个单元格的数据
				emp.setCla(cla);
				cell7.setCellType(cell7.CELL_TYPE_STRING);
				String qinshi = cell7.getStringCellValue();//获取第i行的第4个单元格的数据
				emp.setQinshi(qinshi);
				cell8.setCellType(cell8.CELL_TYPE_STRING);
				String qq = cell8.getStringCellValue();//获取第i行的第4个单元格的数据
				emp.setQq(qq);
				cell9.setCellType(cell9.CELL_TYPE_STRING);
				String img = cell9.getStringCellValue();//获取第i行的第4个单元格的数据
				emp.setImg(img);
				list.add(emp);
			}
			fis.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}

