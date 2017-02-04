package book;

import java.util.Scanner;

public class REA_HubChannel
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the nodes (Users) connected Hub");
		int numOfUser = input.nextInt();
		
		System.out.println("Enter the message types:");
		int msgType = input.nextInt();
		
		System.out.println("Enter the entries of each user");
		double[][] matrix = new double[numOfUser][msgType];
		for(int i = 0;i<numOfUser;i++)
		{
			System.out.println("Enter the number of messages for each message type for user: "+(i+1));
			for(int j = 0;j<msgType;j++)
			{
				matrix[i][j] = input.nextInt();
			}
		}
		
		double[] totalMessageArray = new double[numOfUser];
		for(int i = 0;i<numOfUser;i++)
		{
			totalMessageArray[i] = REA.findTotalMessage(matrix[i]);
		}
		
		double[][] probMatrix = new double[numOfUser][msgType];
		for(int i = 0;i<numOfUser;i++)
		{
			probMatrix[i] = REA.findProbability(matrix[i], totalMessageArray[i]);
		}
		
		double[] entropyArray = new double[numOfUser];
		for(int i = 0;i<numOfUser;i++)
		{
			entropyArray[i] = REA.calculateEntropy(probMatrix[i]);
		}
		
		System.out.println("Enter the rate of messages sent by each user");
		int[] rate = new int[numOfUser];
		for(int i = 0;i<numOfUser;i++)
		{
			rate[i] = input.nextInt();
		}
		
		double[] Rate = new double[numOfUser];
		for(int i = 0;i<numOfUser;i++)
		{
			Rate[i] = entropyArray[i] * rate[i];
		}
		
		for(int i = 0;i<numOfUser;i++)
		{
			System.out.println("The average information send by user "+(i+1)+" is "+Rate[i]);
		}
		input.close();
	}
}
