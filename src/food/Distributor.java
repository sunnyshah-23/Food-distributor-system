package food;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;



public class Distributor {

	private ArrayList<Product>readProduct= new ArrayList<>();
	private String name;
	private int qty;
	private float price;
	private String category;
	private String brand;
	private String filens="productList.txt";
	Scanner dist=new Scanner(System.in);
	//constructor
	public Distributor(){
		try {
			readData(filens);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Add Product
	public void addData(int n) {
	
		try {
	
			for(int i=0;i<n;i++) {
				System.out.print("Name\tqty\tprice\tcategory\tbrand\n");
				name=dist.nextLine();
				qty=dist.nextInt();
				price=dist.nextFloat();
				dist.nextLine();
				category=dist.nextLine();
				brand=dist.nextLine();
			
				Product newProduct=new Product(name,qty,price,category,brand);
				readProduct.add(newProduct);
			}
			
			//write into file
			writeData();
			
	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//create string from ArrayList readProduct and call savtoFile()
	public void writeData() throws IOException {
		//FLUSH DATA from file
		new FileWriter(filens, false).close();
		
		for(int i=0;i<readProduct.size();i++) {
	
			StringBuilder outputText=new StringBuilder(readProduct.get(i).getName() + "|" + readProduct.get(i).getQty() + "|" + readProduct.get(i).getPrice() + "|" +readProduct.get(i).getCategory() + "|" + readProduct.get(i).getBrand());
			saveToFile("productList.txt",outputText.toString(),true);
		}
	}
	
	//DELETE product 
	public void deleteProduct(int index) {
		try {
			readProduct.remove(index-1);
			writeData();		
		}
		catch(ArrayIndexOutOfBoundsException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//read and load data from file
	public void readData(String fileName) throws FileNotFoundException {
		File file=new File(fileName);
		Scanner load=new Scanner(file);
		if(file.length()!=0) {
			while(load.hasNextLine()) {
				String line=load.nextLine();
				String[] items=line.split("\\|");
				name=items[0];
				qty=Integer.parseInt(items[1]);	
				price=Float.valueOf(items[2]);
				category=items[3];
				brand=items[4];
				Product newProduct=new Product(name,qty,price,category,brand);
				readProduct.add(newProduct);
				
			}
		}
		load.close();
	
	
	}
	
	//display product
	public void displayProduct() {
		for(int i=0;i<readProduct.size();i++) {
			StringBuilder outputText=new StringBuilder("|"+readProduct.get(i).getName() + "|" + readProduct.get(i).getQty() + "|" + readProduct.get(i).getPrice() + "|" +readProduct.get(i).getCategory() + "|" + readProduct.get(i).getBrand());
			System.out.print(outputText.toString());
			System.out.print("\n");
		}
	}
	
	//Write data to file
	public void saveToFile(String fileName,String text,boolean append) throws IOException{
		File file1=new File(fileName);
		FileWriter fw=new FileWriter(file1,append);
		PrintWriter pw=new PrintWriter(fw);
		pw.println(text);
		pw.close();
	
	
		
	}
	

	
	
	
}
