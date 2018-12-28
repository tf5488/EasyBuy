package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CateGory;

public class CateGoryDao extends BaseDao {

	// 查找父类列表
	public List<CateGory> findParent() {
		List<CateGory> list = new ArrayList<CateGory>();
		String sql = "SELECT epcId,epcName,parentId FROM easybuycategory "
				+ " WHERE epcId = parentId OR parentId = 0";
		try {
			rs = super.find(sql);
			while(rs.next()){
				int cid = rs.getInt("epcId");
				String cname = rs.getString("epcName");
				int parentid = rs.getInt("parentId");
				CateGory category = new CateGory(cid, cname, parentid);
				list.add(category);
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

	// 通过父类查找所属子类列表
	public List<CateGory> findChild(int cid2) {
		List<CateGory> list = new ArrayList<CateGory>();
		String sql = "SELECT epcId,epcName,parentId FROM easybuycategory "
				+ " WHERE parentId = ?  AND epcId <> parentId ";
		try {
			rs = super.find(sql,cid2);
			while(rs.next()){
				int cid = rs.getInt("epcId");
				String cname = rs.getString("epcName");
				int parentid = rs.getInt("parentId");
				CateGory category = new CateGory(cid, cname, parentid);
				list.add(category);
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

	// 通过ID查找分类
	public CateGory findById(int cid) {
		CateGory category = null;
		String sql = "SELECT epcId,epcName,parentId FROM easybuycategory  WHERE epcId = ?";
		try {
			rs = super.find(sql, cid);
			while(rs.next()){
				String cname = rs.getString("epcName");
				int parentid = rs.getInt("parentId");
				category = new CateGory(cid, cname, parentid);
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
		return category;
	}

	// 修改指定分类的信息
	public int change(int cid, String className, Object object) {
		String sql = "UPDATE easybuycategory SET epcName = ? , parentId = ? WHERE epcId = ?";
		int temp = super.update(sql, className ,object, cid);
		return temp;
	}

	// 新增一个分类
	public int change(String className, int pid) {
		String sql = "INSERT INTO easybuycategory (epcName,parentId)VALUES(?,?)";
		int temp = super.update(sql, className ,pid);
		return temp;
	}

	// 删除指定分类
	public int dele(int pid) {
		String sql = "DELETE FROM easybuycategory WHERE epcId = ? ";
		int temp = super.update(sql, pid);
		return temp;
	}
}
