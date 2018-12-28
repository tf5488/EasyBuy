package entity;

public class Address {
	private int uid;
	private String address;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int uid, String address) {
		super();
		this.uid = uid;
		this.address = address;
	}

}
