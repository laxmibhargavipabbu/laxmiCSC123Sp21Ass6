package Assignment6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimulatePark 
{
	public static void main(String [] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		String parkName;
		String outputFileName;
		int numAttractions;
		int simulatedTime;
		System.out.printf("Please enter the name of Amusement Park: ");
		parkName = keyboard.nextLine();
		System.out.printf("Please enter the number of attractions\nNumber must be between 3 and 10 inclusively, excluding 7: ");
		numAttractions = keyboard.nextInt();
		if(numAttractions >=3 && numAttractions <=10 && numAttractions !=7)
		{
			AmusementPark amusementPark = new AmusementPark(parkName,numAttractions);
			System.out.printf("Please enter the duration of the simulation in minutes\nMust enter 60 minutes or greater: ");
			simulatedTime = keyboard.nextInt();
			if(simulatedTime >=60 )
			{
				amusementPark.runThePark(simulatedTime);
				System.out.printf("Please enter the name of the output file: ");
				outputFileName = keyboard.next();
				File outputFile = new File(outputFileName);
				PrintWriter OutputWriter = new PrintWriter(outputFile);
				amusementPark.printParkStatistics(OutputWriter);
				OutputWriter.close();
			}
			else
			{
				System.out.printf("Invalid input!\n");
			}
		}
		else
		{
			System.out.printf("Invalid input!\n");
		}
		keyboard.close();
	}
}
