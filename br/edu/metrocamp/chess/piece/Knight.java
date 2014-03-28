package br.edu.metrocamp.chess.piece;

public final class Knight extends Piece
{
	public Knight(Coordinate init, Side side, Boolean hasmoved)
	{
		name = "Knight";
		this.side = side;
		this.hasmoved = hasmoved;
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			this.symbol = Symbols.W_Knight;
		}
		else
		{
			this.symbol = Symbols.B_Knight;
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