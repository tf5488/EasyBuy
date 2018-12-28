package service;

import java.util.List;

import dao.CommentDao;
import entity.Comment;
import entity.PageBean;

public class CommentService {
	private CommentDao comdao = new CommentDao();

	// 留言的分页显示
	@SuppressWarnings("unused")
	public PageBean<Comment> findByPcidPage(int pno1,int num) {
		PageBean<Comment> pagebean = new PageBean<>();
		// 信息总条数
		int infonum = comdao.findAll().size();
		pagebean.setInfonum(infonum);
		// 每页容量
		pagebean.setPage(num);
		// 总页数
		int pagetotal = pagebean.getPagetotal();
		// 当前页
		int pageno = pno1;
		pagebean.setPageno(pageno);
		// 每页的信息集合
		List<Comment> productlist = comdao.findPage((pagebean.getPageno()-1),num);
		pagebean.setPagelist(productlist);
		return pagebean;
	}

	// 新增留言
	public String creatcomm(String guestName, String guestContent) {
		String msg = null;
		int temp = comdao.creatcomm(guestName,guestContent);
		if(temp > 0){
			msg = "提交成功!";
		}else{
			msg = "提交失败!";
		}
		return msg;
	}

	// 后台查找指定留言   ---> 用于修改
	public Comment findById(int ecid) {
		return comdao.findById(ecid);
	}

	// 留言的回复和修改
	public int change(int ecid, String replyContent) {
		return comdao.change(ecid, replyContent);
	}

	// 留言的后台删除
	public int dele(int pid) {
		return comdao.dele(pid);
	}

}
