package user;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;

import food.Product;

import java.util.*;
public class Auth {
	private String name;
	private String address;
	private String contact;
	private String username;
	private String emailId;
	private String password;
	private Boolean isAdmin=false;
	private HashSet<Userdetails>registerdUsers=new HashSet<Userdetails>();
	private Userdetails loggedIn;
	
	//register user
	public void register(String name,String address,String contact,String username,String email,String password) throws Exception {
		readRegisterData("registerUser.txt");
		setName(name);
		setAddress(address);
		setContact(contact);
		setUserName(username);
		setEmail(email);
		setPassword(password);
		
		//check if user is already registered
		if(validateRegisterUser()) {
			Userdetails userInfo=new Userdetails(this.name,this.address,this.contact,this.username,this.emailId,this.password,this.isAdmin);
			writeData(userInfo);
		}
	
		
	}
	
	//Login user
	public Boolean login(String username, String password) throws Exception {
		readRegisterData("registerUser.txt");
		setUserName(username);
		setPassword(password);
		for(Userdetails user:registerdUsers) {
			if(user.getUsername().equals(getUsername())) {
				if(user.getPassword().equals(getPassword())) {
					setisLoggedin(user);
					
				
					return true;
				}
				else {
					throw new Exception("Invalid Password");
				}
			
			}
		}

		throw new Exception("Invalid username or user not registered!");
		
	}
	
	//Logout user
	public void logout() {
		loggedIn=null;
		registerdUsers.clear();
		System.out.print("\n-------------------User Logged out successfully-------------------");
	}
	
	//create string of userdetails and call saveTofIle()
	public void writeData(Userdetails user) throws IOException {
		StringBuilder registerData=new StringBuilder(user.getName() + "|" + user.getAddress() + "|" + user.getContact() + "|" + user.getUsername() + "|" + user.getEmail() + "|" + user.getPassword() + "|" + user.getIsAdmin());
		StringBuilder loginData=new StringBuilder(user.getUsername() + "|" + user.getEmail() + "|" + user.getPassword() + "|" + user.getIsAdmin());
		saveToFile("registerUser.txt",registerData.toString(),true);
		saveToFile("Login.txt",loginData.toString(),true);

	}
	
	
	
	//Write data to file
	public void saveToFile(String fileName,String text,boolean append) throws IOException{
		File file1=new File(fileName);
		FileWriter fw=new FileWriter(file1,append);
		PrintWriter pw=new PrintWriter(fw);
		pw.println(text);
		pw.close();
	
		
	}
	
	//check is user is already registered
	public Boolean validateRegisterUser() throws Exception{
	
		if(!registerdUsers.isEmpty()) {
			for(Userdetails user:registerdUsers) {
				if(user.getEmail().equals(this.emailId)) {
					throw new Exception("Emailid already registered");
				}
				else if(user.getUsername().equals(this.username)) {
					throw new Exception("username already taken");
				}
			}
		}
		
		//user is not registered
		return true;
	}
	
	//read user data from file and store it in Hashset registerUser
	public void readRegisterData(String fileName) throws FileNotFoundException {
		File file=new File(fileName);
		Scanner load=new Scanner(file);
		if(file.length()!=0) {
			while(load.hasNextLine()) {
				String line=load.nextLine();
				String[] items=line.split("\\|");
				String r_name=items[0];
				String r_address=items[1];
				String r_contact=items[2];
				String r_username=items[3];
				String r_email=items[4];
				String r_password=items[5];
				Boolean r_isAdmin=Boolean.valueOf(items[6]);
				Userdetails r_userInfo=new Userdetails(r_name,r_address,r_contact,r_username,r_email,r_password,r_isAdmin);
				registerdUsers.add(r_userInfo);		
				
			}
		}
		load.close();
	
	
	}
	

	
	//setters
	public void setName(String name) throws Exception {
		if(name.isEmpty() || name.length()<3) throw new Exception("Name cannot be less than 3 characters, please register again!");
		this.name=name;
	
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setContact(String contact) throws Exception {
		if(contact.length()<10) throw new Exception("Contact info cannot be less than 10 digits, please register again!");
		this.contact=contact;
	}
	public void setUserName(String username) {
		this.username=username;
	}
	public void setEmail(String email) throws Exception {
		   String regex = "^(.+)@(.+)$";  
		   Pattern pattern = Pattern.compile(regex);  
		   Matcher matcher = pattern.matcher(email);  
		   if(!matcher.matches()) throw new Exception("Invalid Emaii, please register again!");
		   this.emailId=email;
	}
	public void setPassword(String password) throws Exception {
		if(password.length()<3) throw new Exception("Password too short, please register again!");
		this.password=password;
	}
	public void setisLoggedin(Userdetails user_login) {
		this.loggedIn=user_login;
	}
	
	//getters
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public Userdetails get_LoggedinUser() {
		return loggedIn;
	}
	
}
