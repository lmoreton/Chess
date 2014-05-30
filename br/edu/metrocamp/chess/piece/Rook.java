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
public final class Rook extends Piece
{
	
	/**
	 * @category Constructor
	 * @param init = Initial piece coordinate.
	 * @param side = Piece's side.
	 * @param hasmoved = Flag to check if the piece has moved before or not.
	 */
	public Rook(Coordinate init, Side side, Boolean hasmoved)
	{
		super("Rook", init, side, hasmoved);
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
		
		if (Math.abs(this.getCoord().x() - dest.x()) == 0 
				|| Math.abs(this.getCoord().y() - dest.y()) == 0) //Verify if movement is valid.
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
		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		int i = 0;
		int j = 0;
		
		if (orig.y() < dest.y()) //To the right
		{
			while ((orig.y() + j) < dest.y())
			{
				j++;
				coordinates.add( new Coordinate( (orig.x() + i),(orig.y() + j) ) );
			}
		}
		else
		{
			if (orig.y() > dest.y()) //To the left
			{
				while ((orig.y() + j) > dest.y())
				{
					j--;
					coordinates.add( new Coordinate( (orig.x() + i),(orig.y() + j) ) );
				}
			}
			else
			{
				if (orig.x() < dest.x()) //Down the river
				{
					while ((orig.x() + i) < dest.x())
					{
						i++;
						coordinates.add( new Coordinate( (orig.x() + i),(orig.y() + j) ) );
					}
				}
				else
				{
					if (orig.x() > dest.x()) //Up we go
					{
						while ((orig.x() + i) > dest.x())
						{
							i--;
							coordinates.add( new Coordinate( (orig.x() + i),(orig.y() + j) ) );
						}
					}
				}
			}
		}
		
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
		
		if (side == Side.WHITE) symbol = Symbols.W_Rook;
		else symbol = Symbols.B_Rook;
		
		return symbol;
	}
}