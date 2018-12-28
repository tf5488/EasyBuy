package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/easybuy?useUnicode=true&"
			+ "charaterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
	private String user = "root";
	private String password = "root";
	
	protected Connection conn;
	protected PreparedStatement prs;
	protected ResultSet rs;
	
	public Connection connection() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		Class.forName(driverName);
		conn = DriverManager.getConnection(url, user, password);
		return conn; 
	}
	
	public void closeAll(Connection conn,PreparedStatement prs,ResultSet rs){
			try {
				if(rs != null){
					rs.close();
				}
				if(prs != null){
					prs.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public ResultSet find(String sql,Object... obj) throws ClassNotFoundException, SQLException{
		ResultSet rs = null;
		conn = connection();
		prs = conn.prepareStatement(sql);
		for(int i = 0;i < obj.length;i++){
			prs.setObject((i+1), obj[i]);
		}
		rs = prs.executeQuery();
		return rs;
	}
	
	public int update(String sql,Object... obj) {
		int temp = 0;
		try {
			conn = connection();
			prs = conn.prepareStatement(sql);
			for(int i = 0;i < obj.length;i++){
				prs.setObject((i+1), obj[i]);
			}
			temp = prs.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, prs, rs);
		}
		return temp;
	}
	
}
