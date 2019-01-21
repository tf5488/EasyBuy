package mapper;

import java.util.List;

import entity.UserInfo;

public interface UserMapper {
	
	// 查找用户列表
	public List<UserInfo> findAll();
	
	// 通过 username 查找指定用户
	public UserInfo findById(String userName);
	
	// 创建一个新的用户
	public int newuser(UserInfo user);

	// 修改指定用户的信息
	public int change(UserInfo user);
	
	// 通过用户名 ----> 删除指定用户
	public int dele(String username);
	
	
	
	/*

	// 创建一个新的用户
	public int newuser(String username, String nickName, String userPwd, int userSex, java.util.Date birthday,
			String identityCode, String email, String mobile, String address, int status) {

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

	// 通过用户名 ----> 删除指定用户
	public int dele(String username) {
	*/

}
