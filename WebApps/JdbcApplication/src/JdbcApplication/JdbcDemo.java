package JdbcApplication;
/*
 * 1. import package (java.sql)
 * 2. load and register the driver (com.mysql.jdbc.Driver)
 * 3. create a connection with the database (Connection)
 * 4. create a statement (Statement)
 * 5. execute the query
 * 6. get the result & process the result
 * 7. close the connection with the database
 */
import java.sql.*;

public class JDBCdemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/college"; 
		/*
		 * database -> mysql
		 * port no -> 3306
		 * database name -> college
		 */
		String user_name = "root";
		String password = "shatarupa";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, user_name, password);
		
		Statement st = con.createStatement();
		String query = "SELECT student_name, student_city FROM student";
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			String details = rs.getString(1) + "......" + rs.getString(2);
			System.out.println(details);
		}
		/*String student_name = rs.getString("student_name");
		System.out.println(student_name);*/
		
		Statement st1 = con.createStatement();
		String query1 = "INSERT INTO student(student_name, student_city) VALUES('Shatarupa', 'Mumbai')";
		
		//ResultSet rs1 = st.executeQuery(query1);
		int x = st1.executeUpdate(query1);
		
		st.close();
		st1.close();
		con.close();
		
	}

}
