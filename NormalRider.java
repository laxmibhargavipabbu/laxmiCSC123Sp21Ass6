package laxmiCSC123Sp21Ass6;

import java.util.Random;

public class NormalRider extends Rider implements TicketPrice
{
	private double ticketPrice;
	private int type;
	
	public NormalRider()
	{
	}
	public NormalRider(int startTimeOnLine)
	{
		super(startTimeOnLine);
		setTicketPrice();
		setType();
	}
	public void setTicketPrice()
	{
		ticketPrice = BASEPRICE;
	}
	public double getTicketPrice()
	{
		return ticketPrice;
	}
	public void setType()
	{
		Random randy = new Random();
		type = randy.nextInt(5) + 1;
	}
	public int getType()
	{
		return type;
	}
}