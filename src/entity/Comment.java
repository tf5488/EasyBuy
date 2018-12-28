package entity;

import java.util.Date;

public class Comment {
	private int ecid;
	private String reply;  // 回复
	private String content;  // 问题
	private Date createtime; // 问题创建时间
	private Date replytime;  // 回复创建时间
	private String nickname; // 提问人姓名

	public int getEcid() {
		return ecid;
	}

	public void setEcid(int ecid) {
		this.ecid = ecid;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
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

	public Date getReplytime() {
		return replytime;
	}

	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int ecid, String reply, String content, Date createtime, Date replytime, String nickname) {
		super();
		this.ecid = ecid;
		this.reply = reply;
		this.content = content;
		this.createtime = createtime;
		this.replytime = replytime;
		this.nickname = nickname;
	}

}
