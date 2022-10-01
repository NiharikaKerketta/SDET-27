package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataFromTheDataBase {

	public static void main(String[] args) throws SQLException {
		 
		String expectedid= "1";
		//register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//establish the connection with the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//issue the statement
		 Statement statement = connection.createStatement();
		 
		//execute queries
		 ResultSet result = statement.executeQuery("select * from studentinfo");
		 while(result.next()) {
			 if(result.getString(1).equals(expectedid)) {
				 System.out.println("passed");
			 }
		 }
		 //close the connection
		 connection.close();
	}

}
