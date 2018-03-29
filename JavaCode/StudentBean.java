/*Author = Monjura Afrin Rumi*/
/*
 * This class stores stores personal information of student and answer of survey questions.
 * It also contains all student ID who filled up this survey.
 */

package hw4;


public class StudentBean {
	private String fname;
	private String mname;
	private String lname;
	
	private String address;
	private String zip_code;
	private String city;
	
	private String state;
	private String phone;
	private String student_id;
	
	private String email;
	private String url;
	private String date;
	
	private String gmonth;
	private String gyear;
	
	private String[] like;	
	private String interested;
	private String recommend;
	
	private String allid;

	public StudentBean()
	{
	}

	// Property "name"
	public void setFname (String firstname)
	{
	   this.fname = firstname;	   
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

	public void setZip_code (String zipcode)
	{
	   this.zip_code = zipcode;	   
	}

	public String getZip_code ()
	{
	   return this.zip_code;
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

	public void setStudent_id (String student_id)
	{
	   this.student_id = student_id;	   
	}

	public String getStudent_id ()
	{
	   return this.student_id;
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

	public void setGyear (String year)
	{
	   this.gyear = year;	   
	}

	public String getGyear ()
	{
	   return this.gyear;
	}
		
	public void setLike (String[] liked)
	{
		this.like=new String[liked.length];
		for(int i=0;i<liked.length;i++)
		{
			this.like[i]=liked[i];			
		}
	}

	public String[] getLike()
	{
	   return this.like;
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
	
	public void setAllid(String allid)
	{
		this.allid=allid;
	}
	
	public String getAllid()
	{
		return this.allid;
	}
	
}
