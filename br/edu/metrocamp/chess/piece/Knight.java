package br.edu.metrocamp.chess.piece;

import java.util.ArrayList;

import br.edu.metrocamp.chess.exceptions.ChessPieceMovementException;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Ton
 * @category Class
 */
public final class Knight extends Piece
{
	
	/**
	 * @category Constructor
	 * @param init = Initial piece coordinate.
	 * @param side = Piece's side.
	 * @param hasmoved = Flag to check if the piece has moved before or not.
	 */
	public Knight(Coordinate init, Side side, Boolean hasmoved)
	{
		setName("Knight");
		setSide(side);
		setHasmoved(hasmoved);
		setCoord(init);
		
		if (side == Side.WHITE) //Decision of piece's symbol.
		{
			setSymbol(Symbols.W_Knight);
		}
		else
		{
			setSymbol(Symbols.B_Knight);
		}
	}
	
	/**
	 * @category Method
	 * @param dest = destination coordinate.
	 * @param hasPiece = to check if there is a piece on the destination or not.
	 * @return ArrayList of Coordinate.
	 */
	@Override
	public ArrayList<Coordinate> movementValidator(Coordinate dest, Piece hasPiece) throws ChessPieceMovementException
	{
		ArrayList<Coordinate> coordinates = null;
		
		if ((Math.abs(this.getCoord().getCoord_x() - dest.getCoord_x()) == 2 
			&& Math.abs(this.getCoord().getCoord_y() - dest.getCoord_y()) == 1) 
			|| (Math.abs(this.getCoord().getCoord_x() - dest.getCoord_x()) == 1 
			&& Math.abs(this.getCoord().getCoord_y() - dest.getCoord_y()) == 2))
		{
			coordinates = new ArrayList<Coordinate>();
			coordinates = getCoordinates(coordinates, this.getCoord(), dest);
		}
		else //if it's not valid, throws a new exception.
		{
			throw new ChessPieceMovementException();
		}
		
		return coordinates;
	}
	
	/* 
	 * Method: getCoordinates
	 * Purpose: Verify the positions the piece will assume on its way to the destination coordinate,
	 * 			add it to the coordinate list and then return the list with these coordinates.
	 */
	protected ArrayList<Coordinate> getCoordinates(ArrayList<Coordinate> coordinates, Coordinate orig, Coordinate dest)
	{
		//Knight is able to jump, hence the list will contain only the destination coordinate. No further verification is needed.
		coordinates.add(dest);
		return coordinates;
	}
}