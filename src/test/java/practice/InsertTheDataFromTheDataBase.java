package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertTheDataFromTheDataBase {

	public static void main(String[] args) throws SQLException {
		
		//register the DataBase
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		//establish the connection with database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		
		//issue the statement
		Statement statement = connection.createStatement();
		
		//execute Query
		int result = statement.executeUpdate("insert into studentinfo(id, fname, lname, address) values ('5', 'mark', 'joy', 'italy')");
		 
		//verification
		if(result==1) {
			System.out.println("==>One set of data is added to the database<==");
		}
		else {
			System.out.println("==>Data is not added to the database<==");
		}
			//close the connection
			connection.close();
	}

}
