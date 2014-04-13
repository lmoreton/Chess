/**
 * 
 */
package br.edu.metrocamp.chess.board;

import java.util.ArrayList;

import br.edu.metrocamp.chess.piece.Coordinate;
import br.edu.metrocamp.chess.piece.Piece;
import br.edu.metrocamp.chess.exceptions.*;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Ton
 * @category Class
 */
public class Board
{
	/**
	 * Constant to define the board size.
	 * @category Attribute
	 */
	public final int board_size = 8;
	
	private Piece[][] chessBoard = new Piece[board_size][board_size]; //This is the chess board, a matrix of pieces.
	
	/**
	 * @category Constructor
	 * @param pieceList = An ArrayList of pieces. 
	 */
	public Board(ArrayList<Piece> pieceList)
	{
		for (int x = 0; x < board_size; x++)
		{
			for (int y = 0; y < board_size; y++)
			{
				chessBoard[x][y] = null;
			}
		}
		
		for (Piece piece : pieceList)
		{
			chessBoard[piece.getCoord().getCoord_x()][piece.getCoord().getCoord_y()] = piece;
		}
	}
	
	/**
	 * @category Method
	 * @param coord = Coordinate type, containing 'x' and 'y' integers.
	 * @return Returns a piece(or null), on the requested coordinates of the chess board.
	 */
	public Piece getPiece(Coordinate coord)
	{
		return chessBoard[coord.getCoord_x()][coord.getCoord_y()];
	}
	
	/**
	 * @category Method (Overload)
	 * @param coord = Coordinate type, containing 'x' and 'y' integers.
	 * @return Returns a piece(or null), on the requested coordinates of the chess board.
	 */
	public Piece getPiece(int x, int y)
	{
		return chessBoard[x][y];
	}
	
	/**
	 * @category Method
	 * @param piece = A piece to be placed into the chess board.
	 * @param coord = A Coordinate type.
	 */
	public void setPiece(Piece piece, Coordinate coord)
	{
		chessBoard[coord.getCoord_x()][coord.getCoord_y()] = piece;
	}
	
	/**
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
				if (getPiece(i,j) == null)
				{
					System.out.print("   |");
				}
				else
				{
					System.out.print(" " + getPiece(i,j).getSymbol().toChar() + " |");
				}
			}
			
			System.out.println("");
			System.out.println("  |-------------------------------|");
		}
		
		System.out.println("    A   B   C   D   E   F   G   H  \n");
	}
	
	/**
	 * @category Method
	 * @param orig = Origin coordinate.
	 * @param dest = Destination coordinate.
	 * @return Returns a boolean for testing purpose.
	 */
	public boolean movePiece(Coordinate orig, Coordinate dest) throws ChessException
	{
		ArrayList<Coordinate> coordinates = chessBoard[orig.getCoord_x()][orig.getCoord_y()].movementValidator(dest, getPiece(dest));
		boolean test = checkPath(coordinates, orig, dest);
		
		if (test) //If the piece's movement AND path are OK, then move it!
		{
			chessBoard[dest.getCoord_x()][dest.getCoord_y()] = null;
			chessBoard[dest.getCoord_x()][dest.getCoord_y()] = getPiece(orig);
			chessBoard[orig.getCoord_x()][orig.getCoord_y()].setCoord(dest);
			chessBoard[orig.getCoord_x()][orig.getCoord_y()].setHasmoved(true);
			chessBoard[orig.getCoord_x()][orig.getCoord_y()] = null;
		}
		
		return test;
	}
	
	/**
	 * @category Method
	 * @param coordinates = ArrayList of Coordinate.
	 * @param orig = Origin coordinate.
	 * @param dest = Destination coordinate.
	 * @return Returns a boolean for testing purpose.
	 */
	public boolean checkPath(ArrayList<Coordinate> coordinates, Coordinate orig, Coordinate dest) throws ChessPathException
	{
		boolean test = true;
		
		for (Coordinate aux : coordinates)
		{
			if (getPiece(aux) != null && getPiece(aux).getCoord() != dest)
			{
				test = false;
				throw new ChessPathException();
			}
		}
		
		return test;
	}
}
