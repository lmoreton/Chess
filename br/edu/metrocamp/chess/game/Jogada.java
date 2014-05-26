package br.edu.metrocamp.chess.game;

import br.edu.metrocamp.chess.board.Board;
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
	
	public boolean check(String input) throws ChessArgumentException
	{
		boolean isOk = false;
		
		if (input == null) throw new ChessArgumentException();
		else if (input.isEmpty() || input.length() > 5) throw new ChessArgumentException();
		else if (input.indexOf(' ') < 0) throw new ChessArgumentException();
		else
		{
			String[] strings = input.split(" ");
			int i = 1;
			
			for (String coord : strings)
			{
				if (coord.length() != 2) throw new ChessArgumentException();
				
				if (i == 1)
				{
					if ( (Board.board_size - Character.getNumericValue(coord.charAt(0))) < 0
						  || (Board.board_size - Character.getNumericValue(coord.charAt(0))) > 8 )
					{
						throw new ChessArgumentException();
					}
				}
				else
				{
					if ( (Character.getNumericValue(coord.charAt(1)) - Character.getNumericValue('a')) < 0
						  || (Character.getNumericValue(coord.charAt(1)) - Character.getNumericValue('a')) > 8 )
					{
						throw new ChessArgumentException();
					}
				}
				
				i++;
			}
			
			isOk = true;
		}
		
		return isOk;
	}
	
	public void set(String[] coords)
	{
		int i = 1;
		
		for (String coord : coords)
		{
			if (i == 1) this.orig.set(Board.board_size - Character.getNumericValue(coord.charAt(0)), Character.getNumericValue(coord.charAt(1)) - Character.getNumericValue('a'));
			else this.dest.set(Board.board_size - Character.getNumericValue(coord.charAt(0)), Character.getNumericValue(coord.charAt(1)) - Character.getNumericValue('a'));
			
			i++;
		}
	}
}
