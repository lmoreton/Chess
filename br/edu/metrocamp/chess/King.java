package br.edu.metrocamp.chess;

public final class King extends Piece
{
	@Override
	public Boolean movementValidator(Coordinate dest)
	{
		return true;
	}
}