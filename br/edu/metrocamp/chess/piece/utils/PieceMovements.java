package br.edu.metrocamp.chess.piece.utils;

public final class PieceMovements
{
	private static Boolean result;
	
	private static Boolean getResult()
	{
		return result;
	}
	
	private static void setResult(Boolean result)
	{
		PieceMovements.result = result;
	}
	
	public static Boolean whitePawn(int orig_x, int orig_y, int dest_x, int dest_y, Boolean moved, Boolean dest_piece)
	{
		if ( ( moved == false && ( ( Math.abs(dest_y - orig_y) == 0 && (orig_x - dest_x == 2 || orig_x - dest_x == 1) ) || ( Math.abs(dest_y - orig_y) == 1 && orig_x - dest_x == 1 && dest_piece != false ) ) ) || ( moved != false && ( (Math.abs(dest_y - orig_y) == 0 && orig_x - dest_x == 1) || ( Math.abs(dest_y - orig_y) == 1 && orig_x - dest_x == 1 && dest_piece != false ) ) ) )
		{
			setResult(true);
		}
		else
		{
			setResult(false);
		}
		
		return getResult();
	}
	
	public static Boolean blackPawn(int orig_x, int orig_y, int dest_x, int dest_y, Boolean moved, Boolean dest_piece)
	{
		if ( ( moved == false && ( ( Math.abs(dest_y - orig_y) == 0 && (dest_x - orig_x == 2 || dest_x - orig_x == 1) ) || ( Math.abs(dest_y - orig_y) == 1 && dest_x - orig_x == 1 && dest_piece != false ) ) ) || ( moved != false && ( (Math.abs(dest_y - orig_y) == 0 && dest_x - orig_x == 1) || ( Math.abs(dest_y - orig_y) == 1 && dest_x - orig_x == 1 && dest_piece != false ) ) ) )
		{
			setResult(true);
		}
		else
		{
			setResult(false);
		}
		
		return getResult();
	}
}
