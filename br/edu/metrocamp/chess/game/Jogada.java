package br.edu.metrocamp.chess.game;

import br.edu.metrocamp.chess.exceptions.ChessArgumentException;
import br.edu.metrocamp.chess.piece.Coordinate;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class Jogada
{
	public Coordinate orig;
	public Coordinate dest;
	
	public Jogada()
	{
		orig = new Coordinate();
		dest = new Coordinate();
	}
	
	public void generateMatrixCoord(String inputString) throws ChessArgumentException
	{
		setDefault();
		formatString(inputString);
		
		if (orig.getCoord_x() < 0 || orig.getCoord_y() < 0 || dest.getCoord_x() < 0 || dest.getCoord_y() < 0)
		{
			throw new ChessArgumentException();
		}
	}
	
	private void formatString(String inputString)
	{
		inputString.toLowerCase();
		
		//char[] letters = {'a','b','c','d','e','f','g','h'};
		//char[] numbers = {'8','7','6','5','4','3','2','1'};
		String letter = "abcdefgh";
		String number = "87654321";
		
		for (int i = 0; i < 8; i++)
		{
			if (inputString.charAt(0) == number.charAt(i))
			{
				this.orig.setCoord_x(i);
			}
			
			if (inputString.charAt(1) == letter.charAt(i))
			{
				this.orig.setCoord_y(i);
			}
			
			if (inputString.charAt(3) == number.charAt(i))
			{
				this.dest.setCoord_x(i);
			}
			
			if (inputString.charAt(4) == letter.charAt(i))
			{
				this.dest.setCoord_y(i);
			}
		}
	}
	
	private void setDefault()
	{
		this.orig.setCoord_x(-1);
		this.orig.setCoord_y(-1);
		this.dest.setCoord_x(-1);
		this.dest.setCoord_y(-1);
	}
}
