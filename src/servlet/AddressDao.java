package servlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import entity.Address;

public class AddressDao extends BaseDao{

	public List<Address> findByUid(int uid) {
		List<Address> list = new ArrayList<>();
		String sql= "SELECT address FROM `addresslist` WHERE userId = ?";
		try {
			rs= super.find(sql, uid);
			while(rs.next()){
				String address = rs.getString("address");
				Address ad = new Address(uid, address);
				list.add(ad);
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

	public int add(int uid, String val) {
		String sql = "insert into addresslist (userId, address)values(?,?)";
		int temp = super.update(sql,uid, val);
		return temp;
	}
	
}
