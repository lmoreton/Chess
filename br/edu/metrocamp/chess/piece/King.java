package br.edu.metrocamp.chess.piece;

public final class King extends Piece
{
	@Override
	public Boolean movementValidator(Coordinate dest, Boolean dest_piece)
	{
		return true;
	}
}