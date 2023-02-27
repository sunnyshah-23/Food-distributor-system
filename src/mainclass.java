import food.Distributor;
import user.Auth;
import java.util.*;
public class mainclass {
	private static Boolean loginStatus=false;
	static Scanner sc=new Scanner(System.in);
	public static int adminUI(String admin_name) {
		Distributor admin=new Distributor();
	
		StringBuilder intro=new StringBuilder("-----------Welcome Back" + " " + admin_name.toUpperCase() +"-------------------------\n");
		System.out.print(intro);
		System.out.print("\n1=Add Products\n2=Delete Product\n3=Display Products\n-1:Logout\n");
		int ch=sc.nextInt();
		while(ch!=-1) {
	
			switch(ch) {
			case 1:
				System.out.print("how many products you want to add:");
				int n=sc.nextInt();
				if(loginStatus==true) admin.addData(n);
				break;
			
			case 2:
				System.out.print("Which product you want to delete:");
				int del=sc.nextInt();
				if(loginStatus==true) admin.deleteProduct(del);
				break;
				
			case 3:
				if(loginStatus==true) admin.displayProduct();
				break;
			
			default:
				System.out.print("Please enter correct choice");
			}
	
			System.out.print("1=Add\n2=Delete\n3=Display\n-1:Logout\n");
			sc.nextLine();
			ch=sc.nextInt();
		}
	
		
		return ch;
	
	}
	
	public static int consumerUI(String consumer_name){
		
		StringBuilder intro=new StringBuilder("Hello " +consumer_name.toUpperCase() + "!" + " "+ "Welcome to Food Distributor Management System\n");
		System.out.print(intro);
		System.out.print("You can perform consumer functions now!\n");
		System.out.print("Press -1 to Logout");
		int ch=sc.nextInt();
	
		return ch;
		
	}
	
	public static void setLogin(Boolean val) {
		loginStatus=val;
	}
	
	
	public static void main(String[]args) {
		

		System.out.print("\n1=Register\n2=Login\n0=exit");
		int ch=sc.nextInt();
		Auth authentication=new Auth();
		while(ch!=0) {
			switch(ch) {
				case 1:
					System.out.print("Enter Name:\n");
					String name=sc.next();
					System.out.print("Enter address:\n");
					sc.nextLine();
					String address=sc.nextLine();
					System.out.print("Enter contact:\n");
					String contact=sc.next();
					System.out.print("Enter username:\n");
					String username=sc.next();
					System.out.print("Enter email:");
					String email=sc.next();
					System.out.print("Enter password:\n");
					String password=sc.next();
				
					
				try {
					authentication.register(name,address,contact,username,email,password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
					break;
				case 2:
					System.out.print("Enter username:\n");
					String user_name=sc.next();
					System.out.print("Enter password:\n");
					sc.nextLine();
					String user_password=sc.next();
				try {
					if(authentication.login(user_name, user_password)) {
						setLogin(true);
						if(authentication.get_LoggedinUser().getIsAdmin()) {
							ch=adminUI(authentication.get_LoggedinUser().getName());
						}
						else {
							ch=consumerUI(authentication.get_LoggedinUser().getName());
						}
					};
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
				
			}
			if(ch==-1) authentication.logout();
			System.out.print("\n1=Register\n2=Login\n0=exit\n");
			ch=sc.nextInt();
					
					
		}
		System.out.print("------------------Program ends here------------------");
		sc.close();
		System.exit(0);
		
	}
	

}
