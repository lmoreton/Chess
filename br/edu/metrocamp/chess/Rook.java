package br.edu.metrocamp.chess;

public final class Rook extends Piece
{
	@Override
	public Boolean movementValidator(Coordinate dest, Boolean dest_piece)
	{
		return true;
	}
}