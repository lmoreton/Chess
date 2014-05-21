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

	public String toString() 
	{
		return String.valueOf((char) ('a' + x)) + y;
	}

	public static void main(String[] args) 
	{
		Coordinate c = new Coordinate(0, 0);
		assert c.toString().equals("a0");
		c.set(3, 7);
		assert c.toString().equals("d7");
		System.out.println("c = "+c);
	}
}
