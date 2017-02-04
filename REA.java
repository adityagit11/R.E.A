/*
 * TimeStamp: 04-02-2017 14:38*/

/*
 * R.E.A or Redundancy Elimination Algorithm*/
package book;

public class REA
{
	public static void main(String args[])
	{
		//Assume two sources connected to the hub.
		//rate of information of these two sources in messages per sec format
		int rateX = 1;
		int rateY = 1;
		
		double[] sourceMessageX = {44,23,51,34,9};
		double[] sourceMessageY = {4,31,29,41,17};
		
		double totalMessageXL = findTotalMessage(sourceMessageX);
		double totalMessageYL = findTotalMessage(sourceMessageY);
		
		double[] pX = findProbability(sourceMessageX, totalMessageXL);
		double[] pY = findProbability(sourceMessageY, totalMessageYL);
		
		double entropyX = calculateEntropy(pX);
		double entropyY = calculateEntropy(pY);
		
		double RateX = entropyX * rateX;
		double RateY = entropyY * rateY;
		
		System.out.println(RateX+" "+RateY);
	}
	public static double calculateEntropy(double[] ar)
	{
		double sum = 0;
		for(int i = 0;i<ar.length;i++)
		{
			sum = sum + ar[i]*Math.log(1/ar[i]);
		}
		return sum;
	}
	public static double[] findProbability(double[] ar,double totalMessage)
	{
		double[] prob = new double[ar.length];
		for(int i = 0;i<ar.length;i++)
		{
			prob[i] = ar[i]/totalMessage;
		}
		return prob;
	}
	public static double findTotalMessage(double[] ar)
	{
		double sum = 0;
		for(int i = 0;i<ar.length;i++)
		{
			sum = sum + ar[i];
		}
		return sum;
	}
}
