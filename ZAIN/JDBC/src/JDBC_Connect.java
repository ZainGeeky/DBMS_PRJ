import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Connect {
	public static void main(String[] args)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","zainuddin");
			
			Statement smt=con.createStatement();
			smt.executeUpdate("create table student(eno number,ename varchar(12),esal number)");
			
			System.out.print("Table Created Successfully....");
			con.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}
