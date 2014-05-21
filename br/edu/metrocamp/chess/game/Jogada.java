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
		
		if (orig.x() < 0 || orig.y() < 0 || dest.x() < 0 || dest.y() < 0)
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
				this.orig.set(i, this.orig.y());
			}
			
			if (inputString.charAt(1) == letter.charAt(i))
			{
				this.orig.set(this.orig.x(), i);
			}
			
			if (inputString.charAt(3) == number.charAt(i))
			{
				this.dest.set(i, this.orig.y());
			}
			
			if (inputString.charAt(4) == letter.charAt(i))
			{
				this.dest.set(this.orig.x(), i);
			}
		}
	}
	
	private void setDefault()
	{
		this.orig.set(-1, -1);
		this.dest.set(-1, -1);
	}
}
