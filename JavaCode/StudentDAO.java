/*Author = Monjura Afrin Rumi*/
/*
 * This class contains code to insert student information into database using insertData() method. 
 * It also retrieves studentID for all students who filled survey form namely all ID stored
 * in database using getStudentIds() method. This method stores those ID in a student bean object provided
 * by servlet.
 * Given a studentID, it finds all information given by that student using getPersonalData() method. This
 * method store those information in a student bean object provided by servlet.
 * To insert or retreve data OracleConnect class has been used by these methods.  
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import hw4.StudentBean;


public class StudentDAO {	    
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
	
	String[] like;	
	String interested="None";
	String recommend="None";

	public StudentDAO()
	{
		
	} 
		
	protected void storetName(String fn,String mn,String ln){		
		this.fname=fn;
		this.mname=mn;
		this.lname=ln;
	}
	
	protected void StoreAddress(String adrs, String zp, String ct,String st){
		this.zip_code=zp;
		this.address=adrs;
		this.city=ct;
		this.state=st;
	}
	
	protected void StoreContact(String pn,String em,String url){
		this.phone=pn;
		this.email=em;
		this.url=url;
	}
	
	protected void storeStudent(String id,String gm,String gy){
		this.student_id=id;
		this.gmonth=gm;
		this.gyear=gy;		
	}
	
	protected void storeOther(String dt,String[] lk,String itrs,String rc){
		this.date=dt;
		this.like=lk;
		this.interested=itrs;
		this.recommend=rc;
	}
	
	protected int insertData(){
		OracleConnect oracle = new OracleConnect();
		oracle.createConnection();
		String insertquery="insert into students values ('"+this.student_id+"','"+this.fname+"','"+this.mname+"','"+this.lname+"','"+
				this.address+"','"+this.zip_code+"','"+this.city+"','"+this.state+"','"+this.phone+"','"+
				this.email+"','"+this.url+"','"+this.date+"','"+this.gmonth+"','"+this.gyear+"','"+
				this.interested+"','"+this.recommend+"')";						
		int r=oracle.updateDB(insertquery);				
		for (int i=0;i<this.like.length;i++){
			String choicequery="insert into topicslike values('"+this.student_id+"','"+this.like[i]+"')";
			r=oracle.updateDB(choicequery);															
		}	
		oracle.close();
		return r;
	}
	
	protected String getStudentIds(){
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
	
	protected String getPersonalData(String id,StudentBean sb){
		OracleConnect oracle = new OracleConnect();
		oracle.createConnection();
		String searquery="select * from students where studentID='"+id+"'";
		sb.setStudent_id(id);
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
				sb.setFname(firstname);
				String middlename = results.getString("mid_name");
				sb.setMname(middlename);
				String lastname = results.getString("last_name");
				sb.setLname(lastname);
				String addr = results.getString("address");
				sb.setAddress(addr);
				String zipcode = results.getString("zipCode");
				sb.setZip_code(zipcode);
				String cty = results.getString("city");
				sb.setCity(cty);
				String stat = results.getString("state");
				sb.setState(stat);
				String phn = results.getString("phone");
				sb.setPhone(phn);
				String eml = results.getString("email");
				sb.setEmail(eml);
				String net_url = results.getString("url");
				sb.setUrl(net_url);
				String dte = results.getString("dte");
				sb.setDate(dte);
				String month = results.getString("gradMonth");
				sb.setGmonth(month);
				String year = results.getString("gradYear");
				sb.setGyear(year);
				String interest = results.getString("interest");
				sb.setInterested(interest);
				String recom = results.getString("recommend");
				sb.setRecommend(recom);				
			}
			
		}catch(Exception e){
			System.out.println("ORACLE error detected:");
			e.printStackTrace();
		}
		String choicesearch="select choice from topicslike where studentID='"+id+"'";		 
		ResultSet choice_result=oracle.searchDB(choicesearch);
		String[] liked=new String[6];
		int index=0;
		try{
			while(choice_result.next()){
				String ch=choice_result.getString("choice");				
				liked[index]=ch;
				index+=1;
			}
			sb.setLike(liked);
		}catch(Exception e ){
			System.out.println("ORACLE error detected:");
			e.printStackTrace();
		}
		oracle.close();
		return check;
	}	 
	
}

