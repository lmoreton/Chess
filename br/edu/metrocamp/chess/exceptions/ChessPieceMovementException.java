package br.edu.metrocamp.chess.exceptions;

/**
 * @author lucasmo
 *
 */
public class ChessPieceMovementException extends ChessException
{
	private static final long serialVersionUID = 511464791990724455L;
	
	public ChessPieceMovementException()
	{
		super("This piece does not move like that! Try again!");
	}
}