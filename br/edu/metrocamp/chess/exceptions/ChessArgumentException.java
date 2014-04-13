package br.edu.metrocamp.chess.exceptions;

/**
 * @author lucasmo
 *
 */
public class ChessArgumentException extends ChessException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChessArgumentException()
	{
		super("Incorrect input! Follow the example: 2a 4a");
	}
}