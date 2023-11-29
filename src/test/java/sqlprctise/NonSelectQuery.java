package sqlprctise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {

	public static void main(String[] args) throws Throwable {
		//register
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pooja", "root", "root");
		
		//create statement 
		Statement state = con.createStatement();
		String query="insert into stu_info values ('sam',3,'27');";
		
		//execute the updated statement
		int result = state.executeUpdate(query);
		
		if(result==1) {
		     System.out.println("data is inserted successfully");
		}
		else{
			System.err.println("data is not updated");
		}
		
		//close 
		con.close();
		

	}

}
