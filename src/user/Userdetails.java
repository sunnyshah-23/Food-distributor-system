package user;

public class Userdetails {
	private String name;
	private String address;
	private String contact;
	private String username;
	private String emailId;
	private String password;
	private Boolean isAdmin;

	Userdetails(String name,String address,String contact,String username,String email,String password, Boolean isAdmin){
		this.name=name;
		this.address=address;
		this.contact=contact;
		this.username=username;
		this.emailId=email;
		this.password=password;
		this.isAdmin=isAdmin;
		
	}

	
	
	//setters
	public void setName(String name) throws Exception {
		if(name.isEmpty() || name.length()<2) throw new Exception("Name cannot be empty");
		this.name=name;
		System.out.print(name.length());
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setContact(String contact) {
		this.contact=contact;
	}
	public void setUserName(String username) {
		this.username=username;
	}
	public void setEmail(String email) {
		this.emailId=email;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	
	//getters
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getContact() {
		return contact;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return emailId;
	}
	public String getPassword() {
		return password;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
}

