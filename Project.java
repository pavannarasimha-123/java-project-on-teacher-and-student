import java.io.*;
import java.util.*;
import java.sql.*;
public class Project
{
public class Selection2 
{
    public static void sel2()
{
        String url  = "jdbc:oracle:thin:@localhost:1521:XE"; // change XE, host, port if needed
        String user = "SYSTEM";                             // change to your username
        String pass = "412007";                                // change to your password

        Connection con = null;
        PreparedStatement  ps  = null;
        ResultSet  rs  = null;

        try {
            					// 1. Load Oracle driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            						// 2. Get connection
            con = DriverManager.getConnection(url, user, pass);

            						//3. prepare statement
            String query = "SELECT * FROM Employee1 ";
            ps = con.prepareStatement(query);
	
	    rs = ps.executeQuery();           //  4. result set , returns 0 or more rows

            							// 5. Display records
            System.out.println("id \tname\t\tsalary\tcity");
            System.out.println("------------------------------------------");
            while (rs.next())
           {
                int    ids = rs.getInt("eid");
                String names  = rs.getString("ename");
                int salarys=rs.getInt("esal");
                String  city = rs.getString("ecity");
             
             

                System.out.println(ids+ "\t" + names +"\t\t" +salarys+"\t\t"+city);
            }
        } catch (Exception e) {  e.printStackTrace();     } 
        finally {
            // 6. Close resources
	    try { if (rs != null) rs.close(); }   catch (Exception e) {}
            try { if (ps != null) ps.close(); }   catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
public class Insertion2 {
    public static void ins2()
{

	Scanner sc = new Scanner(System.in);

        								// 1. Read input from user
        System.out.print("Enter employee id");
        int id = sc.nextInt();
	System.out.print("Enter employee name ");
        String name = sc.next();
	System.out.print("Enter salary ");
        int sal = sc.nextInt();
	System.out.print("Enter city  ");
        String city = sc.next();


        String url  = "jdbc:oracle:thin:@localhost:1521:XE"; // change XE, host, port if needed
        String user = "system";                             // change to your username
        String pass = "412007";                                // change to your password

        Connection con = null;
        PreparedStatement ps = null;

        try {
            							// 1. Load Oracle driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            							// 2. Get connection
            con = DriverManager.getConnection(url, user, pass);

            							// 3. prepare statement

	String query = "INSERT INTO  Employee1 (eid,ename,esal,ecity) values (?,?,?,?)";
        ps = con.prepareStatement(query); 
            	ps.setInt(1,id );
		ps.setString(2, name);
            	ps.setInt(3, sal);
		ps.setString(4, city);

	int rows = ps.executeUpdate();  				// returns rows affected 
        System.out.println(rows+" row(s) inserted.");
            							
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close resources
            try { if (ps != null) ps.close(); }   catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
public class Updation2 
{
    public static void upd2() 
    {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("enter what want to edit \n1.salary\n2.city\n3.name");
        int n=sc.nextInt();								// 1. Read input from user
        System.out.print("Enter id to update: ");
        int id = sc.nextInt();
        String url  = "jdbc:oracle:thin:@localhost:1521:XE"; 		// change XE, host, port if needed
        String user = "system";      					// change to your username
        String pass = "412007";    					// change to your password

        Connection con = null;
        PreparedStatement ps=null;
	switch(n)
	{
		case 1:try {
            	System.out.print("Enter new salary: ");
        	int sal = sc.nextInt();					
            	Class.forName("oracle.jdbc.driver.OracleDriver");								
		con = DriverManager.getConnection(url, user, pass);																	String query = "Update employee1 set esal=?  where eid=?";
            	ps = con.prepareStatement(query);
		ps.setInt(1,sal);
		ps.setInt(2,id);
		int rows = ps.executeUpdate();  				  
        	System.out.println(rows+" row(s) updated.");
           
       		 } catch (Exception e) {
            	e.printStackTrace();
        	} finally {
            // 6. Close resources
                        try { if (ps != null) ps.close(); }   catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
      };break;

		case 2:try {
            	System.out.print("Enter new city ");
        	String  city= sc.next();						
            	Class.forName("oracle.jdbc.driver.OracleDriver");																	con = DriverManager.getConnection(url, user, pass);							        									String query = "Update employee1 set ecity=?  where eid=?";
            	ps = con.prepareStatement(query);
		ps.setString(1,city);
		ps.setInt(2,id);
		int rows = ps.executeUpdate();  				  
        	System.out.println(rows+" row(s) updated.");
           
       		 } catch (Exception e) {
            	e.printStackTrace();
        	} finally {
            // 6. Close resources
                        try { if (ps != null) ps.close(); }   catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        };break;
		case 3:sc.nextLine();
		try {
            	System.out.print("Enter new name: ");
        	String name = sc.nextLine();						
            	Class.forName("oracle.jdbc.driver.OracleDriver");																	con = DriverManager.getConnection(url, user, pass);							        									String query = "Update employee1 set ename=?  where eid=?";
            	ps = con.prepareStatement(query);
		ps.setString(1,name);
		ps.setInt(2,id);
		int rows = ps.executeUpdate();  				  
        	System.out.println(rows+" row(s) updated.");
           
       		 } catch (Exception e) {
            	e.printStackTrace();
        	} finally {
            // 6. Close resources
                        try { if (ps != null) ps.close(); }   catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}};break;


	

        }
    }
}
public class Deletion2
{
    public static void del2() 
    {
	
	Scanner sc = new Scanner(System.in);

        								// 1. Read input from user
        System.out.print("Enter id to delete: ");
        int id = sc.nextInt();

        
        String url  = "jdbc:oracle:thin:@localhost:1521:XE"; 		// change XE, host, port if needed
        String user = "system";      					// change to your username
        String pass = "412007";    					// change to your password

        Connection con = null;
        PreparedStatement ps = null;
	
        try {
            								
            	Class.forName("oracle.jdbc.driver.OracleDriver");   // 1. Load Oracle driver
            
		con = DriverManager.getConnection(url, user, pass);  // 2. Get connection
                      									          	
        String query = "Delete from employee1 where eid=?"; 		// 3. prepare statement
        ps = con.prepareStatement(query); 
            	ps.setInt(1, id);
								// 4. Execute prepared statetement
	int rows = ps.executeUpdate();  				// 5. returns rows affected 
        System.out.println(rows+" row(s) deleted.");
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close resources
            try { if (ps != null) ps.close(); }   catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
public static class Edit2
  {
	public static void start()
{
		System.out.println("enter\n1.selection\n2.insertion\n3.updation\n4.deletion\n");
      Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
        
      switch (n)
      {
          case 1:Selection2.sel2(); break;
          case 2:Insertion2.ins2();break;
          case 3:Updation2.upd2();break;
          case 4:Deletion2.del2();break;
          default:System.out.println("Invalid");
      }
               
   }
}
    public static void main(String[] args) 
{
        String url  = "jdbc:oracle:thin:@localhost:1521:XE"; // change XE, host, port if needed
        String user = "SYSTEM";                             // change to your username
        String pass = "412007";                                // change to your password
	Scanner sc= new Scanner(System.in);
        Connection con = null;
        PreparedStatement  ps  = null;
        ResultSet  rs  = null;

        try {
            					// 1. Load Oracle driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            						// 2. Get connection
            con = DriverManager.getConnection(url, user, pass);
	System.out.println("enter username of the employee");
	int un=sc.nextInt();
            						//3. prepare statement
            String query = "SELECT gcode from guruvu where gid=?";
            ps = con.prepareStatement(query);
	ps.setInt(1,un);
	   rs = ps.executeQuery();           //  4. result set , returns 0 or more rows
		//String password = rs.getString("password");
		
             

               // System.out.println( "\t" + password );

            							// 5. Display records
            while (rs.next())
           {
                //int    ids = rs.getInt("GID");
		
                String passwords = rs.getString("GCODE");
			System.out.println("enter password of the employee");
		String ep=sc.next();
             	if(ep.equals(passwords))
		{
                //System.out.println( "\t" + passwords );
			Edit2.start(); 
           	 }
		else
		{
				System.out.println("login failed");
		}
	}
        } catch (Exception e) {  e.printStackTrace();     } 
        finally {
            // 6. Close resources
	    try { if (rs != null) rs.close(); }   catch (Exception e) {}
            try { if (ps != null) ps.close(); }   catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}


