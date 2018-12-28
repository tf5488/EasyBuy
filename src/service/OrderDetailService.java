package service;

import java.util.List;

import dao.OrderDetailDao;
import entity.OrderDetail;

public class OrderDetailService {

	private OrderDetailDao odo = new OrderDetailDao();
	
	public List<OrderDetail> findByOid(String oid) {
		return odo.findByOid(oid);
	}

	public int update(String oid, int id, int num) {
		return odo.changedate(oid,id,num);
	}

	public int add(OrderDetail orderdetail) {
		return odo.add(orderdetail);
	}

	public int delet(String oid, int id) {
		return odo.delet(oid,id);
	}

	public int findByPid(int id, String oid) {
		int temp = 1;
		// 查找购物车pid
		List<Integer> pidlist = odo.findlistByOid(oid);
		for (int pid : pidlist) {
			if(pid == id){
				return temp = 0;
			}
		}
		return temp;
	}

}
