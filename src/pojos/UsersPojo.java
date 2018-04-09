package pojos;

public class UsersPojo {
	@Override
	public String toString() {
		return "UsersPojo [uId=" + uId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", address=" + address + ", mobile=" + mobile + ", email=" + email + "]";
	}
	public UsersPojo() {
		super();
	}
	public UsersPojo(String userName, String password, String name, String address, String mobile, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
	}
	public UsersPojo(int uId, String userName, String password, String name, String address, String mobile,
			String email) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private int uId;
	private String userName;
	private String password;
	private String name;
	private String address;
	private String mobile;
	private String email;
}
