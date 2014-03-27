package br.edu.metrocamp.chess.piece;

import br.edu.metrocamp.chess.piece.utils.PieceUtils;

public final class Pawn extends Piece
{
	public Pawn(Coordinate init, Side side, Boolean hasmoved)
	{
		name = "Pawn";
		this.side = side;
		this.hasmoved = hasmoved;
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			this.symbol = Symbols.W_Pawn;
		}
		else
		{
			this.symbol = Symbols.B_Pawn;
		}
		
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest, Boolean hasDest_Piece)
	{
		Boolean isvalid;
		
		if (getSide() == Side.WHITE)
		{
			if (PieceUtils.whitePawnMove(coord.getCoord_x(), coord.getCoord_y(), dest.getCoord_x(), dest.getCoord_y(), hasmoved, hasDest_Piece))
			{
				isvalid = true;
			}
			else
			{
				isvalid = false;
			}
		}
		else
		{
			if (PieceUtils.blackPawnMove(coord.getCoord_x(), coord.getCoord_y(), dest.getCoord_x(), dest.getCoord_y(), hasmoved, hasDest_Piece))
			{
				isvalid = true;
			}
			else
			{
				isvalid = false;
			}
		}
		
		return isvalid;
	}
}