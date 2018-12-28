package entity;

// 商品分类表
public class CateGory {
	private int cid;
	private String cname;
	private int parentid; // 父类商品分类 1-图书音像 2-百货

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public CateGory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CateGory(int cid, String cname, int parentid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.parentid = parentid;
	}

}
