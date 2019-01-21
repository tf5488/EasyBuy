package mapper;

import java.util.List;

import entity.Oder;

public interface OderMapper{

	public List<Oder> findOid();
		/*List<Oder> list = new ArrayList<Oder>();
		String sql = "SELECT od.eoId,od.createTime ,od.status "
				+ " FROM  easybuyorderdetail AS ode "
				+ " INNER JOIN easybuyorder AS od ON od.eoId = ode.eoId "
				+ " WHERE `status` <> 0 "
				+ " GROUP BY eoId"
				+ " ORDER BY  `status` , createTime DESC";*/

	public List<Oder> findByOid(String oid);
		/*List<Oder> list = new ArrayList<Oder>();
		String sql = "SELECT od.eoId,od.createTime ,od.status,pro.fileName,pro.epName,"
				+ " ode.epId,pro.price,ode.quantity,od.cost "
				+ " FROM  easybuyorderdetail AS ode "
				+ " INNER JOIN easybuyorder AS od ON od.eoId = ode.eoId"
				+ " INNER JOIN easybuyproduct AS pro ON ode.epId = pro.epId"
				+ " WHERE od.eoId = ? ";*/

	public List<Oder> findOidByEnt(int entityId);
		/*List<Oder> list = new ArrayList<Oder>();
		String temp = "%"+entityId+"%";
		String sql = "SELECT od.eoId,od.createTime ,od.status "
				+ " FROM  easybuyorderdetail AS ode "
				+ " INNER JOIN easybuyorder AS od ON od.eoId = ode.eoId "
				+ " WHERE od.eoId LIKE ? AND od.status <> 0"
				+ " GROUP BY eoId"
				+ " ORDER BY  `status` , createTime DESC";*/

	public List<Oder> findOidByUid(String userName);
		/*List<Oder> list = new ArrayList<Oder>();
		String temp = "%"+userName+"%";
		String sql = "SELECT od.eoId,od.createTime ,od.status "
				+ " FROM  easybuyorderdetail AS ode "
				+ " INNER JOIN easybuyorder AS od ON od.eoId = ode.eoId "
				+ " INNER JOIN easybuyuser AS us ON us.userId = od.userId "
				+ " WHERE us.userName LIKE ? AND od.status <> 0"
				+ " GROUP BY eoId"
				+ " ORDER BY  `status` , createTime DESC";*/
		

}
