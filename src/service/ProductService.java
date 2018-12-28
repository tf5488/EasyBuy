package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.ProductDao;
import entity.PageBean;
import entity.Product;

public class ProductService {
	private ProductDao productdao = new ProductDao();
	
	// 查找商品列表
	public List<Product> findAll() {
		return productdao.findAll();
	}

	// 查找产品分类页面
	@SuppressWarnings("unused")
	public PageBean<Product> findPage(int tep,int num) {
		PageBean<Product> pagebean = new PageBean<>();
		// 信息总条数
		int infonum = productdao.findAll().size();
		pagebean.setInfonum(infonum);
		// 每页容量
		pagebean.setPage(num);
		// 总页数
		int pagetotal = pagebean.getPagetotal();
		// 当前页
		int pageno = tep;
		pagebean.setPageno(pageno);
		// 每页的信息集合
		List<Product> productlist = productdao.findPage((pagebean.getPageno()-1),num);
		//System.out.println(productlist.size());
		pagebean.setPagelist(productlist);
		return pagebean;
	}

	// 通过 id 查找指定商品
	public Product findById(int prono) {
		return productdao.findById(prono);
	}

	// 通过分类查找商品列表
	public List<Product> findByPcid(int cid1) {
		return productdao.findByPcid(cid1);
	}

	// 分类商品列表的分页
	@SuppressWarnings("unused")
	public PageBean<Product> findByPcidPage(int cid1, int pno1) {
		PageBean<Product> pagebean = new PageBean<>();
		List<Product> prolist = findByPcid(cid1);
		// 信息总条数
		int infonum = prolist.size();
		pagebean.setInfonum(infonum);
		// 每页容量
		pagebean.setPage(8);
		// 总页数
		int pagetotal = pagebean.getPagetotal();
		// 当前页
		int pageno = pno1;
		pagebean.setPageno(pageno);
		// 每页的信息集合
		List<Product> productlist = new ArrayList<Product>();
		if(prolist.size() >= 8){
			int fromIndex = (pagebean.getPageno()-1)*8;
			if((fromIndex+8)<prolist.size()){
				productlist = prolist.subList(fromIndex, fromIndex+8);
			}else{
				productlist = prolist.subList(fromIndex,prolist.size());
			}
			
		}else{
			productlist = prolist;
		}
		pagebean.setPagelist(productlist);
		return pagebean;
	}

	// 修改指定商品信息
	public int change(Product pro) {
		return productdao.change(pro);
	}

	// 删除指定商品
	public int dele(int pid) {
		return productdao.dele(pid);
	}

	// 增加商品
	public int addProduct(Product product) {
		return productdao.addProduct(product);
	}

	// 修改商品库存
	public int changeStock(Map<Integer, Integer> shopmap) {
		for (int pid : shopmap.keySet()) {
			// 根据pid查找库存数据
			Product pro = findById(pid);
			int stock = pro.getStock();
			int num = stock - shopmap.get(pid);
			@SuppressWarnings("unused")
			int temp = productdao.changeStock(pid,num);
		}
		return 0;
	}

}
