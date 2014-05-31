package br.edu.metrocamp.chess.exceptions;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class ChessUndoException extends ChessException
{
	private static final long serialVersionUID = -194116119894220576L;

	public ChessUndoException()
	{
		super("Make a wiser choice this time!\n***UNDO = completed");
	}
}
