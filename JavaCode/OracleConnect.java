/*Author = Monjura Afrin Rumi*/
/*
 * This class contains oracle connection code, database insert and search code.
 */

import java.sql.*;


public class OracleConnect
{
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	private String username;
	private String password;

	public OracleConnect()
    {
		this.username="mrumi";
		this.password="shosaz";		        
    }
	
	protected void createConnection()
	{
		try {
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);            
            String url = "jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g";            
            this.connection = DriverManager.getConnection(url,this.username,this.password);            
            //System.out.println("Connected!");            
        }
        catch (Exception e) {
            System.out.println("ORACLE error detected:");
            e.printStackTrace();
        }
	}

	protected int updateDB(String query)
    {
		int result = 0;
        try
        {
        	this.stmt=this.connection.createStatement();
            result=this.stmt.executeUpdate(query);
        }
        catch (Exception e)
        {
        	result=-1;
            System.out.println("In OracleConnect:updateDB - " + e);
        }
        return result;
    }

	protected ResultSet searchDB(String query)
    {
		try
        {
			stmt=this.connection.createStatement();
            this.rs=this.stmt.executeQuery(query);
        }
        catch (Exception e)
        {
        	System.out.println("In OracleConnect:searchDB - " + e);
        }
		return this.rs;
    }
	
	protected void close()
	{
		try
		{
			this.connection.close();
			//System.out.println("Disconnected");
		}
		catch(Exception e)
		{
			System.out.println("In OracleConnect:close - " + e);
		}
	}
	
}
