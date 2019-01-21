package mapper;

import org.apache.ibatis.annotations.Param;

import entity.Order;

public interface OrderMapper {

	// 通过用户ID以及状态查找购物车
	public Order findByUser(int userId);

	// 为用户添加购物车
	public int add(Order order);

	// 为用户添加购物订单
	public int creat(Order order);

	// 购物车 --> 订单
	public int change(@Param("oid") String oid, @Param("address") String add);

	// 用于修改订单状态
	public int changeStu(@Param("oid") String oid, @Param("tp") String tp);

}
