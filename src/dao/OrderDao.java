package dao;

import java.sql.SQLException;
import java.util.Date;
import entity.Order;

public class OrderDao extends BaseDao{

	public Order findByUser(int userId) {
		Order order = new Order();
		String sql = "SELECT `eoId`, `userId`, `address`,`createTime`, `cost`,"
				+ " `status`, `type` FROM `easybuyorder` WHERE `userId`=? AND STATUS = 0 "
				+ " ORDER BY `createTime` DESC ";
		try {
			rs = super.find(sql, userId);
			while(rs.next()){
				String oid = rs.getString("eoId");
				Integer userid = rs.getInt("userId");
				String address = rs.getString("address");
				Date createtime = rs.getDate("createTime");
				Double cost = rs.getDouble("cost"); 
				Integer status = rs.getInt("status");
				Integer type = rs.getInt("type"); 
				order.setOid(oid);;
				order.setUserid(userid);
				order.setAddress(address);
				order.setCreatetime(createtime);
				order.setCost(cost);
				order.setStatus(status);
				order.setType(type);
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
		return order;
	}

	public int add(Order order) {
		int uId = order.getUserid();
		String oid = order.getOid();
		String sql = "INSERT INTO easybuyorder (eoId,userId,`status`,`type`)VALUES(?,?,?,?)";
		int temp = super.update(sql, oid,uId,0,1);
		return temp;
	}

	public int creat(Order order) {
		int uId = order.getUserid();
		String oid = order.getOid();
		String add = order.getAddress();
		double cost = order.getCost();
		String sql = "INSERT INTO easybuyorder (eoId,userId,address,cost,`status`,`type`)VALUES(?,?,?,?,?,?)";
		int temp = super.update(sql, oid,uId,add,cost,1,1);
		return temp;
	}

	// 购物车 --> 订单
	public int change(String oid, String add) {
		String sql = "UPDATE easybuyorder SET address = ? , `status` = ? WHERE eoId = ? ";
		int temp = super.update(sql, add,1,oid);
		return temp;
	}

	// 用于修改订单状态
	public int changeStu(String oid, String tp) {
		String sql = "UPDATE easybuyorder SET `status` = ? WHERE eoId = ? ";
		int temp = super.update(sql, tp,oid);
		return temp;
	}

}
