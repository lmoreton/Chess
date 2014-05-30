package br.edu.metrocamp.chess.exceptions;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class ChessException extends Exception
{
	private static final long serialVersionUID = -1524944539864701624L;
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