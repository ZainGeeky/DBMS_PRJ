import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","zainuddin");
			PreparedStatement psmt=con.prepareStatement("insert into emp values(?,?,?)");
			
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.print("Enter Emp ID");
				int eno=Integer.parseInt(br.readLine());
				
				System.out.print("Enter Emp Name");
				String ename=br.readLine();
				
				System.out.print("Enter Emp Salary");
				double esal=Double.parseDouble(br.readLine());
				
				psmt.setInt(1,eno);
				psmt.setString(2,ename);
				psmt.setDouble(3,esal);
				
				int count=psmt.executeUpdate();
				if(count>0)
					System.out.println(count+"rec inserted");
				else
					System.out.println("no rec inserted");
				
				System.out.println("do u want to insert more records");
				
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
