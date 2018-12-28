package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Comment;

public class CommentDao extends BaseDao{

	public List<Comment> findAll() {
		List<Comment> list = new ArrayList<>();
		String sql = "SELECT ecId,reply,content,createTime,replyTime,nickName "
				+ " FROM easybuycomment ";
		try {
			rs = super.find(sql);
			while(rs.next()){
				int ecid = rs.getInt("ecId");
				String reply = rs.getString("reply");  // 回复
				String content = rs.getString("content");  // 问题
				Date createtime = rs.getDate("createTime"); // 问题创建时间
				Date replytime = rs.getDate("replyTime");  // 回复创建时间
				String nickname = rs.getString("nickName");
				Comment com = new Comment(ecid, reply, content, createtime,
						replytime, nickname);
				list.add(com);
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

	public List<Comment> findPage(int pageno, int i) {
		List<Comment> list = new ArrayList<Comment>();
		String sql = "SELECT ecId,reply,content,createTime,replyTime,nickName "
				+ " FROM easybuycomment ORDER BY `createTime` DESC LIMIT ? ,? ";
		try {
			rs = super.find(sql,(pageno*i),i);
			while(rs.next()){
				int ecid = rs.getInt("ecId");
				String reply = rs.getString("reply");  // 回复
				String content = rs.getString("content");  // 问题
				Date createtime = rs.getDate("createTime"); // 问题创建时间
				Date replytime = rs.getDate("replyTime");  // 回复创建时间
				String nickname = rs.getString("nickName");
				Comment com = new Comment(ecid, reply, content, createtime, 
						replytime, nickname);
				list.add(com);
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

	public int creatcomm(String guestName, String guestContent) {
		Timestamp createtime = new Timestamp(new Date().getTime());
		String sql = "INSERT INTO easybuycomment (content,createTime,nickName) "
				+ " VALUES (?,?,?)";
		int temp = super.update(sql, guestContent,createtime,guestName);
		return temp;
	}

	public Comment findById(int ecid) {
		Comment comm = null;
		String sql = "SELECT reply,content,createTime,replyTime,nickName "
				+ " FROM easybuycomment WHERE ecId = ? ";
		try {
			rs = super.find(sql, ecid);
			while(rs.next()){
				String reply = rs.getString("reply");  // 回复
				String content = rs.getString("content");  // 问题
				Date createtime = rs.getDate("createTime"); // 问题创建时间
				Date replytime = rs.getDate("replyTime");  // 回复创建时间
				String nickname = rs.getString("nickName");
				comm = new Comment(ecid, reply, content, createtime, replytime, nickname);
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
		return comm;
	}

	public int change(int ecid, String replyContent) {
		String sql = "UPDATE easybuycomment SET reply = ? ,replyTime = ? WHERE ecId = ? ";
		Timestamp time = new Timestamp(new Date().getTime());
		int temp = super.update(sql, replyContent ,time ,ecid);
		return temp;
	}

	public int dele(int pid) {
		String sql = "DELETE FROM easybuycomment WHERE ecId = ? ";
		int temp = super.update(sql, pid);
		return temp;
	}

}
