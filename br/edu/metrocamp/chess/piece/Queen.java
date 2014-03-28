package br.edu.metrocamp.chess.piece;

public final class Queen extends Piece
{
	public Queen(Coordinate init, Side side, Boolean hasmoved)
	{
		name = "Queen";
		this.side = side;
		this.hasmoved = hasmoved;
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			this.symbol = Symbols.W_Queen;
		}
		else
		{
			this.symbol = Symbols.B_Queen;
		}
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest, Boolean dest_piece)
	{
		Boolean isvalid;
		
		if (PieceUtils.QueenMove(coord.getCoord_x(), coord.getCoord_y(), dest.getCoord_x(), dest.getCoord_y()))
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