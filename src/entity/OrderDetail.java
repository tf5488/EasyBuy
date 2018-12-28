package entity;

// 订单详情
public class OrderDetail {
	private Integer odid; // 订单详情编号
	private String eid; // 订单编号
	private Integer pid; // 商品编号
	private Integer quantity; // 商品数量
	private Double cost; // 单价

	public Integer getOdid() {
		return odid;
	}

	public void setOdid(Integer odid) {
		this.odid = odid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
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

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = Double.parseDouble(String.format("%.2f", cost));
	}

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(Integer odid, String eid, Integer pid, Integer quantity, Double cost) {
		super();
		this.odid = odid;
		this.eid = eid;
		this.pid = pid;
		this.quantity = quantity;
		this.cost = Double.parseDouble(String.format("%.2f", cost));
	}

}
