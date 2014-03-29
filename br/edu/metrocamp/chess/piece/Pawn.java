package br.edu.metrocamp.chess.piece;

public final class Pawn extends Piece
{
	public Pawn(Coordinate init, Side side, Boolean hasmoved)
	{
		setName("Pawn");
		setSide(side);
		setHasmoved(hasmoved);
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			setSymbol(Symbols.W_Pawn);
		}
		else
		{
			setSymbol(Symbols.B_Pawn);
		}
		
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest, Piece hasPiece)
	{
		Boolean isvalid;
		
		if (getSide() == Side.WHITE)
		{
			if (PieceUtils.whitePawnMove(getCoord().getCoord_x(), getCoord().getCoord_y(), dest.getCoord_x(), dest.getCoord_y(), getHasmoved(), hasPiece))
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
			if (PieceUtils.blackPawnMove(getCoord().getCoord_x(), getCoord().getCoord_y(), dest.getCoord_x(), dest.getCoord_y(), getHasmoved(), hasPiece))
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