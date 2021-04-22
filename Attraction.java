package laxmiCSC123Sp21Ass6;
import java.util.ArrayList;

public class Attraction
{
	public static int attractionCounter = 0;
	private String attractionID;
	private int ratePerMinute;
	private ArrayList<NormalRider> alNormalLine = new ArrayList<NormalRider>();
	private ArrayList<FastRider> alFastLine = new ArrayList<FastRider>();
	private ArrayList<Rider> alGotOnRide = new ArrayList<Rider>();
	public Attraction()
	{
		attractionID = "";		
	}
	public Attraction(int ratePerMinute)
	{
		setAttractionID();
		setRatePerMinute(ratePerMinute);
	}
	public void setAttractionID()
	{
		attractionCounter = attractionCounter + 1;
		attractionID = "RIDE" + attractionCounter;
	}
	public String getAttractionID()
	{
		return attractionID;
	}
	public void setRatePerMinute(int time)
	{
		ratePerMinute = time;
	}
	public int getRatePerMinute()
	{
		return ratePerMinute;
	}
	public void addRiderNormalLine(NormalRider nrmlRider)
	{
		alNormalLine.add(nrmlRider);
	}
	public NormalRider removeRiderNormalLine()
	{
		return alNormalLine.remove(0);
	}
	public int getAlNormalLineSize()
	{
		return alNormalLine.size();
	}
	public void addRiderFastLine(FastRider fstRider)
	{
		alFastLine.add(fstRider);
	}
	public FastRider removeRiderFastLine()
	{
		return alFastLine.remove(0);
	}
	public int getAlFastLineSize()
	{
		return alFastLine.size();
	}
	public void addGotOnRide(Rider riderAny)
	{
		alGotOnRide.add(riderAny);
	}
	public Rider getGotOnRide(int i)
	{
		return alGotOnRide.get(i);
	}
	public int getAlGotOnRideSize()
	{
		return alGotOnRide.size();
	}
}