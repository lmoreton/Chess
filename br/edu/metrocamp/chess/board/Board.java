/**
 * 
 */
package br.edu.metrocamp.chess.board;

import java.util.List;

import br.edu.metrocamp.chess.piece.Coordinate;
import br.edu.metrocamp.chess.piece.Piece;
import br.edu.metrocamp.chess.exceptions.*;

/**
 * Board class defines a chess board and implements it's functions.
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class Board
{
	/**
	 * Constant to define the board size.
	 * @category Attribute
	 */
	public static final int BOARD_SIZE = 8;
	
	private Piece[][] chessBoard = new Piece[board_size][board_size]; //This is the chess board, a matrix of pieces.
	
	/**
	 * @category Constructor
	 * @param pieceList = An ArrayList of pieces. 
	 */
	public Board(List<Piece> pieceList)
	{
		Coordinate aux = new Coordinate();
		
		for (int x = 0; x < board_size; x++)
		{
			for (int y = 0; y < board_size; y++)
			{
				aux.set(x, y);
				setPiece(null, aux);
			}
		}
		
		for (Piece piece : pieceList) {setPiece(piece, piece.getCoord());}
	}
	
	/**
	 * @category Method
	 * @param coord = Coordinate type, containing 'x' and 'y' integers.
	 * @return Returns a piece(or null), on the requested coordinates of the chess board.
	 */
	public Piece getPiece(Coordinate coord) {return chessBoard[coord.x()][coord.y()];}
	
	/**
	 * @category Method (Overload)
	 * @param coord = Coordinate type, containing 'x' and 'y' integers.
	 * @return Returns a piece(or null), on the requested coordinates of the chess board.
	 */
	public Piece getPiece(int x, int y) {return chessBoard[x][y];}
	
	/**
	 * @category Method
	 * @param piece = A piece to be placed into the chess board.
	 * @param coord = A Coordinate type.
	 */
	public void setPiece(Piece piece, Coordinate coord) {chessBoard[coord.x()][coord.y()] = piece;}
	
	/**
	 * This method is used to literally 'draw' the chess board.
	 * @category Method
	 */
	public void draw()
	{
		System.out.println("  |-------------------------------|");
		
		for (int i = 0; i < board_size; i++)
		{
			System.out.print(board_size - i + " |");
			
			for (int j = 0; j < board_size; j++)
			{
				if (getPiece(i,j) == null) {System.out.print("   |");}
				else {System.out.print(" " + getPiece(i,j).getSymbol().toChar() + " |");}
			}
			
			System.out.println("");
			System.out.println("  |-------------------------------|");
		}
		
		System.out.println("    A   B   C   D   E   F   G   H  \n");
	}
	
	/**
	 * After couple of verifications, it moves the piece from Coordinate orig to Coordinate dest.
	 * @category Method
	 * @param orig = Origin coordinate.
	 * @param dest = Destination coordinate.
	 * @return Returns a boolean for testing purpose.
	 */
	public void movePiece(Coordinate orig, Coordinate dest, Piece aux, Boolean isUndo) throws ChessException
	{
		boolean test = false;
		
		if (aux == null && !isUndo)
		{
			List<Coordinate> coordinates = getPiece(orig).movementValidator(dest, getPiece(dest));
			test = checkPath(coordinates, orig, dest);
		}
		else
		{
			test = true;
		}
		
		if (test) //If the piece's movement AND path are OK, then move it!
		{
			if (getPiece(dest) != null && getPiece(dest).getName() == "King") throw new ChessCheckMateException();
			
			if (getPiece(dest) != null) { getPiece(dest).setIsAlive(false); }
			
			setPiece(null, dest);
			setPiece(getPiece(orig), dest);
			getPiece(orig).setCoord(dest);
			setPiece(aux, orig);
		}
	}
	
	/**
	 * @category Method
	 * @param coordinates = ArrayList of Coordinate.
	 * @param orig = Origin coordinate.
	 * @param dest = Destination coordinate.
	 * @return Returns a boolean for testing purpose.
	 */
	public boolean checkPath(List<Coordinate> coordinates, Coordinate orig, Coordinate dest) throws ChessPathException
	{
		boolean test = true;
		
		if (coordinates == null)
		{
			//Ok. Adjusted for Pawn diag movement.
		}
		else
		{
			for (Coordinate aux : coordinates)
			{
				if ( (getPiece(aux) != null && aux.toString().compareTo(dest.toString()) != 0)
					  || (getPiece(aux) != null && (aux.toString().compareTo(dest.toString()) == 0 && getPiece(orig).getName() == "Pawn") ) )
				{
					test = false;
					throw new ChessPathException();
				}
			}
		}
		
		return test;
	}
}
