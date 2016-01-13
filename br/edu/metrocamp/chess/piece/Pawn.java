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
        bool isForward =  this.getCoord().y() == dest.y() && hasPiece == null 
            && (Math.abs(this.getCoord().x() - dest.x()) == 1
                || (Math.abs(this.getCoord().x() - dest.x()) == 2 
                        && this.getHasmoved() == false));

        bool isDiagonal =  Math.abs(this.getCoord().x() - dest.x())  == 1
            && Math.abs(this.getCoord().y() - dest.y())  == 1
            && hasPiece != null;

        if (isForward || isDiagonal)
        {
            if ((this.getSide() == Side.WHITE
                    && this.getCoord().x() - dest.x() > 0)
                    || (this.getSide() == Side.BLACK
                    && this.getCoord().x() - dest.x() < 0))
            {
                return getCoordinates(this.getCoord(), dest);
            }
        }
        throw new ChessPieceMovementException();
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
