package br.edu.metrocamp.chess.piece;

import java.util.ArrayList;

import br.edu.metrocamp.chess.exceptions.*;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Ton
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
		setName("Pawn");
		setSide(side);
		setHasmoved(hasmoved);
		setCoord(init);
		
		if (side == Side.WHITE) //Decision of piece's symbol.
		{
			setSymbol(Symbols.W_Pawn);
		}
		else
		{
			setSymbol(Symbols.B_Pawn);
		}
		
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
		
		if (getSide() == Side.WHITE)
		{
			if (( this.getHasmoved() == false 
					&& ( ( Math.abs(dest.getCoord_y() - this.getCoord().getCoord_y()) == 0 
					&& (this.getCoord().getCoord_x() - dest.getCoord_x() == 2 
					|| (this.getCoord().getCoord_x() - dest.getCoord_x() == 1 )) ) 
					|| ( Math.abs(dest.getCoord_y() - this.getCoord().getCoord_y()) == 1 
					&& this.getCoord().getCoord_x() - dest.getCoord_x() == 1 
					&& hasPiece != null ) ) )
					
					|| ( this.getHasmoved() != false 
					&& ( (Math.abs(dest.getCoord_y() - this.getCoord().getCoord_y()) == 0 
					&& (this.getCoord().getCoord_x() - dest.getCoord_x() == 1 )) 
					|| ( Math.abs(dest.getCoord_y() - this.getCoord().getCoord_y()) == 1 
					&& this.getCoord().getCoord_x() - dest.getCoord_x() == 1 
					&& hasPiece != null ) ) )) //Verify if movement is valid for a White Pawn.
			{
				if ( Math.abs(dest.getCoord_y() - this.getCoord().getCoord_y()) == 0 
						&& ((this.getCoord().getCoord_x() - dest.getCoord_x() == 2 && hasPiece == null) 
						|| ((this.getCoord().getCoord_x() - dest.getCoord_x() == 1  && hasPiece == null))))
				{
					throw new ChessPathException();
				}
				else
				{
					coordinates = new ArrayList<Coordinate>();
					coordinates = getCoordinates(coordinates,  this.getCoord(), dest);
				}
			}
			else //if it's not valid, throws a new exception.
			{
				throw new ChessPieceMovementException();
			}
		}
		else
		{
			if (( this.getHasmoved() == false 
					&& ( ( Math.abs(dest.getCoord_y() - this.getCoord().getCoord_y()) == 0 
					&& (dest.getCoord_x() - this.getCoord().getCoord_x() == 2 
					|| (dest.getCoord_x() - this.getCoord().getCoord_x() == 1 )) ) 
					|| ( Math.abs(dest.getCoord_y() - this.getCoord().getCoord_y()) == 1 
					&& dest.getCoord_x() - this.getCoord().getCoord_x() == 1 
					&& hasPiece != null ) ) )
					
					|| ( this.getHasmoved() != false 
					&& ( (Math.abs(dest.getCoord_y() - this.getCoord().getCoord_y()) == 0 
					&& (dest.getCoord_x() - this.getCoord().getCoord_x() == 1 )) 
					|| ( Math.abs(dest.getCoord_y() - this.getCoord().getCoord_y()) == 1 
					&& dest.getCoord_x() - this.getCoord().getCoord_x() == 1 
					&& hasPiece != null ) ) )) //Verify if movement is valid for a Black Pawn.
			{
				if ( Math.abs(dest.getCoord_y() - this.getCoord().getCoord_y()) == 0 
						&& ((dest.getCoord_x() - this.getCoord().getCoord_x() == 2 && hasPiece != null) 
						|| ((dest.getCoord_x() - this.getCoord().getCoord_x() == 1  && hasPiece != null))))
				{
					throw new ChessPathException();
				}
				else
				{
					coordinates = new ArrayList<Coordinate>();
					coordinates = getCoordinates(coordinates,  this.getCoord(), dest);
				}
			}
			else //if it's not valid, throws a new exception.
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
}