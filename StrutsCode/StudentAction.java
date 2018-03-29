/*Author = Monjura Afrin Rumi*/
/*
 * receive id value from acknowledgement.jsp file. Call StudentDAO class to retrieve info of that
 * student from Database. Based on retrieval query returns string value to be rendered either Student.jsp or  
 * NoSuchStudent.jsp file.  
 */

package hw_struts;

public class StudentAction
{
	private String fname;
	private String mname;
	private String lname;
	
	private String address;
	private String zipcode;
	private String city;
	
	private String state;
	private String phone;
	private String studentid;
	
	private String email;
	private String url;
	private String date;
	
	private String gmonth;
	private String gyear;
	
	private String mostliked;	
	private String interested;
	private String recommend;

	
	public String execute()
	{		
		StudentDAO stdao=new StudentDAO();		
		String check=stdao.getPersonalData(this.studentid,this);
		
		if (check=="No data")
			return "error";
		else		
			return "success";
	}
		
	public void setFname (String fname)
	{
		this.fname = fname;	   
	}
	
	public String getFname ()
	{
		return this.fname;
	}
	
	public void setMname (String middlename)
	{		
		this.mname = middlename;
	}

	public String getMname ()
	{
		return this.mname;
	}

	public void setLname (String lastname)
	{
		this.lname = lastname;			
	}

	public String getLname ()
	{
		return this.lname;
	}

	public void setAddress (String address)
	{
		this.address = address;			
	}

	public String getAddress ()
	{
		return this.address;
	}

	public void setZipcode (String zipcode)
	{
		this.zipcode = zipcode;	
	}

	public String getZipcode ()
	{
		return this.zipcode;
	}

	public void setCity (String city)
	{
		this.city = city;			
	}

	public String getCity ()
	{
		return this.city;
	}

	public void setState (String state)
	{
		this.state = state;	 		
	}

	public String getState ()
	{
		return this.state;
	}
	
	public void setPhone (String phone)
	{
		this.phone = phone;	  		
	}

	public String getPhone ()
	{
		return this.phone;
	}

	public void setStudentid (String studentid)
	{		
		this.studentid = studentid;		
	}
	
	public String getStudentid ()
	{		
		return this.studentid;		
	}
	
	public void setEmail (String email)
	{
		this.email = email;	 		
	}

	public String getEmail ()
	{
		return this.email;
	}
	
	public void setUrl (String net_url)
	{
		this.url = net_url;	 		
	}

	public String getUrl ()
	{
		return this.url;
	}
	
	public void setDate (String date)
	{
		this.date = date;
	}

	public String getDate ()
	{
		return this.date;
	}
	
	public void setGmonth (String month)	
	{				
		this.gmonth = month;		
	}

	public String getGmonth ()
	{
		return this.gmonth;
	}

	public void setGyear(String year)
	{
		this.gyear = year;		
	}

	public String getGyear ()
	{
		return this.gyear;
	}
		
	public void setMostliked (String liked)
	{		
		this.mostliked=liked;				
	}

	public String getMostliked()
	{
		return this.mostliked;
	}

	public void setInterested (String interest)
	{
		this.interested = interest;	   
	}

	public String getInterested ()
	{
		return this.interested;
	}
	
	public void setRecommend (String recom)
	{		
		this.recommend = recom;			
	}

	public String getRecommend ()
	{
		return this.recommend;
	}		
}
