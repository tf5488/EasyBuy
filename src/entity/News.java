package entity;

import java.util.Date;

public class News {
	private int nid;
	private String title;
	private String content;
	private Date createtime;

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(int nid, String title, String content, Date createtime) {
		super();
		this.nid = nid;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
	}

}
