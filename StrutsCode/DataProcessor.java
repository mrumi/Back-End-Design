/*Author = Monjura Afrin Rumi*/
/* 
 * This class contains code for mean and standard deviation calculation. 
 */

package hw_struts;

import java.util.Vector;

public class DataProcessor 
{
	private Vector<Integer> data;
	private double mean;
	private double std;
	
	public DataProcessor(String s)
	{					
		this.data=new Vector<Integer>();
		if(!(s.isEmpty())){
			String middle[]=s.split(",");			
			for(int i=0;i<middle.length;i++)
			{			
				this.data.add(Integer.parseInt(middle[i]));
			}
		}		
	}
	
	protected double mean_calculate()
	{
		if(this.data.size()==0)
			return 0;
		double sum=0;		
		for (int i=0;i<this.data.size();i++)
		{
			sum+=(double)this.data.get(i);
		}
		this.mean=sum/this.data.size();			
		return this.mean;
	}
	
	protected double std_calculate()
	{
		if(this.data.size()==0)
			return 0;
		double sum=0;
		for (int j=0;j<this.data.size();j++)
		{
			sum+=((double)this.data.get(j)-this.mean)*((double)this.data.get(j)-this.mean);
		}
		this.std=Math.sqrt(sum)/this.data.size();		
		return this.std;
	}
}
