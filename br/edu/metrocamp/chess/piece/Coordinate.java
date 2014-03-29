package br.edu.metrocamp.chess.piece;

public class Coordinate
{
	private int x;
	private int y;
	
	public Coordinate(int x, int y)
	{
		//Constructor to start with initial positions.
		this.x = x;
		this.y = y;
	}
	
	public Coordinate()
	{
		//Default constructor.
	}
	
	public int getCoord_x()
	{
		return x;
	}
	
	public int getCoord_y()
	{
		return y;
	}
	
	public void setCoord_x(int x)
	{
		this.x = x;
	}
	
	public void setCoord_y(int y)
	{
		this.y = y;
	}
}
