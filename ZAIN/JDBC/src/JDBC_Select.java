import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","zainuddin");
						
						Statement smt=con.createStatement();
						ResultSet rs=smt.executeQuery("Select* from emp");
						
						while(rs.next())
						{
							int eid=rs.getInt(1);
							String ename=rs.getString(2);
							double esal=rs.getDouble(3);
							
							System.out.println("Emp ID "+eid);
							System.out.println("Emp Name "+ename);
							System.out.println("Emp salary "+esal);
				        }
					
						
						 
			}
			catch(Exception e) 
			{
						System.out.print(e);
			}
				
	}

			
	}


