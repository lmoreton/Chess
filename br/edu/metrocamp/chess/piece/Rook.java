package br.edu.metrocamp.chess.piece;

public final class Rook extends Piece
{
	public Rook(Coordinate init, Side side, Boolean hasmoved)
	{
		setName("Rook");
		setSide(side);
		setHasmoved(hasmoved);
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			setSymbol(Symbols.W_Rook);
		}
		else
		{
			setSymbol(Symbols.B_Rook);
		}
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest, Piece hasPiece)
	{
		Boolean isvalid;
		
		if (PieceUtils.RookMove(getCoord().getCoord_x(), getCoord().getCoord_y(), dest.getCoord_x(), dest.getCoord_y()))
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