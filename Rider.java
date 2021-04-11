package Assignment6;

public abstract class Rider 
{
	private int startOnLineTime;
	private int endOnLineTime;
	private int timeOnLine;

	public Rider()
	{}
	public Rider(int startTimeOnLine)
	{
		setStartOnLineTime(startTimeOnLine);
	}
	public void setStartOnLineTime(int startTimeOnLine)
	{
		startOnLineTime = startTimeOnLine;
	}
	public int getStartOnLineTime()
	{
		return startOnLineTime;
	}
	public void setEndOnLineTime(int endTimeOnLine)
	{
		endOnLineTime = endTimeOnLine;
		timeOnLine = endOnLineTime - startOnLineTime;
	}
	public int getEndOnLineTime()
	{
		return endOnLineTime;
	}	

	public int getTimeOnLine()
	{
		return timeOnLine;
	}
	public abstract void setType();
	public abstract int getType();
}