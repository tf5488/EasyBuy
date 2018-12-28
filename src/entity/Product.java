package entity;

// 商品对象
public class Product {
	private Integer pid;
	private String pname;
	private String description; // 商品描述
	private Double price; // 精度要求(10,2)
	private Integer stock; // 库存状态
	private Integer pcid; // 商品分类
	private String filename; // 商品图片名称

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = Double.parseDouble(String.format("%.2f", price));
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getPcid() {
		return pcid;
	}

	public void setPcid(Integer pcid) {
		this.pcid = pcid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer pid, String pname, String description, Double price, Integer stock, Integer pcid,
			String filename) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.description = description;
		this.price = Double.parseDouble(String.format("%.2f", price));
		this.stock = stock;
		this.pcid = pcid;
		this.filename = filename;
	}

}
