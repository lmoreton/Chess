package br.edu.metrocamp.chess;

public class Coordinate
{
	private int x;
	private int y;
  //private int z;
	
	public Coordinate(int x, int y)
	{
		//Constructor to start with initial positions.
		this.x = x;
		this.y = y;
	  //this.z = z;
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
	
 /* public int getCoord_z()
  * {
  *	 	return z;
  * }
  */
	
	public void setCoord_x(int x)
	{
		this.x = x;
	}
	
	public void setCoord_y(int y)
	{
		this.y = y;
	}
	
 /* public void setCoord_z(int z)
  * {
  *  	this.z = z;
  * }
  */
}
