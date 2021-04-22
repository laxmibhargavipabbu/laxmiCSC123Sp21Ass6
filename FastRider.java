package laxmiCSC123Sp21Ass6;

import java.util.Random;

public class FastRider extends Rider implements TicketPrice
{
	private double ticketPrice;
	private int type;

	public FastRider()
	{
	}
	
	public FastRider(int startTimeOnLine)
	{
		super(startTimeOnLine);
		setTicketPrice();
		setType();
	}
	public void setTicketPrice()
	{
		ticketPrice = 1.2 * BASEPRICE;
	}
	public double getTicketPrice()
	{
		return ticketPrice;
	}
	public void setType()
	{
		Random randy = new Random();
		type = randy.nextInt(10) + 1;
	}
	public int getType()
	{
		return type;
	}
}