package swu.zhj.util;

public class DividePage {
	    private int pageSize; //表示显示的条数
	    private int recordCount;  //表示记录的总条数
	    private int currentPage;   //表示当前页
	    
	    public DividePage(int pageSize,int recordCount,int currentPage){
	        this.pageSize=pageSize;
	        this.recordCount=recordCount;
	        setCurrentPage(currentPage);   //设置当前页
	    }
	    //重载
	    public DividePage(int pageSize,int recordCount){
	        this(pageSize,recordCount,1);//默认为1
	    }
	    //获得总页数
	    public int getPageCount(){
	        int size=recordCount/pageSize;    //总页数等于总条数除以显示条数
	        int mod=recordCount%pageSize;   //整除
	        if(mod!=0){           //如果不整除则+1
	            size++;
	        }return recordCount==0?1:size;
	    }
	    public int getFromIndex(){  //开始记录条数
	        return (currentPage-1)*pageSize;
	    }
	    public int getToIndex(){      //返回当前页
	        return pageSize;
	    }
	    public int getCurrentPage(){   //获得当前页，判读边界
	        return currentPage;
	    }
	    public void setCurrentPage(int currentPage){  //避免首页再点击上一页
	        int validPage=currentPage<=0?1:currentPage;
	        validPage=validPage>getCurrentPage()?getPageCount():validPage;
	        this.currentPage=currentPage;
	    }
	    public int getPageSize(){
	        return pageSize;
	    }
	    public void setPageSize(int pageSize){
	        this.pageSize=pageSize;
	    }
	    public int getRecordCount(){
	        return recordCount;
	    }
	    public void setRecordCount(int recordCount){
	        this.recordCount=recordCount;
	    }
}
