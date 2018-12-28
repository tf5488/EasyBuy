package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.OrderDetail;

public class OrderDetailDao extends BaseDao{

	public List<OrderDetail> findByOid(String oid) {
		List<OrderDetail> list = new LinkedList<>();
		String sql = "SELECT eodId,eoId,epId,quantity,cost FROM `easybuyorderdetail` WHERE eoId = ?";
		try {
			rs = super.find(sql, oid);
			while(rs.next()){
				Integer odid = rs.getInt("eodId"); // 订单详情编号
				String eid = rs.getString("eoId"); // 订单编号
				Integer pid = rs.getInt("epId"); // 商品编号
				Integer quantity = rs.getInt("quantity"); // 商品数量
				Double cost = rs.getDouble("cost");
				OrderDetail od = new OrderDetail(odid, eid, pid, quantity, cost);
				list.add(od);
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

	public int add(OrderDetail orderdetail) {
		String oid = orderdetail.getEid();
		int pid = orderdetail.getPid();
		double price = orderdetail.getCost();
		String sql = "INSERT INTO easybuyorderdetail (eoId, epId, quantity, cost)VALUES(?,?,?,?)";
		int temp = super.update(sql,oid,pid,1,price);
		return temp;
	}

	public int changedate(String oid, int id, int num) {
		String sql = "UPDATE easybuyorderdetail SET quantity = ? WHERE eoId = ? AND epId = ?";
		int temp = super.update(sql,num,oid,id);
		return temp;
	}

	public int delet(String oid, int id) {
		String sql = "DELETE FROM easybuyorderdetail WHERE eoId = ? AND epId = ?";
		int temp = super.update(sql,oid,id);
		return temp;
	}

	public List<Integer> findlistByOid(String oid) {
		List<Integer> list = new ArrayList<>();
		String sql = "SELECT epId FROM `easybuyorderdetail` WHERE eoId = ?";
		try {
			rs = super.find(sql, oid);
			while(rs.next()){
				Integer pid = rs.getInt("epId"); // 商品编号
				list.add(pid);
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

}
