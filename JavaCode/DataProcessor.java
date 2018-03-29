/*Author = Monjura Afrin Rumi*/
/*
 * This class contains code for mean and standard deviation calculation. Then it stores the data in a databean 
 * object provided by servlet.
 */
import java.util.Vector;
import hw4.DataBean;


public class DataProcessor {
	private Vector<Integer> data;
	private double mean;
	private double std;
	DataBean db;
	protected DataProcessor(String s,DataBean d)
	{
		this.data=new Vector<Integer>();	
		this.db=d;
		String middle[]=s.split(",");
		for(int i=0;i<middle.length;i++)
		{
			this.data.add(Integer.parseInt(middle[i]));
		}
	}
	
	protected double mean_calculate()
	{		
		double sum=0;		
		for (int i=0;i<this.data.size();i++)
		{
			sum+=(double)this.data.get(i);
		}
		this.mean=sum/this.data.size();	
		this.db.setMean(this.mean);	
		return this.mean;
	}
	
	protected double std_calculate()
	{
		double sum=0;
		for (int j=0;j<this.data.size();j++)
		{
			sum+=((double)this.data.get(j)-this.mean)*((double)this.data.get(j)-this.mean);
		}
		this.std=Math.sqrt(sum)/this.data.size();
		this.db.setStd(this.std);
		return this.std;
	}
	
}
