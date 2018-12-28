package entity;

import java.util.List;

public class PageBean<T> {

	private int pagetotal;// 总页数
	private int pageno;// 当前页
	private int page;// 每页容量
	private int infonum;// 总信息条数
	private List<T> pagelist;// 每页信息集合

	public int getPagetotal() {
		
		if(infonum%page == 0){
			pagetotal = infonum/page;
		}else{
			pagetotal = (infonum/page)+1;
		}
		return pagetotal;
	}

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		if(pageno > pagetotal){
			this.pageno = pagetotal;
		}else if (pageno < 1){
			this.pageno = 1;
		}else{
			this.pageno = pageno;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getInfonum() {
		return infonum;
	}

	public void setInfonum(int infonum) {
		this.infonum = infonum;
	}

	public List<T> getPagelist() {
		return pagelist;
	}

	public void setPagelist(List<T> pagelist) {
		this.pagelist = pagelist;
	}

	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageBean(int pagetotal, int pageno, int page, int infonum, List<T> pagelist) {
		super();
		this.pagetotal = pagetotal;
		this.pageno = pageno;
		this.page = page;
		this.infonum = infonum;
		this.pagelist = pagelist;
	}

}
