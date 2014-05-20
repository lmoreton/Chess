package br.edu.metrocamp.chess.piece;

import java.util.ArrayList;

import br.edu.metrocamp.chess.exceptions.*;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public final class Pawn extends Piece
{
	
	/**
	 * @category Constructor
	 * @param init = Initial piece coordinate.
	 * @param side = Piece's side.
	 * @param hasmoved = Flag to check if the piece has moved before or not.
	 */
	public Pawn(Coordinate init, Side side, Boolean hasmoved)
	{
		super("Pawn", init, side, hasmoved);
	}
	
	/**
	 * @category Method
	 * @param dest = destination coordinate.
	 * @param hasPiece = to check if there is a piece on the destination or not.
	 * @return ArrayList of Coordinate.
	 */
	@Override
	public ArrayList<Coordinate> movementValidator(Coordinate dest, Piece hasPiece) throws ChessException
	{
		ArrayList<Coordinate> coordinates = null;
		
		if ( Math.abs(this.getCoord().getCoord_y() - dest.getCoord_y()) == 0
			 && ( Math.abs(this.getCoord().getCoord_x() - dest.getCoord_x()) == 1
			 || ( Math.abs(this.getCoord().getCoord_x() - dest.getCoord_x()) == 2 
			 && this.getHasmoved() == false ) ) ) //Vertical verifications.
		{
			if ( this.getCoord().getCoord_x() - dest.getCoord_x() > 0 && this.getSide() == Side.WHITE) //Meaning it's a white pawn.
			{
				coordinates = getCoordinates(coordinates, this.getCoord(), dest);
			}
			else
			{
				if (this.getCoord().getCoord_x() - dest.getCoord_x() < 0 && this.getSide() == Side.BLACK) //Meaning it's a black pawn.
				{
					coordinates = getCoordinates(coordinates, this.getCoord(), dest);
				}
				else
				{
					throw new ChessPieceMovementException();
				}
			}
		}
		else
		{
			if ( Math.abs(this.getCoord().getCoord_x() - dest.getCoord_x())  == 1
				 && Math.abs(this.getCoord().getCoord_y() - dest.getCoord_y())  == 1
				 && hasPiece != null ) //Diagonal verifications.
			{
				if (this.getCoord().getCoord_x() - dest.getCoord_x() > 0 && this.getSide() == Side.WHITE) //Meaning it's a white pawn.
				{
					//OK
				}
				else
				{
					if (this.getCoord().getCoord_x() - dest.getCoord_x() < 0 && this.getSide() == Side.BLACK) //Meaning it's a black pawn.
					{
						//OK
					}
					else
					{
						throw new ChessPieceMovementException();
					}
				}
			}
			else
			{
				throw new ChessPieceMovementException();
			}
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
		
		if ((dest.getCoord_x() - orig.getCoord_x()) == 2 
			&& Math.abs(dest.getCoord_y() - orig.getCoord_y()) == 0) //If its a black pawn moving 2 steps, then...
		{
			coordinates.add( new Coordinate( (orig.getCoord_x() + (i + 1)),(orig.getCoord_y() + j) ) );
		}
		else
		{
			if ((orig.getCoord_x() - dest.getCoord_x()) == 2 
				&& Math.abs(dest.getCoord_y() - orig.getCoord_y()) == 0) //If its a white pawn moving 2 steps, then...
			{
				coordinates.add( new Coordinate( (orig.getCoord_x() + (i - 1)),(orig.getCoord_y() + j) ) );
			}
			else
			{
				if (Math.abs(dest.getCoord_y() - orig.getCoord_y()) == 1 
						&& (orig.getCoord_x() - dest.getCoord_x() == 1 
						|| dest.getCoord_x() - orig.getCoord_x() == 1)) //Diagonal check, just add dest coord.
				{
					coordinates.add(dest);
				}
				else //If any pawn is moving just 1 step forward...
				{
					coordinates.add(dest);
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
		
		if (side == Side.WHITE)
		{
			symbol = Symbols.W_Pawn;
		}
		else
		{
			symbol = Symbols.B_Pawn;
		}
		
		return symbol;
	}
}