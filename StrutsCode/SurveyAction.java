/*Author = Monjura Afrin Rumi*/
/*
 * This class read data from survey.jsp, Call StudentDAO class to store data in database.
 * Calls DataProcessor class to calculate mean and standard deviation if provided.
 * Based on the values of Dataset, returns string value to be rndered either of acknowledgement.jsp.   
 */

package hw_struts;

public class SurveyAction
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
	
	private String allid;
	
	private String numbers;
	private double mean;
	private double std;
	
	public String execute()
	{		
		DataProcessor dp=new DataProcessor(this.numbers);
		this.mean=dp.mean_calculate();
		this.std=dp.std_calculate();		
		StudentDAO stdao=new StudentDAO();		
		stdao.storetName(this.fname, this.mname, this.lname);
		stdao.StoreAddress(this.address, this.zipcode, this.city, this.state);
		stdao.StoreContact(this.phone, this.email, this.url);
		stdao.storeStudent(this.studentid, this.gmonth, this.gyear);
		stdao.storeOther(this.date, this.mostliked, this.interested,this.recommend);
		int rs=stdao.insertData();
		if (rs==-1)
		{
			System.out.println("failed to insert");
		}
		this.allid=stdao.getStudentIds();				
		if (this.mean>=90)
			return "winner";
		else
			return "simple";
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

	public void setLname (String lastname)
	{
		this.lname = lastname;			
	}	

	public void setAddress (String address)
	{
		this.address = address;			
	}	

	public void setZipcode (String zipcode)
	{
		this.zipcode = zipcode;	
	}	

	public void setCity (String city)
	{
		this.city = city;			
	}
	
	public void setState (String state)
	{
		this.state = state;	 		
	}
	
	public void setPhone (String phone)
	{
		this.phone = phone;	  		
	}

	public void setStudentid (String studentid)
	{
		this.studentid = studentid;		
	}
	
	public void setEmail (String email)
	{
		this.email = email;	 		
	}
	
	public void setUrl (String net_url)
	{
		this.url = net_url;	 		
	}
	
	public void setDate (String date)
	{
		this.date = date;
	}
	
	public void setGmonth (String month)	
	{				
		this.gmonth = month;		
	}

	public void setGyear (String year)
	{
		this.gyear = year;		
	}
		
	public void setMostliked (String liked)
	{		
		this.mostliked=liked;			
	}

	public void setInterested (String interest)
	{
		this.interested = interest;	   
	}
	
	public void setRecommend (String recom)
	{		
		this.recommend = recom;			
	}
	
	public String getAllid()
	{
		return this.allid;
	}

	public void setNumbers(String numbers)
	{
		this.numbers=numbers;
	}	
	
	public double getMean ()
	{
	   return this.mean;
	}	
	
	public double getStd ()
	{
	   return this.std;
	}			
}
