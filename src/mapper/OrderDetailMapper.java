package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.OrderDetail;

public interface OrderDetailMapper{

	public List<OrderDetail> findByOid(String oid);
		/*List<OrderDetail> list = new LinkedList<>();
		String sql = "SELECT eodId,eoId,epId,quantity,cost FROM `easybuyorderdetail` WHERE eoId = ?";*/

	public int add(OrderDetail orderdetail);
		/*String oid = orderdetail.getEid();
		int pid = orderdetail.getPid();
		double price = orderdetail.getCost();
		String sql = "INSERT INTO easybuyorderdetail (eoId, epId, quantity, cost)VALUES(?,?,?,?)";
		int temp = super.update(sql,oid,pid,1,price);
		return temp;*/

	public int changedate(@Param("oid")String oid, @Param("id")int id, @Param("num")int num);
		/*String sql = "UPDATE easybuyorderdetail SET quantity = ? WHERE eoId = ? AND epId = ?";
		int temp = super.update(sql,num,oid,id);
		return temp;*/

	public int delet(@Param("oid")String oid,  @Param("id")int id);
		/*String sql = "DELETE FROM easybuyorderdetail WHERE eoId = ? AND epId = ?";
		int temp = super.update(sql,oid,id);
		return temp;*/

	public List<Integer> findlistByOid(String oid); 
		/*List<Integer> list = new ArrayList<>();
		String sql = "SELECT epId FROM `easybuyorderdetail` WHERE eoId = ?";*/

}
