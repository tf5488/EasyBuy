package servlet.manage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.Product;
import service.ProductService;

public class ManageUplondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ProductService productservice = new ProductService();
		// 将字符串数组装换为List集合
		List<String> fileType = Arrays.asList("gif", "bmp", "jpg", "jpeg"); // 做一个常量池
		int result = 0;
		boolean flag = true;
		Product product = new Product();  // 新建一个空的商品对象用于储存查找的数据
		// 上传文件的存储路径（服务器文件系统上的绝对文件路径）
		try {
			String path = this.getServletContext().getRealPath("/images/product");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdir();
			}
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(1024*1024*5); // 设置文件可用大小
			int childId = 0;
			@SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(request);//接受前台传入的数据
			for (FileItem item : list) {
				if (item.isFormField()) { // 如果对象是来自表单 则对比表单name属性
					if (item.getFieldName().equals("productName")) {
						product.setPname(item.getString("UTF-8"));
					} else if (item.getFieldName().equals("productDescription")) {
						product.setDescription(item.getString("UTF-8"));
					} else if (item.getFieldName().equals("parentId")) {
						childId = Integer.parseInt(item.getString("UTF-8"));
						product.setPcid(childId); // 商品的实体类属性
					} else if (item.getFieldName().equals("productPrice")) {
						product.setPrice(Double.parseDouble(item
								.getString("UTF-8")));
					} else if (item.getFieldName().equals("productStock")) {
						product.setStock(Integer.parseInt(item
								.getString("UTF-8")));
					}else if (item.getFieldName().equals("pid")) {
						product.setPid(Integer.parseInt(item
								.getString("UTF-8")));
					}
				} else {
					String fileName = item.getName();//获得上传的文件
					if (!(fileName == null || fileName.equals(""))) {
						String pic = new File(fileName).getName();  // 获取文件名
						String type = pic.substring(pic.lastIndexOf(".") + 1); // 切割文件后缀
						if (fileType.contains(type.toLowerCase())) {
							product.setFilename(pic);
							String uploadPath = path + "/" + pic;
							item.write(new File(uploadPath));
						} else {
							flag = false;
						}
					}
				}
			}
			if (flag) {
				// 判断是商品修改 还是 增加
				if(product.getPid() != null){
					// 修改
					result = productservice.change(product);
					if (result > 0) {
						request.getRequestDispatcher("manage-result.jsp").forward(
								request, response);
					} else {
						request.setAttribute("msg", "商品修改信息失败！");
						request.getRequestDispatcher("product-modify.jsp").forward(
								request, response);
					}
				}else{
					// 增加
					result = productservice.addProduct(product);
					if (result > 0) {
						request.getRequestDispatcher("manage-result.jsp").forward(
								request, response);
					} else {
						request.setAttribute("msg", "上传文件失败！");
						request.getRequestDispatcher("product-add.jsp").forward(
								request, response);
					}
				}
				
			} else {
				request.setAttribute("msg", "上传文件的格式不正确！");
				request.getRequestDispatcher("product-add.jsp").forward(
						request, response);
			}
		} catch (FileUploadException e) {
			String msg = "上传失败，上传文件过大！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("product-add.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
