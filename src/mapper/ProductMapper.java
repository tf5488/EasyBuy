package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Product;

public interface ProductMapper {
	
	// 查找商品列表
	public List<Product> findAll(); 
	
	// 通过 id 查找指定商品
	public Product findById(int prono);
	
	// 通过分类查找商品列表
	public List<Product> findByPcid(int cid1);
	
	// 修改指定商品信息
	public int change(Product pro);
	
	// 删除指定商品
	public int dele(int pid); 
	
	// 新建商品信息
	public int addProduct(Product product);
	
	// 修改商品库存
	public int changeStock(@Param("pid")int pid,@Param("num")int num);
	
	// 商品分页列表
	//public List<Product> findPage(int pageno, int i);
	
	
	/*// 查找商品列表
	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT epId,epName,description,price,stock,epcId,fileName "
				+ " FROM easybuyproduct ";
	

	// 商品分页列表
	public List<Product> findPage(int pageno, int i) {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT epId,epName,description,price,stock,epcId,fileName "
				+ " FROM easybuyproduct LIMIT ? ,? ";
		try {
			rs = super.find(sql,(pageno*i),i);
			while(rs.next()){
				Integer pid = rs.getInt("epId");
				String pname = rs.getString("epName");
				String description = rs.getString("description"); 
				Double price = rs.getDouble("price"); 
				Integer stock = rs.getInt("stock"); 
				Integer pcid = rs.getInt("epcId"); 
				String filename = rs.getString("fileName");
				Product product = new Product(pid, pname, description, price, stock,
						pcid, filename);
				list.add(product);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, prs, rs);
		}
		return list;
	}

	// 通过 id 查找指定商品
	public Product findById(int prono) {
		Product product = null;
		String sql = "SELECT epName,description,price,stock,epcId,fileName "
				+ " FROM easybuyproduct WHERE epId = ? ";
		

	// 通过分类查找商品列表
	public List<Product> findByPcid(int cid1) {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT epId,epName,description,price,stock,epcId,fileName "
				+ " FROM easybuyproduct WHERE epcId = ? ";
		
	// 修改指定商品信息
	public int change(Product pro) {
		Integer pid = pro.getPid();
		String pname = pro.getPname();
		String description = pro.getDescription(); 
		Double price = pro.getPrice(); 
		Integer stock = pro.getStock(); 
		Integer pcid = pro.getPcid(); 
		String filename = pro.getFilename();
		
		String sql = "UPDATE easybuyproduct SET epName = ? ,description = ? ,price = ? ,"
				+ "stock = ? ,epcId = ? , fileName = ? WHERE epId = ?";
		int temp = super.update(sql, pname,description,price,
				stock,pcid,filename,pid);
		return temp;
	}

	// 删除指定商品
	public int dele(int pid) {
		String sql = "DELETE FROM easybuyproduct WHERE epId = ?";
		int temp = super.update(sql, pid);
		return temp;
	}

	// 新建商品信息
	public int addProduct(Product product) {
		String pname = product.getPname();
		String description = product.getDescription(); 
		Double price = product.getPrice(); 
		Integer stock = product.getStock(); 
		Integer pcid = product.getPcid(); 
		String filename = product.getFilename();
		String sql = "insert into easybuyproduct (epName,description,price,"
				+ "stock,epcId,fileName)values(?,?,?,?,?,?)";
		int temp = super.update(sql, pname,description,price,stock,pcid,filename);
		return temp;
	}

	// 修改商品库存
	public int changeStock(int pid, int num) {
		String sql = "UPDATE easybuyproduct SET stock = ?  WHERE epId = ?";
		int temp = super.update(sql, num,pid);
		return temp;
	}*/

}
