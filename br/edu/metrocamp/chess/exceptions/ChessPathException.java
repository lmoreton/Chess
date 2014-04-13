package br.edu.metrocamp.chess.exceptions;

/**
 * @author lucasmo
 *
 */
public class ChessPathException extends ChessException
{
	private static final long serialVersionUID = 1L;

	public ChessPathException()
	{
		super("There are other pieces on your way! Watch out!");
	}
}