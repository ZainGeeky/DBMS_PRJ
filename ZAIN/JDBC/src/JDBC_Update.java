import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Update {
	
	public static void main(String[] args) {
		String value;
		int eid;
		double esal;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","zainuddin");
		Statement smt=con.createStatement();
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
			System.out.print("Enter Emp ID");
			value=br.readLine();
			eid=Integer.parseInt(value);
			
			System.out.print("Enter Emp Salary");
			value=br.readLine();
			esal=Double.parseDouble (value);
			
			
			
			int count=smt.executeUpdate("Update emp set esal="+esal+"where eno="+eid);
			if(count>0)
				System.out.println(count+"rec inserted");
			else
				System.out.println("no rec found");
			
		
		 
	}
	catch(Exception e) 
	{
		System.out.print(e);
	}
}
}

