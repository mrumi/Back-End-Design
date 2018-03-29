/*Author=Monjura Afrin Rumi*/
/* This class stores stores mean and standard deviation of numbers entered by user.
 * mean and std is zero in case used did not enter any number.
*/
package hw4;


public class DataBean {
	private double mean;
	private double std;	

	public DataBean ()
	{
	}

	// Property "name"	
	public void setMean (double m)
	{
	   this.mean = m;		   
	}

	public double getMean ()
	{
	   return this.mean;
	}
	
	public void setStd (double s)
	{
	   this.std = s;	   
	}
		
	public double getStd ()
	{
	   return this.std;
	}
	
}
