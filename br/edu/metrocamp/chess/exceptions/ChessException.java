package br.edu.metrocamp.chess.exceptions;

/**
 * @author lucasmo
 *
 */
public class ChessException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public ChessException(String msg)
	{
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage()
	{
		return msg;
	}
}