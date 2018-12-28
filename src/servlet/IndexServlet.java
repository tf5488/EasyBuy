package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.CateGory;
import entity.News;
import entity.Product;
import service.CateGoryService;
import service.NewsService;
import service.ProductService;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		NewsService newsservice = new NewsService();
		CateGoryService categoryservice = new CateGoryService();
		ProductService productservice = new ProductService();
		Cookie pck = null;
		Cookie[] pcks = request.getCookies();
		
		
		List<News> list = newsservice.findAll();
		List<CateGory> parentlist = categoryservice.findParent();
		
		List<Product> pcklist = new ArrayList<>();
		for (Cookie cookie : pcks) {
			if (cookie.getName().equals("prock")) {
				pck = cookie;
				break;
			}
		}
		if(pck != null){
			String pn = pck.getValue();
			String[] pns = pn.split(",");
			List<Integer> proid = new LinkedList<>();
			for (int i = pns.length-1;i >= 0;i--) {
				String pnStr = pns[i];
				int pnum = Integer.parseInt(pnStr);
				if(!proid.contains(pnum)){
					proid.add(pnum);
				}
			}
			if(proid.size() > 3){
				for(int i = 0;i < 3;i++ ){
					int temp = proid.get(i);
					Product product = productservice.findById(temp);
					pcklist.add(product);
				}
			}else{
				for(int i = 0;i < proid.size();i++ ){
					int temp = proid.get(i);
					Product product = productservice.findById(temp);
					pcklist.add(product);
				}
			}
			
		}
		
		
		Map<String, List<CateGory>> cgMap = new LinkedHashMap<>();
		for (CateGory cateGory : parentlist) {
			List<CateGory> childlist = categoryservice.findChildByParent(cateGory.getCid());
			cgMap.put(cateGory.getCname(),childlist);
		}
		String jsonStr = null;
		String temp = request.getParameter("temp");
		switch(temp){
		case "category":
			jsonStr = JSON.toJSONString(cgMap);
			out.print(jsonStr.toString());
			//System.out.println(jsonStr.toString());
			break;
		case "news":
			jsonStr = JSON.toJSONString(list);
			out.println(jsonStr.toString());
			break;
		case "cook":
			jsonStr = JSON.toJSONString(pcklist);
			out.println(jsonStr.toString());
			break;
		}
		out.flush();
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	


}
