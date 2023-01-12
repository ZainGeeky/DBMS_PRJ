import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","zainuddin");
			Statement smt=con.createStatement();
			
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.print("Enter deletion Emp ID");
				int eno=Integer.parseInt(br.readLine());
				
				int count=smt.executeUpdate("delete from emp where eno="+eno);
				if(count>0)
					System.out.println(count+"rec deleted");
				else
					System.out.println("no rec deleted");
				
				System.out.println("do u want to delete more records");
				
				String ch=br.readLine();
				if(ch.equalsIgnoreCase("no"))
					break;
				
			}
			
			 
		}
		catch(Exception e) 
		{
			System.out.print(e);
		}
	}

}
