package service;

import java.util.ArrayList;
import java.util.List;

import dao.CateGoryDao;
import entity.CateGory;
import entity.PageBean;

public class CateGoryService {
	private CateGoryDao category = new CateGoryDao();
	
	// 查找父类
	public List<CateGory> findParent() {
		return category.findParent();
	}

	// 通过父类ID查找子类
	public List<CateGory> findChildByParent(int cid) {
		return category.findChild(cid);
	}

	// 分类的分页
	public PageBean<CateGory> findPage(int pno, int num) {
		PageBean<CateGory> pagebean = new PageBean<>();
		// 创建用于分页的分类列表
		List<CateGory> list = new ArrayList<>();
		// 存放父类
		List<CateGory> parentlist = findParent();
		for (CateGory cg : parentlist) {
			list.add(cg);
			for (CateGory childcg : findChildByParent(cg.getCid())) {
				list.add(childcg);
			}
		}
		// 信息总条数
		int infonum = list.size();
		pagebean.setInfonum(infonum);
		// 每页容量
		pagebean.setPage(num);
		// 总页数
		@SuppressWarnings("unused")
		int pagetotal = pagebean.getPagetotal();
		// 当前页
		int pageno = pno;
		pagebean.setPageno(pageno);
		// 每页的信息集合
		List<CateGory> pagetlist = new ArrayList<>();
		if(list.size() >= num){
			int fromIndex = (pagebean.getPageno()-1)*num;
			if((fromIndex+num)<list.size()){
				pagetlist = list.subList(fromIndex, fromIndex+num);
			}else{
				pagetlist = list.subList(fromIndex,list.size());
			}
		}else{
			pagetlist = list;
		}
		pagebean.setPagelist(pagetlist);
		return pagebean;
	}

	// 查找指定ID的分类
	public CateGory findById(int cid) {
		return category.findById(cid);
	}

	// 修改指定分类信息
	public int change(int cid, String className, Object object) {
		return category.change(cid, className, object);
	}

	// 创建新的分类
	public int addClass(String className, int pid) {
		return category.change(className, pid);
	}

	// 删除指定分类
	public int dele(int pid) {
		return category.dele(pid);
	}
}
