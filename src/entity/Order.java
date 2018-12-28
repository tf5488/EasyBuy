package entity;

import java.util.Date;

// 订单对象
public class Order {
	private String oid;  // 订单ID
	private Integer userid; // 用户ID
	private String address; // 用户地址
	private Date createtime; // 创建时间
	private Double cost; // 精度要求 (10,2)
	private Integer status;  // 订单状态 0 购物车未付款 1 下单 2 审核通过 3 配货 4 送货中 5收获并确认
	private Integer type;  // 1 货到付款 2 网上支付

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = Double.parseDouble(String.format("%.2f", cost)); // 处理精度问题
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String oid, Integer userid, String address, Date createtime, Double cost, Integer status,
			Integer type) {
		super();
		this.oid = oid;
		this.userid = userid;
		this.address = address;
		this.createtime = createtime;
		this.cost = Double.parseDouble(String.format("%.2f", cost));
		this.status = status;
		this.type = type;
	}

}
