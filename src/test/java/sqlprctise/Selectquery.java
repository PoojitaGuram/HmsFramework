package sqlprctise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Selectquery {

	public static void main(String[] args) throws Throwable {
		//register the driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection of database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pooja", "root", "root");
		
		//create statement
		Statement state = con.createStatement();
		String query = "Select * from stu_info;";
		
		//execute query
		ResultSet res = state.executeQuery(query);
		while(res.next()) {
			System.out.println(res.getString(1)+ " "+res.getString(2)+" "+ res.getString(3));
			
		}
		//close
		con.close();

	}

}
