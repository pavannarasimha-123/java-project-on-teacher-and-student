import java.sql.*;
import java.util.*;
 public class Tproject2
{
public class Minsertion {
    public static void mIns()
{

	Scanner sc = new Scanner(System.in);

        								// 1. Read input from user
        System.out.print("Enter employee id");
        int id = sc.nextInt();
	System.out.print("Enter password");
        String password = sc.next();
	


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

	String query = "INSERT INTO  teachers (id,password) values (?,?)";
        ps = con.prepareStatement(query); 
            	ps.setInt(1,id );
		ps.setString(2, password);
            	

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

public class Mdeletion
{
    public static void mDel() 
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
                      									          	
        String query = "Delete from teachers where id=?"; 		// 3. prepare statement
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

public class Mupdation
{
    public static void mUpd() 
    {
	
	Scanner sc = new Scanner(System.in);

        								// 1. Read input from user
        System.out.print("Enter id to update: ");
        int id = sc.nextInt();

        System.out.print("Enter new password: ");
        String password = sc.next();

        String url  = "jdbc:oracle:thin:@localhost:1521:XE"; 		// change XE, host, port if needed
        String user = "system";      					// change to your username
        String pass = "412007";    					// change to your password

        Connection con = null;
        PreparedStatement ps=null;

        try {
            								
            	Class.forName("oracle.jdbc.driver.OracleDriver");		// 1. Load Oracle driver
            
		con = DriverManager.getConnection(url, user, pass);		// 2. Get connection
            
										// 3. prepare statement
            String query = "Update teachers set password=?  where id=?";
            ps = con.prepareStatement(query);
		ps.setString(1,password);
		ps.setInt(2,id);
	
	int rows = ps.executeUpdate();  				       // 4.returns rows affected 
        System.out.println(rows+" row(s) updated.");
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close resources
                        try { if (ps != null) ps.close(); }   catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}

public static void main(String... args)
{
    Scanner sc=new Scanner(System.in);
	System.out.println("1.insertion\n2.deletion\n3.updation");

    int n=sc.nextInt();
   switch(n)
   {
      case 1:Minsertion.mIns();break;
      case 2:Mdeletion.mDel();break;
      case 3:Mupdation.mUpd();break;
     

    }

}
}