package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Oder;

public class OderDao extends BaseDao{

	public List<Oder> findOid() {
		List<Oder> list = new ArrayList<Oder>();
		String sql = "SELECT od.eoId,od.createTime ,od.status "
				+ " FROM  easybuyorderdetail AS ode "
				+ " INNER JOIN easybuyorder AS od ON od.eoId = ode.eoId "
				+ " WHERE `status` <> 0 "
				+ " GROUP BY eoId"
				+ " ORDER BY  `status` , createTime DESC";
		try {
			rs = super.find(sql);
			while(rs.next()){
				Oder od = new Oder();
				od.setOid(rs.getString("eoId"));
				od.setCreatetime(rs.getDate("createTime"));
				od.setStatus(rs.getInt("status"));
				
				list.add(od);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			closeAll(conn, prs, rs);
		}
		return list;
	}

	public List<Oder> findByOid(String oid) {
		List<Oder> list = new ArrayList<Oder>();
		String sql = "SELECT od.eoId,od.createTime ,od.status,pro.fileName,pro.epName,"
				+ " ode.epId,pro.price,ode.quantity,od.cost "
				+ " FROM  easybuyorderdetail AS ode "
				+ " INNER JOIN easybuyorder AS od ON od.eoId = ode.eoId"
				+ " INNER JOIN easybuyproduct AS pro ON ode.epId = pro.epId"
				+ " WHERE od.eoId = ? ";
		try {
			rs = super.find(sql,oid);
			while(rs.next()){
				Oder od = new Oder();
				od.setFilename(rs.getString("fileName"));
				od.setPname(rs.getString("epName"));
				od.setQuantity(rs.getInt("quantity"));
				od.setCost((rs.getInt("quantity"))*(rs.getDouble("price")));
				od.setPrice(rs.getDouble("price"));
				
				list.add(od);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			closeAll(conn, prs, rs);
		}
		return list;
	}

	public List<Oder> findOidByEnt(int entityId) {
		List<Oder> list = new ArrayList<Oder>();
		String temp = "%"+entityId+"%";
		String sql = "SELECT od.eoId,od.createTime ,od.status "
				+ " FROM  easybuyorderdetail AS ode "
				+ " INNER JOIN easybuyorder AS od ON od.eoId = ode.eoId "
				+ " WHERE od.eoId LIKE ? AND od.status <> 0"
				+ " GROUP BY eoId"
				+ " ORDER BY  `status` , createTime DESC";
		try {
			rs = super.find(sql,temp);
			while(rs.next()){
				Oder od = new Oder();
				od.setOid(rs.getString("eoId"));
				od.setCreatetime(rs.getDate("createTime"));
				od.setStatus(rs.getInt("status"));
				
				list.add(od);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			closeAll(conn, prs, rs);
		}
		return list;
	}

	public List<Oder> findOidByUid(String userName) {
		List<Oder> list = new ArrayList<Oder>();
		String temp = "%"+userName+"%";
		String sql = "SELECT od.eoId,od.createTime ,od.status "
				+ " FROM  easybuyorderdetail AS ode "
				+ " INNER JOIN easybuyorder AS od ON od.eoId = ode.eoId "
				+ " INNER JOIN easybuyuser AS us ON us.userId = od.userId "
				+ " WHERE us.userName LIKE ? AND od.status <> 0"
				+ " GROUP BY eoId"
				+ " ORDER BY  `status` , createTime DESC";
		try {
			rs = super.find(sql,temp);
			while(rs.next()){
				Oder od = new Oder();
				od.setOid(rs.getString("eoId"));
				od.setCreatetime(rs.getDate("createTime"));
				od.setStatus(rs.getInt("status"));
				
				list.add(od);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			closeAll(conn, prs, rs);
		}
		return list;
	}

}
