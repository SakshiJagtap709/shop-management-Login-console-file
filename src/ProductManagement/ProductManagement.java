package ProductManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManagement 
{
	static ArrayList<Product> al= new ArrayList();
    
	public static void ProductManagement() throws IOException
	{
		loadDataFromFileToArrayList();
		
		Scanner scanner=new Scanner(System.in);
		
		boolean canIKeepRunningTheProgram=true;
		
		while(canIKeepRunningTheProgram==true)
		{
			System.out.println("**** WELCOME TO PRODUCT MANAGEMENT ***");
			System.out.println("\n");
			System.out.println("1.Add Product");
			System.out.println("2.Search Product");
			System.out.println("3.Delete Product");
			System.out.println("4.Edit Product");
			System.out.println("5.Quit");
			
			int optionSelectedByUser=scanner.nextInt();
			
			if(optionSelectedByUser==ProductOptions.Quit)
			{
				File file=new File("C:\\Users\\HP\\eclipse-workspace\\ShopManagementLogin\\src\\ProductManagement\\PRODUCT.csv");
				FileWriter fileWriter=new FileWriter(file,false);
				BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
				
				for(Product Product:al)
				{
					bufferedWriter.write(Product.productname+" , "+Product.productID+" , "+Product.productCategory+","+Product.productPrice+",");
					
				}
				bufferedWriter.close();
				fileWriter.close();
				file=null;
				
				System.out.println("Program is closed..");
				canIKeepRunningTheProgram=false;
			}
			else if(optionSelectedByUser==ProductOptions.Add_Product)
			{
				addProduct();
				System.out.println("\n");
			}
			else if(optionSelectedByUser==ProductOptions.Delete_Product)
			{
				System.out.println("Enter The product name you want to delete:");
			    scanner.nextLine();
			    String sn=scanner.nextLine();
			    deleteProduct(sn);
			    System.out.println("\n");
			 }
			else if(optionSelectedByUser==ProductOptions.Search_Product)
			{
				System.out.println("Enter the product name you want to search:");
				scanner.nextLine();
				String sn=scanner.nextLine();
				searchProduct(sn);
			}
			else if(optionSelectedByUser==ProductOptions.Edit_Product)
			{
				System.out.println("Enter the product name you want to edit:");
				scanner.nextLine();
				String sn=scanner.nextLine();
				editProduct(sn);
		    }
			
		}
		System.out.println("\n");
		System.out.println("After While Loop");
		
		for(Product product:al)
		{
			System.out.println(product.productID);
			System.out.println(product.productname);
			System.out.println(product.productCategory);
			System.out.println(product.productPrice);
		}
	}
	
	public static void addProduct()
	{
		Scanner scanner=new Scanner(System.in);
		Product ProductObject=new Product();
		
		System.out.println("Product Name:");
		ProductObject.productname=scanner.nextLine();
		
		System.out.println("Product Category :");
		ProductObject.productCategory=scanner.nextLine();
		
		System.out.println("Product Id:");
		ProductObject.productID=scanner.nextLine();
		
		System.out.println(" Product Price:");
		ProductObject.productPrice=scanner.nextLine();
	
		
		System.out.println("Product Name:"+ProductObject.productname);
		System.out.println("Product id:"+ProductObject.productID);
		System.out.println("Product Price :"+ProductObject.productPrice);
		System.out.println("Product Category :"+ProductObject.productCategory);
		
		al.add(ProductObject);
		
	}
	public static void searchProduct(String ProductName)
	{
		for(Product u : al)
		 {
			if(u.productname.equalsIgnoreCase(ProductName))
			{
				System.out.println("Product Name:"+u.productname);
				System.out.println("Product id:"+u.productID);
				System.out.println("Product Price :"+u.productPrice);
				System.out.println("Product Category :"+u.productCategory);
				
				return;
			}
		}
		
		System.out.println("Product Not Found");
	}
	public static void editProduct(String ProductName)
	{
		for( Product u : al)
		{
			if(u.productname.equalsIgnoreCase(ProductName))
			{
		        Scanner scanner=new Scanner(System.in);
				System.out.println("Editing Product :"+u.productname);

				System.out.println("New Product Name:");
				u.productname=scanner.nextLine();
				
				System.out.println("New ProductId:");
				u.productID=scanner.nextLine();
				
				System.out.println("New Productprice:");
				u.productPrice=scanner.nextLine();
				
				System.out.println("New ProductCategory");
				u.productCategory=scanner.nextLine();
				
				System.out.println("Product Information Updated");
				
				return;

			}
		}
		
		System.out.println("Product not found");
	}
	public static void deleteProduct(String ProductName)
	{
         Iterator<Product>Iterator=al.iterator();
		
		while(Iterator.hasNext())
		{
			Product Product=Iterator.next();
			if(Product.productname.equalsIgnoreCase(ProductName))
			{
				Iterator.remove();
				System.out.println("Product" + Product.productname+"has been deleted.");
				break;
			}
		}
		
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file=new File("C:\\Users\\HP\\eclipse-workspace\\ShopManagementLogin\\src\\ProductManagement\\PRODUCT.csv");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String Line="";
		while((Line= br.readLine())!=null)
		{
			Product product=new Product();
			String[] productDataArray=Line.split(",");
			
			if(productDataArray.length>3)
			{
				product.productname=productDataArray[0];
				product.productID=productDataArray[1];
				product.productPrice=productDataArray[2];
				product.productCategory=productDataArray[3];
				
                al.add(product);
             }
		}
		 br.close();
		 fr.close();
		 file=null;

		}
}