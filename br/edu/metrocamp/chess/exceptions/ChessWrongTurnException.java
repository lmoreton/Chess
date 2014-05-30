package br.edu.metrocamp.chess.exceptions;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class ChessWrongTurnException extends ChessException
{
	private static final long serialVersionUID = 5048605908815510610L;

	public ChessWrongTurnException()
	{
		super("You are trying to move your opponent's piece! Watch out!");
	}
}
