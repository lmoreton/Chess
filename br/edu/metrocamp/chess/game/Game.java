/**
 * 
 */
package br.edu.metrocamp.chess.game;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.metrocamp.chess.board.Board;
import br.edu.metrocamp.chess.exceptions.*;
import br.edu.metrocamp.chess.piece.*;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Ton
 * @category Class
 */
public class Game
{
	private ArrayList<Piece> pieceList;
	private Board chessBoard;
	private Side turn;
	private Scanner readKeyboard;
	private String keyboardInput;
	private Jogada jog;
	
	/**
	 * @category Constructor
	 */
	public Game()
	{
		newGame(); //Initialize pieceList
		chessBoard = new Board(pieceList);
		gameGreetings();
		readKeyboard = new Scanner(System.in);
		keyboardInput = "";
		jog = new Jogada();
		turn = Side.WHITE;
		gameLoop();
	}
	
	private void gameLoop()
	{
		boolean checkmate = false;
		boolean didItWork;
		long turnCount = 0;
		
		do
		{
			try
			{
				display();
				keyboardInput = readKeyboard.nextLine();
				jog.generateMatrixCoord(keyboardInput);
				
				didItWork = moveRealization();
				
				if (didItWork)
				{
					turnCount++;
				}
				turn = Side.values()[(int) (turnCount % 2)];
				
				if (chessBoard.getPiece(jog.dest).getName() == "King") //Check if its 'checkmate'.
				{
					checkmate = true;
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		while(!checkmate);
	}
	
	
	private void display()
	{
		clearConsole();
		System.out.println("\n");
		chessBoard.draw();
		
		if (turn == Side.WHITE)
		{
			System.out.print("\nWhite turn: ");
		}
		else
		{
			System.out.print("\nBlack turn: ");
		}
	}
	
	private void clearConsole()
	{
		String os = System.getProperty("os.name");
		
		try
		{
			if (os.contains("Windows"))
			{
				Runtime.getRuntime().exec("cls");
			}
			else
			{
				Runtime.getRuntime().exec("clear");
			}
		}
		catch (Exception e)
		{
			System.out.println("Clear console failed, as per the error message below: \n\n" + e.getMessage());
		}
	}
	
	private void gameGreetings()
	{
		System.out.println("      #   #####  #     # #######  #####   #####"	);
		System.out.println("      #  #     # #     # #       #     # #     #"	);
		System.out.println("      #  #       #     # #       #       #"			);
		System.out.println("      #  #       ####### #####    #####   #####"	);
		System.out.println("#     #  #       #     # #             #       #"	);
		System.out.println("#     #  #     # #     # #       #     # #     #"	);
		System.out.println(" #####    #####  #     # #######  #####   #####"	);
		System.out.println("\n\n");
		System.out.print("Loading");
		
		try {
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".\n");
			
		} catch (InterruptedException e) {
			System.out.println("Something unexpected happened: \n\n" + e.getMessage());
		}
	}
	
	private void newGame()
	{
		pieceList = new ArrayList<Piece>();
		
		pieceList.add(new Pawn(new Coordinate(1,0), Side.BLACK, false));
		pieceList.add(new Pawn(new Coordinate(1,1), Side.BLACK, false));
		pieceList.add(new Pawn(new Coordinate(1,2), Side.BLACK, false));
		pieceList.add(new Pawn(new Coordinate(1,3), Side.BLACK, false));
		pieceList.add(new Pawn(new Coordinate(1,4), Side.BLACK, false));
		pieceList.add(new Pawn(new Coordinate(1,5), Side.BLACK, false));
		pieceList.add(new Pawn(new Coordinate(1,6), Side.BLACK, false));
		pieceList.add(new Pawn(new Coordinate(1,7), Side.BLACK, false));
		pieceList.add(new Rook(new Coordinate(0,0), Side.BLACK, false));
		pieceList.add(new Knight(new Coordinate(0,1), Side.BLACK, false));
		pieceList.add(new Bishop(new Coordinate(0,2), Side.BLACK, false));
		pieceList.add(new Queen(new Coordinate(0,3), Side.BLACK, false));
		pieceList.add(new King(new Coordinate(0,4), Side.BLACK, false));
		pieceList.add(new Bishop(new Coordinate(0,5), Side.BLACK, false));
		pieceList.add(new Knight(new Coordinate(0,6), Side.BLACK, false));
		pieceList.add(new Rook(new Coordinate(0,7), Side.BLACK, false));
		//---------------------------------------------------------------
		pieceList.add(new Pawn(new Coordinate(6,0), Side.WHITE, false));
		pieceList.add(new Pawn(new Coordinate(6,1), Side.WHITE, false));
		pieceList.add(new Pawn(new Coordinate(6,2), Side.WHITE, false));
		pieceList.add(new Pawn(new Coordinate(6,3), Side.WHITE, false));
		pieceList.add(new Pawn(new Coordinate(6,4), Side.WHITE, false));
		pieceList.add(new Pawn(new Coordinate(6,5), Side.WHITE, false));
		pieceList.add(new Pawn(new Coordinate(6,6), Side.WHITE, false));
		pieceList.add(new Pawn(new Coordinate(6,7), Side.WHITE, false));
		pieceList.add(new Rook(new Coordinate(7,0), Side.WHITE, false));
		pieceList.add(new Knight(new Coordinate(7,1), Side.WHITE, false));
		pieceList.add(new Bishop(new Coordinate(7,2), Side.WHITE, false));
		pieceList.add(new Queen(new Coordinate(7,3), Side.WHITE, false));
		pieceList.add(new King(new Coordinate(7,4), Side.WHITE, false));
		pieceList.add(new Bishop(new Coordinate(7,5), Side.WHITE, false));
		pieceList.add(new Knight(new Coordinate(7,6), Side.WHITE, false));
		pieceList.add(new Rook(new Coordinate(7,7), Side.WHITE, false));
	}
	
	private boolean moveRealization() throws ChessException
	{
		boolean bool;
		
		if (this.keyboardInput.length() > 5 || this.keyboardInput.isEmpty() || this.jog.orig == this.jog.dest)
		{
			bool = false;
			throw new ChessArgumentException();
		}
		else
		{
			if (this.turn != chessBoard.getPiece(jog.orig).getSide() 
				|| chessBoard.getPiece(jog.orig).getSide() != chessBoard.getPiece(jog.dest).getSide()
				|| chessBoard.getPiece(jog.orig) == null)
			{
				throw new ChessArgumentException();
			}
			else
			{
				bool = true;
			}
		}
		
		bool = chessBoard.movePiece(jog.orig, jog.dest);
		
		
		return bool;
	}
}
