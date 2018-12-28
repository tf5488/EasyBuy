package service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.OderDao;
import dao.OrderDao;
import entity.Oder;
import entity.Order;
import entity.PageBean;

public class OrderService {
	private OrderDao orderdao = new OrderDao();
	private OderDao oderdao = new OderDao();
	
	public Order findByUser(int userId) {
		return orderdao.findByUser(userId);
	}

	@SuppressWarnings("unused")
	public PageBean<Map<Oder, List<Oder>>> findPage(int pno1, int num) {
		PageBean<Map<Oder, List<Oder>>> pagebean = new PageBean<>();
		List<Map<Oder, List<Oder>>> oderMapList = new ArrayList<>();
		List<Oder> orderlist = oderdao.findOid();
		for (Oder od : orderlist) {
			Map<Oder, List<Oder>> oderMap = new LinkedHashMap<>();
			List<Oder> childlist = oderdao.findByOid(od.getOid());
			oderMap.put(od, childlist);
			oderMapList.add(oderMap);
		}
		// 信息总条数
		int infonum = oderMapList.size();
		pagebean.setInfonum(infonum);
		// 每页容量
		pagebean.setPage(num);
		// 总页数
		int pagetotal = pagebean.getPagetotal();
		// 当前页
		int pageno = pno1;
		pagebean.setPageno(pageno);
		// 每页的信息集合
		List<Map<Oder, List<Oder>>> pagetlist = new ArrayList<>();
		if(oderMapList.size() >= num){
			int fromIndex = (pagebean.getPageno()-1)*num;
			if((fromIndex+num)<oderMapList.size()){
				pagetlist = oderMapList.subList(fromIndex, (fromIndex+num));
			}else{
				pagetlist = oderMapList.subList(fromIndex,oderMapList.size());
			}
		}else{
			pagetlist = oderMapList;
		}
		pagebean.setPagelist(pagetlist);
		return pagebean;
	}

	@SuppressWarnings("unused")
	public PageBean<Map<Oder, List<Oder>>> findPageById(int pno1, int num, int entityId) {
		PageBean<Map<Oder, List<Oder>>> pagebean = new PageBean<>();
		List<Map<Oder, List<Oder>>> oderMapList = new ArrayList<>();
		List<Oder> orderlist = oderdao.findOidByEnt(entityId);
		for (Oder od : orderlist) {
			Map<Oder, List<Oder>> oderMap = new LinkedHashMap<>();
			List<Oder> childlist = oderdao.findByOid(od.getOid());
			oderMap.put(od, childlist);
			oderMapList.add(oderMap);
		}
		// 信息总条数
		int infonum = oderMapList.size();
		pagebean.setInfonum(infonum);
		// 每页容量
		pagebean.setPage(num);
		// 总页数
		int pagetotal = pagebean.getPagetotal();
		// 当前页
		int pageno = pno1;
		pagebean.setPageno(pageno);
		// 每页的信息集合
		List<Map<Oder, List<Oder>>> pagetlist = new ArrayList<>();
		if(oderMapList.size() >= num){
			int fromIndex = (pagebean.getPageno()-1)*num;
			if((fromIndex+num)<oderMapList.size()){
				pagetlist = oderMapList.subList(fromIndex, (fromIndex+num));
			}else{
				pagetlist = oderMapList.subList(fromIndex,oderMapList.size());
			}
		}else{
			pagetlist = oderMapList;
		}
		pagebean.setPagelist(pagetlist);
		return pagebean;
	}

	@SuppressWarnings("unused")
	public PageBean<Map<Oder, List<Oder>>> findPage(int pno1, int num, String userName) {
		PageBean<Map<Oder, List<Oder>>> pagebean = new PageBean<>();
		
		List<Map<Oder, List<Oder>>> oderMapList = new ArrayList<>();
		List<Oder> orderlist = oderdao.findOidByUid(userName);
		for (Oder od : orderlist) {
			Map<Oder, List<Oder>> oderMap = new LinkedHashMap<>();
			List<Oder> childlist = oderdao.findByOid(od.getOid());
			oderMap.put(od, childlist);
			oderMapList.add(oderMap);
		}
		// 信息总条数
		int infonum = oderMapList.size();
		pagebean.setInfonum(infonum);
		// 每页容量
		pagebean.setPage(num);
		// 总页数
		int pagetotal = pagebean.getPagetotal();
		// 当前页
		int pageno = pno1;
		pagebean.setPageno(pageno);
		// 每页的信息集合
		List<Map<Oder, List<Oder>>> pagetlist = new ArrayList<>();
		if(oderMapList.size() >= num){
			int fromIndex = (pagebean.getPageno()-1)*num;
			if((fromIndex+num)<oderMapList.size()){
				pagetlist = oderMapList.subList(fromIndex, (fromIndex+num));
			}else{
				pagetlist = oderMapList.subList(fromIndex,oderMapList.size());
			}
		}else{
			pagetlist = oderMapList;
		}
		pagebean.setPagelist(pagetlist);
		return pagebean;
	}

	public int add(Order order) {
		return orderdao.add(order);
	}

	public int creat(Order order) {
		return orderdao.creat(order);
	}

	// 提交购物车
	public int change(String oid, String add) {
		return orderdao.change(oid,add);
	}

	// 更改订单状态
	public int changeStu(String oid, String tp) {
		return orderdao.changeStu(oid,tp);
	}

}
