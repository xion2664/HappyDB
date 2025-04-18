package DTO;

public class CardDTO {
	private String name;
	private String mobile;
	private String tel;
	private String address;
	private String email;
	private String company;
	private String staff;
	private String userId;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CardDTO() {
		
	}
	public CardDTO(String name, String mobile, String tel, String address, String email, String company, String staff,
			String userId) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.company = company;
		this.staff = staff;
		this.userId = userId;
	}
	public CardDTO(String name, String mobile, String tel, String address, String email, String company, String staff,
			String userId, int id) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.company = company;
		this.staff = staff;
		this.userId = userId;
		this.id = id;
	}
	
}
