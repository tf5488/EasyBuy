package dao;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.UserInfo;

public class UserDao extends BaseDao {

	// 查找用户列表
	public List<UserInfo> findAll() {
		List<UserInfo> list = new ArrayList<UserInfo>();
		String sql = "SELECT * FROM easybuyuser ";
		try {
			rs = super.find(sql);
			while (rs.next()) {
				int userId = rs.getInt("userId");
				String username = rs.getString("userName");
				String nickName = rs.getString("nickName");
				String userPwd = rs.getString("userPwd");
				int userSex = rs.getInt("userSex");
				Date birthday = rs.getDate("birthday");
				String identityCode = rs.getString("identityCode");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				int status = rs.getInt("status");
				UserInfo user = new UserInfo(userId, username, nickName, userPwd,
						userSex, birthday, identityCode, email, mobile,
						address, status);
				list.add(user);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, prs, rs);
		}
		return list;
	}

	// 通过 username 查找指定用户
	public UserInfo findById(String userName) {
		UserInfo user = null;
		String sql = "SELECT * FROM easybuyuser WHERE username = ?";
		try {
			rs = super.find(sql, userName);
			if (rs.next()) {
				int userId = rs.getInt("userId");
				String nickName = rs.getString("nickName");
				String userPwd = rs.getString("userPwd");
				int userSex = rs.getInt("userSex");
				Date birthday = rs.getDate("birthday");
				String identityCode = rs.getString("identityCode");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				int status = rs.getInt("status");
				user = new UserInfo(userId, userName, nickName, userPwd, userSex,
						birthday, identityCode, email, mobile, address, status);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, prs, rs);
		}
		return user;
	}

	// 创建一个新的用户
	public int newuser(String username, String nickName, String userPwd, int userSex, java.util.Date birthday,
			String identityCode, String email, String mobile, String address, int status) {
		int temp = 0;
		String sql = "INSERT INTO easybuyuser (userName,nickName,userPwd,userSex,birthday,identityCode,email,mobile,address,`status`)VALUES(?,?,?,?,?,?,?,?,?,?)";
		temp = super.update(sql,username,nickName,userPwd,userSex,birthday,identityCode,email,mobile,address,status);
		return temp;
	}

	// 获取分页的用户列表
	public List<UserInfo> findPage(int pageno, int i) {
		List<UserInfo> list = new ArrayList<UserInfo>();
		String sql = "SELECT * FROM easybuyuser LIMIT ? ,? ";
		try {
			rs = super.find(sql,(pageno*i),i);
			while(rs.next()){
				int userId = rs.getInt("userId");
				String userName = rs.getString("userName");
				String nickName = rs.getString("nickName");
				String userPwd = rs.getString("userPwd");
				int userSex = rs.getInt("userSex");
				Date birthday = rs.getDate("birthday");
				String identityCode = rs.getString("identityCode");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				int status = rs.getInt("status");
				UserInfo user = new UserInfo(userId, userName, nickName, userPwd, userSex,
						birthday, identityCode, email, mobile, address, status);
				list.add(user);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, prs, rs);
		}
		return list;
	}

	// 修改指定用户的信息
	public int change(UserInfo user) {
		int userId = user.getUserId();
		String userName = user.getUsername();
		String nickName = user.getNickName();
		String userPwd = user.getUserPwd();
		int userSex = user.getUserSex();
		Date birthday = user.getBirthday();
		String mobile = user.getMobile();
		String address = user.getAddress();
		int statu = user.getStatus();
		
		String sql = "UPDATE easybuyuser SET userName = ?,nickName =? , userPwd = ? "
				+ " ,userSex = ? , birthday = ? , mobile = ? , "
				+ "	address = ? ,status = ? WHERE userId = ?";
		int temp = super.update(sql, userName,nickName,userPwd,userSex,birthday,mobile,
				address,statu,userId);
		return temp;
	}

	// 通过用户名 ----> 删除指定用户
	public int dele(String username) {
		String sql = "DELETE FROM easybuyuser WHERE userName = ?";
		int temp = super.update(sql,username);
		return temp;
	}

}
