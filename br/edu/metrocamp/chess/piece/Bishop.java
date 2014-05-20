package br.edu.metrocamp.chess.piece;

import java.util.ArrayList;

import br.edu.metrocamp.chess.exceptions.ChessPieceMovementException;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public final class Bishop extends Piece
{
	/**
	 * @category Constructor
	 * @param init = Initial piece coordinate.
	 * @param side = Piece's side.
	 * @param hasmoved = Flag to check if the piece has moved before or not.
	 */
	public Bishop(Coordinate init, Side side, Boolean hasmoved)
	{
		super("Bishop", init, side, hasmoved);
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
		
		if (Math.abs(this.getCoord().getCoord_x() - dest.getCoord_x()) 
				== Math.abs(this.getCoord().getCoord_y() - dest.getCoord_y())) //Verify if movement is valid.
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
		int i, j;
		i = j = 0;
		
		if (orig.getCoord_x() < dest.getCoord_x() && orig.getCoord_y() < dest.getCoord_y()) //Diag down-right
		{
			while ((orig.getCoord_x() + i) < dest.getCoord_x() && (orig.getCoord_y() + j) < dest.getCoord_y())
			{
				i++;
				j++;
				coordinates.add( new Coordinate( (orig.getCoord_x() + i),(orig.getCoord_y() + j) ) );
			}
		}
		else
		{
			if (orig.getCoord_x() > dest.getCoord_x() && orig.getCoord_y() > dest.getCoord_y()) //Diag up-left
			{
				while ((orig.getCoord_x() + i) > dest.getCoord_x() && (orig.getCoord_y() + j) > dest.getCoord_y())
				{
					i--;
					j--;
					coordinates.add( new Coordinate( (orig.getCoord_x() + i),(orig.getCoord_y() + j) ) );
				}
			}
			else
			{
				if (orig.getCoord_x() < dest.getCoord_x() && orig.getCoord_y() > dest.getCoord_y()) //Diag down-left
				{
					while ((orig.getCoord_x() + i) < dest.getCoord_x() && (orig.getCoord_y() + j) > dest.getCoord_y())
					{
						i++;
						j--;
						coordinates.add( new Coordinate( (orig.getCoord_x() + i),(orig.getCoord_y() + j) ) );
					}
				}
				else
				{
					if (orig.getCoord_x() > dest.getCoord_x() && orig.getCoord_y() < dest.getCoord_y()) //Diag up-right
					{
						while ((orig.getCoord_x() + i) < dest.getCoord_x() && (orig.getCoord_y() + j) > dest.getCoord_y())
						{
							i--;
							j++;
							coordinates.add( new Coordinate( (orig.getCoord_x() + i),(orig.getCoord_y() + j) ) );
						}
					}
				}
			}
		}
		
		return coordinates;
	}
	
	/**
	 * @category Method
	 * 
	 */
	@Override
	protected Symbols defSymbol(Side side)
	{
		Symbols symbol;
		
		if (side == Side.WHITE) symbol = Symbols.W_Bishop;
		else symbol = Symbols.B_Bishop;
		
		return symbol;
	}
}