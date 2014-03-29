package br.edu.metrocamp.chess.piece;

public final class Bishop extends Piece
{
	public Bishop(Coordinate init, Side side, Boolean hasmoved)
	{
		setName("Bishop");
		setSide(side);
		setHasmoved(hasmoved);
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			setSymbol(Symbols.W_Bishop);
		}
		else
		{
			setSymbol(Symbols.B_Bishop);
		}
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest, Piece hasPiece)
	{
		Boolean isvalid;
		
		if (PieceUtils.BishopMove(getCoord().getCoord_x(), getCoord().getCoord_y(), dest.getCoord_x(), dest.getCoord_y()))
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