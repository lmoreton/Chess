package br.edu.metrocamp.chess;

import br.edu.metrocamp.chess.piece.utils.PieceMovements;

public final class Pawn extends Piece
{
	public Pawn(Coordinate init, Side side)
	{
		this.name = "Pawn";
		this.side = side;
		this.isvalid = false;
		this.moved = false;
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
	public Boolean movementValidator(Coordinate dest, Boolean dest_piece)
	{
		if (getSide() == Side.WHITE)
		{
			if (PieceMovements.whitePawn(coord.getCoord_x(), coord.getCoord_y(), dest.getCoord_x(), dest.getCoord_y(), moved, dest_piece))
			{
				setIsvalid(true);
			}
			else
			{
				setIsvalid(false);
			}
		}
		else
		{
			if (PieceMovements.blackPawn(coord.getCoord_x(), coord.getCoord_y(), dest.getCoord_x(), dest.getCoord_y(), moved, dest_piece))
			{
				setIsvalid(true);
			}
			else
			{
				setIsvalid(false);
			}
		}
		
		return getIsvalid();
	}
}