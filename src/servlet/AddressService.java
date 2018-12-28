package servlet;

import java.util.List;

import entity.Address;

public class AddressService {
	private AddressDao add = new AddressDao();

	public List<Address> findByUid(int uid) {
		return add.findByUid(uid);
	}

	public int add(int uid, String val) {
		return add.add(uid,val);
	}
	
}
