package br.edu.metrocamp.chess.piece;

import br.edu.metrocamp.chess.board.Board;

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
		return (Board.board_size - x) + String.valueOf((char) ('a' + y));
	}
}
