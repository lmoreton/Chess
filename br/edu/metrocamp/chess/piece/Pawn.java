package br.edu.metrocamp.chess.piece;

import java.util.ArrayList;
import java.util.List;

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
	public Pawn(Coordinate init, Side side, Boolean hasmoved, Boolean isAlive)
	{
		super("Pawn", init, side, hasmoved, isAlive);
	}
	
	/**
	 * @category Method
	 * @param dest = destination coordinate.
	 * @param hasPiece = to check if there is a piece on the destination or not.
	 * @return ArrayList of Coordinate.
	 */
	@Override
	public List<Coordinate> movementValidator(Coordinate dest, Piece hasPiece) throws ChessException
	{
		List<Coordinate> coordinates = null;
		
		if ( Math.abs(this.getCoord().y() - dest.y()) == 0
			 && ( Math.abs(this.getCoord().x() - dest.x()) == 1
			 || ( Math.abs(this.getCoord().x() - dest.x()) == 2 
			 && this.getHasmoved() == false ) ) ) //Vertical verifications.
		{
			if ( this.getCoord().x() - dest.x() > 0 && this.getSide() == Side.WHITE) //Meaning it's a white pawn.
			{
				coordinates = getCoordinates(this.getCoord(), dest);
			}
			else
			{
				if (this.getCoord().x() - dest.x() < 0 && this.getSide() == Side.BLACK) //Meaning it's a black pawn.
				{
					coordinates = getCoordinates(this.getCoord(), dest);
				}
				else
				{
					throw new ChessPieceMovementException();
				}
			}
		}
		else
		{
			if ( Math.abs(this.getCoord().x() - dest.x())  == 1
				 && Math.abs(this.getCoord().y() - dest.y())  == 1
				 && hasPiece != null ) //Diagonal verifications.
			{
				if (this.getCoord().x() - dest.x() > 0 && this.getSide() == Side.WHITE) //Meaning it's a white pawn.
				{
					//OK, coordinates = null;
				}
				else
				{
					if (this.getCoord().x() - dest.x() < 0 && this.getSide() == Side.BLACK) //Meaning it's a black pawn.
					{
						//OK, coordinates = null;
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
	
	/** 
	 * Method: getCoordinates
	 * Purpose: Verify the positions the piece will assume on its way to the destination coordinate,
	 * 			add it to the coordinate list and then return the list with these coordinates.
	 */
	protected List<Coordinate> getCoordinates(Coordinate orig, Coordinate dest)
	{
		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		
		if (Math.abs(this.getCoord().x() - dest.x()) < 2) coordinates.add(dest);
		else if (this.getCoord().x() - dest.x() > 0)
		{
			coordinates.add(new Coordinate(this.getCoord().x() - 1, this.getCoord().y()));
			coordinates.add(dest);
		}
		else if (this.getCoord().x() - dest.x() < 0)
		{
			coordinates.add(new Coordinate(this.getCoord().x() + 1, this.getCoord().y()));
			coordinates.add(dest);
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
		
		if (side == Side.WHITE) symbol = Symbols.W_Pawn;
		else symbol = Symbols.B_Pawn;
		
		return symbol;
	}
}