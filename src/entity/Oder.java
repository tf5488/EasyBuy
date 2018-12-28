package entity;

import java.util.Date;

// 订单对象
public class Oder {
	private String oid; // 订单ID 11位
	private Integer userid; // 用户ID
	private String address; // 用户地址
	private Date createtime; // 创建时间
	private Double cost; // 精度要求 (10,2) 总价
	private Integer status; // 订单状态 1 下单 2 审核通过 3 配货 4 送货中 5收货并确认
	private Integer type; // 1 货到付款 2 网上支付

	private Integer pid; // 商品编号
	private Integer quantity; // 商品数量
	private Double price; // 单价
	
	private String pname;
	private Integer stock; // 库存状态
	private String filename; // 商品图片名称

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
		this.cost = cost;
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Oder() {
		super();
		// TODO Auto-generated constructor stub
	}
}
