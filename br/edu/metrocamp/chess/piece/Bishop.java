package br.edu.metrocamp.chess.piece;

public final class Bishop extends Piece
{
	public Bishop(Coordinate init, Side side, Boolean hasmoved)
	{
		name = "Bishop";
		this.side = side;
		this.hasmoved = hasmoved;
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			this.symbol = Symbols.W_Bishop;
		}
		else
		{
			this.symbol = Symbols.B_Bishop;
		}
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest, Boolean dest_piece)
	{
		Boolean isvalid;
		
		if (PieceUtils.BishopMove(coord.getCoord_x(), coord.getCoord_y(), dest.getCoord_x(), dest.getCoord_y()))
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