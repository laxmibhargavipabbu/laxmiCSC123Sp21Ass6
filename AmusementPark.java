package laxmiCSC123Sp21Ass6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;


public class AmusementPark 
{
	private String parkName;
	private int numAttractions;
	private ArrayList<Attraction> alAttraction = new ArrayList<>();
	
	public AmusementPark()
	{
		setParkName("");
		setNumAttractions(0);
		createAttractions(0);
	}
	public AmusementPark(String parkName, int numAttractions)
	{
		setParkName(parkName);
		setNumAttractions(numAttractions);
		createAttractions(numAttractions);
	}
	public void setParkName(String prkName)
	{
		parkName = prkName;
	}
	public String getParkName()
	{
		return parkName;
	}
	public void setNumAttractions(int numAttractns)
	{
		numAttractions = numAttractns;
	}
	public int getNumAttractions()
	{
		return numAttractions;
	}
	
	public void createAttractions(int numAttractions)
	{
		Random randy = new Random(2);
		for (int i=0; i < numAttractions; i++)
		{
			int ratePerMinute = randy.nextInt(6) + 10;
			Attraction attraction = new Attraction(ratePerMinute);
			alAttraction.add(attraction);
		}
	}	
	
	public void runThePark(int durationTime)
	{
		Attraction tempAttraction;
		NormalRider tempNormalRider;
		FastRider tempFastRider;
		int initialRiders = 23*numAttractions;
		for(int j=0; j < initialRiders; j++)
		{
			tempAttraction = alAttraction.get(j%numAttractions);
			if(j%7 == 0 || j%3 ==0)
			{
				tempFastRider = new FastRider(0);
				tempAttraction.addRiderFastLine(tempFastRider);
			}
			else
			{
				tempNormalRider = new NormalRider(0);
				tempAttraction.addRiderNormalLine(tempNormalRider);
			}
		}
		int newRiders;
		for(int i = 1; i <= durationTime; i++)
		{
			newRiders = 23*numAttractions;
			for(int j=0; j < newRiders; j++)
			{
				tempAttraction = alAttraction.get(j%numAttractions);
				if(j%7 == 0 || j%3 ==0)
				{
					tempFastRider = new FastRider(i);
					tempAttraction.addRiderFastLine(tempFastRider);
				}
				else
				{
					tempNormalRider = new NormalRider(i);
					tempAttraction.addRiderNormalLine(tempNormalRider);
				}
			}
			int toBeProcessed;
			for(Attraction attraction: alAttraction)
			{
				toBeProcessed = attraction.getRatePerMinute();
				while(toBeProcessed > 0)
				{
					if(attraction.getAlFastLineSize() !=0 && toBeProcessed%3 != 0)
					{
						tempFastRider = attraction.removeRiderFastLine();
						tempFastRider.setEndOnLineTime(i);
						attraction.addGotOnRide(tempFastRider);
						toBeProcessed = toBeProcessed-1;
					}
					else if (attraction.getAlNormalLineSize() !=0)
					{
						tempNormalRider = attraction.removeRiderNormalLine();
						tempNormalRider.setEndOnLineTime(i);
						toBeProcessed = toBeProcessed-1;
						attraction.addGotOnRide(tempNormalRider);
					}
					else
					{
						toBeProcessed = 0;
					}
				}
			}
		}
	}
					
	public void printParkStatistics(PrintWriter outputWriter) throws IOException
	{
		outputWriter.printf("The Statistics for %S\n\n", parkName);
		for(Attraction attraction: alAttraction)
		{
			int totalFastRiders = 0;
			int totalNormalRiders = 0;
			int totalTimeFastRiders = 0;
			int totalTimeNormalRiders = 0;
			double averageTimeFastRiders =0.0;
			double averageTimeNormalRiders =0.0;
			double averageTimeAllRiders =0.0;
			Rider tempRider;
			outputWriter.printf("Statistics for Attraction %s\n", attraction.getAttractionID());
			int gotOnRide = attraction.getAlGotOnRideSize();
			outputWriter.printf("The total number that got onto the ride is %d\n", gotOnRide);
			for(int i = 0; i < gotOnRide; i++)
			{
				tempRider = attraction.getGotOnRide(i);
				if(tempRider instanceof FastRider)
				{
					totalFastRiders++;
					totalTimeFastRiders = totalTimeFastRiders +tempRider.getTimeOnLine();
				}
				else
				{
					totalNormalRiders++;
					totalTimeNormalRiders = totalTimeNormalRiders +tempRider.getTimeOnLine();
				}
			}
			
			averageTimeFastRiders = (double)(totalTimeFastRiders)/totalFastRiders;
			averageTimeNormalRiders = (double)(totalTimeNormalRiders)/totalNormalRiders;
			averageTimeAllRiders = (double)(totalTimeFastRiders+totalTimeNormalRiders)/gotOnRide;
			outputWriter.printf("There were %d Fast Riders who got on waiting an average of %4.2f minutes\n", totalFastRiders, averageTimeFastRiders);
			outputWriter.printf("There were %d Normal Riders who got on waiting an average of %4.2f minutes\n", totalNormalRiders, averageTimeNormalRiders);
			outputWriter.printf("There were %d Total Riders who got on waiting an average of %4.2f minutes\n\n\n", gotOnRide, averageTimeAllRiders);
		}				
	}
}