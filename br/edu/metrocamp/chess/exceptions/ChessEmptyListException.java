package br.edu.metrocamp.chess.exceptions;

/**
 * @author lucasmo
 *
 */
public class ChessEmptyListException extends ChessException
{
	private static final long serialVersionUID = 3173200194931004699L;

	public ChessEmptyListException()
	{
		super("The list of pieces is empty! Try again!");
	}
}
