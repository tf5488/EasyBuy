package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.CateGory;

public interface CateGoryMapper {

	// 查找父类列表
	public List<CateGory> findParent();
		/*String sql = "SELECT epcId,epcName,parentId FROM easybuycategory "
				+ " WHERE epcId = parentId OR parentId = 0";*/
		

	// 通过父类查找所属子类列表
	public List<CateGory> findChild(int cid2);
		/*List<CateGory> list = new ArrayList<CateGory>();
		String sql = "SELECT epcId,epcName,parentId FROM easybuycategory "
				+ " WHERE parentId = ?  AND epcId <> parentId ";*/

	// 通过ID查找分类
	public CateGory findById(int cid);
		/*CateGory category = null;
		String sql = "SELECT epcId,epcName,parentId FROM easybuycategory  WHERE epcId = ?";*/

	// 修改指定分类的信息
	public int change(@Param("cid")int cid, @Param("className")String className, @Param("parentId")int parentId);
		/*String sql = "UPDATE easybuycategory SET epcName = ? , parentId = ? WHERE epcId = ?";
		int temp = super.update(sql, className ,object, cid);*/

	// 新增一个分类
	public int creat(@Param("className")String className, @Param("pid")int pid);
		/*String sql = "INSERT INTO easybuycategory (epcName,parentId)VALUES(?,?)";
		int temp = super.update(sql, className ,pid);*/

	// 删除指定分类
	public int dele(int pid);
		/*String sql = "DELETE FROM easybuycategory WHERE epcId = ? ";
		int temp = super.update(sql, pid);*/
}
