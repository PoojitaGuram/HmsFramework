package sqlprctise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;



public class Employee {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter emp name");
		String ename = sc.nextLine();
		Random ran =new Random();
		int age=ran.nextInt(10000);
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pooja", "root", "root");
		Statement state = con.createStatement();
		String query="Select Ename from emp_info where Ename='"+ename+"';";
		ResultSet res = state.executeQuery(query);
		boolean flag=false;
		while(res.next()){
		String Actualname = res.getString(1);
		if(ename.equals(Actualname)) {
			
			System.out.println("Data is already present");
		}
		flag=true;
		break;
		}
		
		if(!flag)
		 {
			String query1="insert into emp_info values('"+ename+"',"+ age +");";
			int updatedata = state.executeUpdate(query1);
			if(updatedata==1) {
				System.out.println("data is inserted");
			}
			else {
				System.out.println("data is not inserted");
		}
		}
		
		con.close();
		
		
	}

}
