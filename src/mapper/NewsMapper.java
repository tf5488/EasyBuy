package mapper;

import java.util.List;

import entity.News;

public interface NewsMapper{

	// 查找新闻列表
	public List<News> findAll();
		/*List<News> list = new ArrayList<News>();
		String sql = "SELECT enId, title, content, createTime FROM easybuynews ";*/

	// 通过 id 查找指定新闻
	public News findByNid(int nid);
		/*News news = null;
		String sql = "SELECT enId, title, content, createTime FROM easybuynews WHERE enId=? ";*/

	// 新闻分页列表
	public List<News> findPage(int pageno, int i);
		/*List<News> list = new ArrayList<News>();
		String sql = "SELECT enId, title, content, createTime FROM easybuynews LIMIT ? ,? ";*/

	// 修改指定新闻
	public int changeNews(int nid, String title, String content);
		/*String sql = "UPDATE easybuynews SET title = ? , content = ? WHERE enId = ?";
		int temp = super.update(sql, title,content,nid);*/

	// 新增新闻
	public int addNews(String title, String content);
		/*String sql = "INSERT INTO easybuynews (title,content,createTime)VALUES(?,?,?)";
		Date date = new Date(System.currentTimeMillis());
		java.sql.Date time = new java.sql.Date(date.getTime());
		int temp = super.update(sql, title,content,time);*/

	// 删除指定新闻
	public int dele(int pid);
		/*String sql = "DELETE FROM easybuynews WHERE enId = ?";
		int temp = super.update(sql, pid);*/

}
