package br.edu.metrocamp.chess.exceptions;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class ChessSameCoordException extends ChessException
{
	private static final long serialVersionUID = 2173664850059241473L;
	
	public ChessSameCoordException()
	{
		super("This way, you're not going anywhere!");
	}
}
