package entity;

import java.util.Date;

// 用户数据
public class UserInfo {
	private int userid;
	private String username;
	private String nickname;  // 真实姓名
	private String userpwd;
	private int usersex;   // 1-男 0- 女
	private Date birthday;
	private String identitycode;  // 身份证号码
	private String email;
	private String mobile;
	private String address;
	private int status;  // 人员分类   0-普通用户    1- 管理员

	public int getUserId() {
		return userid;
	}

	public void setUserId(int userId) {
		this.userid = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickName() {
		return nickname;
	}

	public void setNickName(String nickName) {
		this.nickname = nickName;
	}

	public String getUserPwd() {
		return userpwd;
	}

	public void setUserPwd(String userPwd) {
		this.userpwd = userPwd;
	}

	public int getUserSex() {
		return usersex;
	}

	public void setUserSex(int userSex) {
		this.usersex = userSex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdentityCode() {
		return identitycode;
	}

	public void setIdentityCode(String identityCode) {
		this.identitycode = identityCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int userid, String username, String nickname, String userpwd,
			int usersex, Date birthday, String identitycode, String email,
			String mobile, String address, int status) {
		super();
		this.userid = userid;
		this.username = username;
		this.nickname = nickname;
		this.userpwd = userpwd;
		this.usersex = usersex;
		this.birthday = birthday;
		this.identitycode = identitycode;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.status = status;
	}

}
