package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.News;

public class NewsDao extends BaseDao{

	// 查找新闻列表
	public List<News> findAll() {
		List<News> list = new ArrayList<News>();
		String sql = "SELECT enId, title, content, createTime FROM easybuynews ";
		try {
			rs= super.find(sql);
			while(rs.next()){
				int nid = rs.getInt("enId");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createtime = rs.getDate("createTime");
				News news = new News(nid, title, content, createtime);
				list.add(news);
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

	// 通过 id 查找指定新闻
	public News findByNid(int nid) {
		News news = null;
		String sql = "SELECT enId, title, content, createTime FROM easybuynews WHERE enId=? ";
		try {
			rs= super.find(sql,nid);
			while(rs.next()){
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createtime = rs.getDate("createTime");
				news = new News(nid, title, content, createtime);
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
		return news;
	}

	// 新闻分页列表
	public List<News> findPage(int pageno, int i) {
		List<News> list = new ArrayList<News>();
		String sql = "SELECT enId, title, content, createTime FROM easybuynews LIMIT ? ,? ";
		try {
			rs = super.find(sql,(pageno*i),i);
			while(rs.next()){
				int nid = rs.getInt("enId");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createtime = rs.getDate("createTime");
				News news = new News(nid, title, content, createtime);
				list.add(news);
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

	// 修改指定新闻
	public int changeNews(int nid, String title, String content) {
		String sql = "UPDATE easybuynews SET title = ? , content = ? WHERE enId = ?";
		int temp = super.update(sql, title,content,nid);
		return temp;
	}

	// 新增新闻
	public int addNews(String title, String content) {
		String sql = "INSERT INTO easybuynews (title,content,createTime)VALUES(?,?,?)";
		Date date = new Date(System.currentTimeMillis());
		java.sql.Date time = new java.sql.Date(date.getTime());
		int temp = super.update(sql, title,content,time);
		return temp;
	}

	// 删除指定新闻
	public int dele(int pid) {
		String sql = "DELETE FROM easybuynews WHERE enId = ?";
		int temp = super.update(sql, pid);
		return temp;
	}

}
