package br.edu.metrocamp.chess.exceptions;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class ChessNullCoordException extends ChessException
{
	private static final long serialVersionUID = 6331280867271825812L;

	public ChessNullCoordException()
	{
		super("There is no piece at origin coordinate!");
	}
}