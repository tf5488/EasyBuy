package service;

import java.util.Date;
import java.util.List;

import dao.UserDao;
import entity.PageBean;
import entity.UserInfo;

public class UserService {
	private UserDao userdao = new UserDao();
	
	// 查找用户列表
	public List<UserInfo> findAll(){
		List<UserInfo> list = userdao.findAll();
		return list;
	}

	// 查找指定用户
	public UserInfo findById(String userId) {
		UserInfo user = userdao.findById(userId);
		return user;
	}

	// 创建新用户
	public int newuser(String username, String nickName, String userPwd, int userSex, Date birthday,
			String identityCode, String email, String mobile, String address, int status) {
		UserDao userdao = new UserDao();
		return userdao.newuser(username, nickName, userPwd, userSex, birthday,
				identityCode,  email,  mobile, address, status);
	}

	// 后台用户列表
	@SuppressWarnings("unused")
	public PageBean<UserInfo> findByPcidPage(int pno,int num){
		PageBean<UserInfo> pagebean = new PageBean<>();
		// 信息总条数
		int infonum = userdao.findAll().size();
		pagebean.setInfonum(infonum);
		// 每页容量
		pagebean.setPage(num);
		// 总页数
		int pagetotal = pagebean.getPagetotal();
		// 当前页
		int pageno = pno;
		pagebean.setPageno(pageno);
		// 每页的信息集合
		List<UserInfo> productlist = userdao.findPage((pagebean.getPageno()-1),num);
		pagebean.setPagelist(productlist);
		return pagebean;
	}

	// 修改指定用户信息
	public int change(UserInfo user) {
		return userdao.change(user);
	}

	// 删除指定用户
	public int dele(String username) {
		return userdao.dele(username);
	}

}
