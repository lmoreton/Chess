package br.edu.metrocamp.chess.exceptions;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class ChessCannotUndoException extends ChessException
{
	private static final long serialVersionUID = -3551615839263686844L;

	public ChessCannotUndoException()
	{
		super("You cannot undo twice in a row!");
	}
}