package br.edu.metrocamp.chess.exceptions;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class ChessJogStackException extends ChessException
{
	private static final long serialVersionUID = 7912182972393868988L;

	public ChessJogStackException()
	{
		super("Cannot undo at this time: Stack of movements is empty!");
	}
}