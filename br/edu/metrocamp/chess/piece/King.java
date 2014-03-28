package br.edu.metrocamp.chess.piece;

public final class King extends Piece
{
	public King(Coordinate init, Side side, Boolean hasmoved)
	{
		name = "King";
		this.side = side;
		this.hasmoved = hasmoved;
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			this.symbol = Symbols.W_King;
		}
		else
		{
			this.symbol = Symbols.B_King;
		}
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest, Boolean dest_piece)
	{
		Boolean isvalid;
		
		if (PieceUtils.KnightMove(coord.getCoord_x(), coord.getCoord_y(), dest.getCoord_x(), dest.getCoord_y()))
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