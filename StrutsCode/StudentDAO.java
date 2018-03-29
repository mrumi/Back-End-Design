/*Author = Monjura Afrin Rumi*/
/* 
 * This class contains code to insert student information into database using insertData() method. 
 * It also retrieves studentID for all students who filled survey form namely all ID stored
 * in database using getStudentIds() method, then it returns those id as a string or
 * returns empty string if data could not be found
 * Given a studentID, it finds all information given by that student using getPersonalData() method. This
 * method store those information in StudentAction class to be retrived by Student.jsp class.
 * To insert or retreve data OracleConnect class has been used by these methods.  
 */

package hw_struts;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO 
{
	String fname="None";
	String mname="None";
	String lname="None";
	
	String address="None";
	String zip_code="None";
	String city="None";
	
	String state="None";
	String phone="None";
	String student_id="None";
	
	String email="None";
	String url="None";
	String date="None";
	
	String gmonth="None";
	String gyear="None";
	
	String like="None";	
	String interested="None";
	String recommend="None";
	
	public StudentDAO()
	{
		
	} 
		
	protected void storetName(String fn,String mn,String ln)
	{		
		this.fname=fn;
		this.mname=mn;
		this.lname=ln;
	}
	
	protected void StoreAddress(String adrs, String zp, String ct,String st)
	{
		this.zip_code=zp;
		this.address=adrs;
		this.city=ct;
		this.state=st;
	}
	
	protected void StoreContact(String pn,String em,String url)
	{
		this.phone=pn;
		this.email=em;
		this.url=url;
	}
	
	protected void storeStudent(String id,String gm,String gy)
	{
		this.student_id=id;
		this.gmonth=gm;
		this.gyear=gy;		
	}
	
	protected void storeOther(String dt,String lk,String itrs,String rc)
	{
		this.date=dt;
		this.like=lk;
		this.interested=itrs;
		this.recommend=rc;
	}
	
	protected int insertData()
	{
		OracleConnect oracle = new OracleConnect();
		oracle.createConnection();
		String insertquery="insert into students values ('"+this.student_id+"','"+this.fname+"','"+this.mname+"','"+this.lname+"','"+
				this.address+"','"+this.zip_code+"','"+this.city+"','"+this.state+"','"+this.phone+"','"+
				this.email+"','"+this.url+"','"+this.date+"','"+this.gmonth+"','"+this.gyear+"','"+
				this.interested+"','"+this.recommend+"')";						
		int r=oracle.updateDB(insertquery);	
		if(r==-1)
			return r;
		String[] likelist=this.like.split(",");
		
		for (int i=0;i<likelist.length;i++){
			String choicequery="insert into topicslike values('"+this.student_id+"','"+likelist[i]+"')";
			r=oracle.updateDB(choicequery);															
		}	
		oracle.close();
		return r;		
	}
	
	protected String getStudentIds()
	{
		OracleConnect oracle = new OracleConnect();
		oracle.createConnection();
		String searquery="select studentID from students";
		ResultSet results=oracle.searchDB(searquery);
		String AllId="";
		try{
			while(results.next())
			{
				String st_id = results.getString("studentID");
				AllId+=st_id+",";
			}			
			return AllId;
		}catch(Exception e){
			System.out.println("ORACLE error detected:");
	           e.printStackTrace();
		}						
		oracle.close();
		return "";
	}
	
	protected String getPersonalData(String id,StudentAction sa)
	{
		OracleConnect oracle = new OracleConnect();
		oracle.createConnection();
		String searquery="select * from students where studentID='"+id+"'";
		sa.setStudentid(id);
		ResultSet results=oracle.searchDB(searquery);
		String check="";
		try {
			if (!results.isBeforeFirst() ) {    
				 check="No data"; 				 
			}
		} catch (SQLException e1) {			
			e1.printStackTrace();
		} 
		try{
			while(results.next())
			{
				String firstname = results.getString("first_name");
				sa.setFname(firstname);
				String middlename = results.getString("mid_name");
				sa.setMname(middlename);
				String lastname = results.getString("last_name");
				sa.setLname(lastname);
				String addr = results.getString("address");
				sa.setAddress(addr);
				String zipcode = results.getString("zipCode");
				sa.setZipcode(zipcode);
				String cty = results.getString("city");
				sa.setCity(cty);
				String stat = results.getString("state");
				sa.setState(stat);
				String phn = results.getString("phone");
				sa.setPhone(phn);
				String eml = results.getString("email");
				sa.setEmail(eml);
				String net_url = results.getString("url");
				sa.setUrl(net_url);
				String dte = results.getString("dte");
				sa.setDate(dte);
				String month = results.getString("gradMonth");
				sa.setGmonth(month);
				String year = results.getString("gradYear");
				sa.setGyear(year);
				String interest = results.getString("interest");
				sa.setInterested(interest);
				String recom = results.getString("recommend");
				sa.setRecommend(recom);				
			}			
		}catch(Exception e){
			System.out.println("ORACLE error detected:");
			e.printStackTrace();
		}
		String choicesearch="select choice from topicslike where studentID='"+id+"'";		 
		ResultSet choice_result=oracle.searchDB(choicesearch);
		String liked="";		
		try{
			while(choice_result.next()){
				String ch=choice_result.getString("choice");				
				liked+=ch+", ";				
			}
			if(liked.length()==0){
				sa.setMostliked(liked);
			}
			else{
				sa.setMostliked(liked.substring(0, liked.length()-2));
			}
		}catch(Exception e ){
			System.out.println("ORACLE error detected:");
			e.printStackTrace();
		}
		oracle.close();
		return check;
	}	 
}
