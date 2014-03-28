package br.edu.metrocamp.chess.piece;

public final class Rook extends Piece
{
	public Rook(Coordinate init, Side side, Boolean hasmoved)
	{
		name = "Rook";
		this.side = side;
		this.hasmoved = hasmoved;
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			this.symbol = Symbols.W_Rook;
		}
		else
		{
			this.symbol = Symbols.B_Rook;
		}
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest, Boolean dest_piece)
	{
		Boolean isvalid;
		
		if (PieceUtils.RookMove(coord.getCoord_x(), coord.getCoord_y(), dest.getCoord_x(), dest.getCoord_y()))
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