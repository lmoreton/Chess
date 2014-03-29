package br.edu.metrocamp.chess.piece;

public final class King extends Piece
{
	public King(Coordinate init, Side side, Boolean hasmoved)
	{
		setName("King");
		setSide(side);
		setHasmoved(hasmoved);
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			setSymbol(Symbols.W_King);
		}
		else
		{
			setSymbol(Symbols.B_King);
		}
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest, Piece hasPiece)
	{
		Boolean isvalid;
		
		if (PieceUtils.KnightMove(getCoord().getCoord_x(), getCoord().getCoord_y(), dest.getCoord_x(), dest.getCoord_y()))
		{
			isvalid = true;
		}
		else
		{
			isvalid = false;
		}
		
		return isvalid;
	}
}