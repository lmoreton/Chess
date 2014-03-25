package br.edu.metrocamp.chess;

public final class Queen extends Piece
{
	@Override
	public Boolean movementValidator(Coordinate dest)
	{
		return true;
	}
}