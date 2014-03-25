package br.edu.metrocamp.chess;

public final class Pawn extends Piece
{
	public Pawn(Coordinate init, Side side)
	{
		name = "Pawn";
		this.side = side;
		setIsvalid(false);
		setMoved(false);
		setCoord(init);
		
		if (side == Side.WHITE)
		{
			symbol = Symbols.p;
		}
		else
		{
			symbol = Symbols.P;
		}
		
	}
	
	@Override
	public Boolean movementValidator(Coordinate dest)
	{
		if (getSide() == Side.WHITE)
		{
			if ( ( getMoved() == false && ( ( Math.abs(getCoord().getCoord_y() - dest.getCoord_y()) == 0 && (getCoord().getCoord_x() - dest.getCoord_x() == 2 || getCoord().getCoord_x() - dest.getCoord_x() == 1) ) || ( Math.abs(dest.getCoord_y() - getCoord().getCoord_y()) == 1 && getCoord().getCoord_x() - dest.getCoord_x() == 1 ) ) ) || ( getMoved() == true && ( ( Math.abs(dest.getCoord_y() - getCoord().getCoord_y()) == 0 && getCoord().getCoord_x() - dest.getCoord_x() == 1) || ( Math.abs(dest.getCoord_y() - getCoord().getCoord_y()) == 1 && getCoord().getCoord_x() - dest.getCoord_x() == 1 ) ) ) )
			{
				setIsvalid(true);
			}
			else
			{
				setIsvalid(false);
			}
		}
		else
		{
			if ( ( getMoved() == false && ( ( Math.abs(getCoord().getCoord_y() - dest.getCoord_y()) == 0 && (dest.getCoord_x() - getCoord().getCoord_x() == 2 || dest.getCoord_x() - getCoord().getCoord_x() == 1) ) || ( Math.abs(dest.getCoord_y() - getCoord().getCoord_y()) == 1 && dest.getCoord_x() - getCoord().getCoord_x() == 1 ) ) ) || ( getMoved() == true && ( ( Math.abs(dest.getCoord_y() - getCoord().getCoord_y()) == 0 && dest.getCoord_x() - getCoord().getCoord_x() == 1) || ( Math.abs(dest.getCoord_y() - getCoord().getCoord_y()) == 1 && dest.getCoord_x() - getCoord().getCoord_x() == 1 ) ) ) )
			{
				setIsvalid(true);
			}
			else
			{
				setIsvalid(false);
			}
		}
		
		return getIsvalid();
	}
}