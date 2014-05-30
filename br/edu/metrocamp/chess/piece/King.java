package br.edu.metrocamp.chess.piece;

import java.util.ArrayList;
import java.util.List;

import br.edu.metrocamp.chess.exceptions.ChessPieceMovementException;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public final class King extends Piece
{
	
	/**
	 * @category Constructor
	 * @param init = Initial piece coordinate.
	 * @param side = Piece's side.
	 * @param hasmoved = Flag to check if the piece has moved before or not.
	 */
	public King(Coordinate init, Side side, Boolean hasmoved)
	{
		super("King", init, side, hasmoved);
	}
	
	/**
	 * @category Method
	 * @param dest = destination coordinate.
	 * @param hasPiece = to check if there is a piece on the destination or not.
	 * @return ArrayList of Coordinate.
	 */
	@Override
	public List<Coordinate> movementValidator(Coordinate dest, Piece hasPiece) throws ChessPieceMovementException
	{
		List<Coordinate> coordinates = null;
		
		if (Math.abs(this.getCoord().x() - dest.x()) <= 1 
				&& Math.abs(this.getCoord().y() - dest.y()) <= 1) //Verify if movement is valid.
		{
			coordinates = getCoordinates(this.getCoord(), dest);
		}
		else //if it's not valid, throws a new exception.
		{
			throw new ChessPieceMovementException();
		}
		
		return coordinates;
	}
	
	/** 
	 * Method: getCoordinates
	 * Purpose: Verify the positions the piece will assume on its way to the destination coordinate,
	 * 			add it to the coordinate list and then return the list with these coordinates.
	 */
	protected List<Coordinate> getCoordinates(Coordinate orig, Coordinate dest)
	{
		//Since the King moves only 1 step per turn and it can move/capture
		// to any direction, hence the list will contain only the destination coordinate. No further verification is needed.
		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		coordinates.add(dest);
		return coordinates;
	}
	
	/**
	 * Define the piece symbol based on it's Side.
	 * @category Method
	 */
	@Override
	protected Symbols defSymbol(Side side)
	{
		Symbols symbol;
		
		if (side == Side.WHITE) symbol = Symbols.W_King;
		else symbol = Symbols.B_King;
		
		return symbol;
	}
}