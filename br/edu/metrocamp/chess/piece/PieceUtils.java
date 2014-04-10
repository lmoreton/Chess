package br.edu.metrocamp.chess.piece;

final class PieceUtils
{
	private static Boolean result;
	
	
	public static Boolean whitePawnMove(int orig_x, int orig_y, int dest_x, int dest_y, Boolean moved, Piece hasPiece)
	{
		if ( ( moved == false && ( ( Math.abs(dest_y - orig_y) == 0 && (orig_x - dest_x == 2 || (orig_x - dest_x == 1 && hasPiece == null)) ) || ( Math.abs(dest_y - orig_y) == 1 && orig_x - dest_x == 1 && hasPiece != null ) ) ) || ( moved != false && ( (Math.abs(dest_y - orig_y) == 0 && (orig_x - dest_x == 1 && hasPiece == null)) || ( Math.abs(dest_y - orig_y) == 1 && orig_x - dest_x == 1 && hasPiece != null ) ) ) )
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	public static Boolean blackPawnMove(int orig_x, int orig_y, int dest_x, int dest_y, Boolean moved, Piece hasPiece)
	{
		if ( ( moved == false && ( ( Math.abs(dest_y - orig_y) == 0 && (dest_x - orig_x == 2 || (dest_x - orig_x == 1 && hasPiece == null)) ) || ( Math.abs(dest_y - orig_y) == 1 && dest_x - orig_x == 1 && hasPiece != null ) ) ) || ( moved != false && ( (Math.abs(dest_y - orig_y) == 0 && (dest_x - orig_x == 1 && hasPiece == null)) || ( Math.abs(dest_y - orig_y) == 1 && dest_x - orig_x == 1 && hasPiece != null ) ) ) )
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	public static Boolean RookMove(int orig_x, int orig_y, int dest_x, int dest_y)
	{
		if (Math.abs(orig_x - dest_x) == 0 || Math.abs(orig_y - dest_y) == 0)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	public static Boolean KnightMove(int orig_x, int orig_y, int dest_x, int dest_y)
	{
		if ((Math.abs(orig_x - dest_x) == 2 && Math.abs(orig_y - dest_y) == 1) || (Math.abs(orig_x - dest_x) == 1 && Math.abs(orig_y - dest_y) == 2))
		{
			result = true;
		}
		else
		{
			result = false;
		}
		return result;
	}
	
	public static Boolean BishopMove(int orig_x, int orig_y, int dest_x, int dest_y)
	{
		if (Math.abs(orig_x - dest_x) == Math.abs(orig_y - dest_y))
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	public static Boolean KingMove(int orig_x, int orig_y, int dest_x, int dest_y)
	{
		if (Math.abs(orig_x - dest_x) <= 1 && Math.abs(orig_y - dest_y) <= 1)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	public static Boolean QueenMove(int orig_x, int orig_y, int dest_x, int dest_y)
	{
		if (PieceUtils.RookMove(orig_x, orig_y, dest_x, dest_y) || PieceUtils.BishopMove(orig_x, orig_y, dest_x, dest_y))
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
}
