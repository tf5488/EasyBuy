package service;

import java.util.List;

import dao.NewsDao;
import entity.News;
import entity.PageBean;

public class NewsService {

	private NewsDao newsdao = new NewsDao();
	
	// 查找新闻列表
	public List<News> findAll() {
		return newsdao.findAll();
	}

	// 查找指定新闻
	public News findByNid(int nid) {
		return newsdao.findByNid(nid);
	}

	// 新闻分页
	@SuppressWarnings("unused")
	public PageBean<News> findByPcidPage(int pno1, int num) {
		PageBean<News> pagebean = new PageBean<>();
		// 信息总条数
		int infonum = newsdao.findAll().size();
		pagebean.setInfonum(infonum);
		// 每页容量
		pagebean.setPage(num);
		// 总页数
		int pagetotal = pagebean.getPagetotal();
		// 当前页
		int pageno = pno1;
		pagebean.setPageno(pageno);
		// 每页的信息集合
		List<News> newlist = newsdao.findPage((pagebean.getPageno()-1),num);
		pagebean.setPagelist(newlist);
		return pagebean;
	}

	// 修改指定新闻
	public int changeNews(int nid, String title, String content) {
		return newsdao.changeNews(nid, title, content);
	}

	// 新增
	public int addNews(String title, String content) {
		return newsdao.addNews(title, content);
	}

	// 删除指定新闻
	public int dele(int pid) {
		return newsdao.dele(pid);
	}

}
