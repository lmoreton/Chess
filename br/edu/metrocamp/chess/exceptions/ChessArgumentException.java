package br.edu.metrocamp.chess.exceptions;

/**
 * @author lucasmo
 *
 */
public class ChessArgumentException extends ChessException
{
	private static final long serialVersionUID = 1906186747006084735L;

	public ChessArgumentException()
	{
		super("Incorrect input! Follow the example: 2a 4a");
	}
}