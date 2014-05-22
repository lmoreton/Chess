package br.edu.metrocamp.chess.piece;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
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
		//Default constructor setting default values to x/y.
		x = -1;
		y = -1;
	}
	
	public int x()
	{
		return x;
	}
	
	public int y()
	{
		return y;
	}
	
	public void set(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void set(String coord) //Not tested yet!!!
	{
		this.x = Integer.valueOf(coord.charAt(0));
		this.y = Integer.valueOf(coord.charAt(1));
	}

	public String toString() 
	{
		return (x + 1) + String.valueOf((char) ('a' + y));
	}
}
