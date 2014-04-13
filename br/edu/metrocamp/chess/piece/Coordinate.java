package br.edu.metrocamp.chess.piece;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Ton
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
