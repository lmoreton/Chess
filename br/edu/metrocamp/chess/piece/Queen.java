package br.edu.metrocamp.chess.piece;

public final class Queen extends Piece
{
	public Queen(Coordinate init, Side side, Boolean hasmoved)
	{
		setName("Queen");
		setSide(side);
		setHasmoved(hasmoved);
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			setSymbol(Symbols.W_Queen);
		}
		else
		{
			setSymbol(Symbols.B_Queen);
		}
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest, Piece hasPiece)
	{
		Boolean isvalid;
		
		if (PieceUtils.QueenMove(getCoord().getCoord_x(), getCoord().getCoord_y(), dest.getCoord_x(), dest.getCoord_y()))
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