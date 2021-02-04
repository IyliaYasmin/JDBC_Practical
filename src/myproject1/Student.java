package myproject1;

	import java.sql.*; 

	public class Student {

		public static void main(String[] args) throws SQLException, ClassNotFoundException { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
			
			Connection c=DriverManager.getConnection(url,"root","Database2019");
			
			// Create a statement to retrieve objects
			Statement s = c.createStatement();       

			// Retrieve results from the table
			ResultSet rs = s.executeQuery ("Select * from Student"); 
			
			// Print columns headers
			ResultSetMetaData rsmd =rs.getMetaData(); 
			int i =rsmd.getColumnCount( );
			
			//Loop to retrieve and print column header
			for(int j=1; j<=i; j++) { 
				System.out.printf("%-16s", rsmd.getColumnName(j)); 
				System.out.print(" "); 
			} 
			
			System.out.println("\t");
			System.out.println("--------------------------------------------------------------------"
					+ "------------------------------------------------------------------------------");
			
			//Loop to retrieve and print records
			while(rs.next( ) ) { 
				System.out.print("\n");
				for(int j=1; j<=i; j++) 
				{ 
					System.out.printf("%-17s", rs.getString(j));
				}
			}
			
		}
	}
