package br.edu.metrocamp.chess.exceptions;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class ChessCannibalException extends ChessException
{
	private static final long serialVersionUID = -5554074206118999340L;

	public ChessCannibalException()
	{
		super("Do not try to eat your own pieces!!");
	}
}