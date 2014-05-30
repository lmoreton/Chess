/**
 * 
 */
package br.edu.metrocamp.chess.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.metrocamp.chess.board.Board;
import br.edu.metrocamp.chess.exceptions.*;
import br.edu.metrocamp.chess.piece.*;

/**
 * Game class defines a chess game and it's components.
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class Game
{
	private List<Piece> pieceList;
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
	
	/**
	 * This method contains the game's main loop and the gameplay logic.
	 * @category Method
	 */
	private void gameLoop()
	{
		boolean checkmate = false;
		boolean didItWork = false;
		long turnCount = 0;
		
		do
		{
			try
			{
				display();
				keyboardInput = readKeyboard.nextLine();
				
				didItWork = jog.check(keyboardInput);
				
				if (didItWork) jog.set(keyboardInput.split(" "));
				
				didItWork = moveRealization();
				
				if (didItWork) turnCount++;
			}
			catch (ChessCheckMateException e)
			{
				System.out.println(e.getMessage());
				System.out.println(turn + " PIECE'S PLAYER WINS!!!!!");
				checkmate = true;
			}
			catch (ChessException e)
			{
				System.out.println("\n" + e.getMessage() + "\n****************************\n" + 
								   "Press ENTER to continue..." + "\n****************************\n");
				readKeyboard.nextLine();
			}
			finally
			{
				turn = Side.values()[(int) (turnCount % 2)];
				jog.setDefault();
			}
		}
		while(!checkmate);
	}
	
	
	private void display()
	{
		clearConsole();
		System.out.println("\n");
		System.out.println("Examples of input:\n\"Enter your movement: <origin> <destination>\"" +
						   "\n\"Enter your movement: 2a 4a\"");
		chessBoard.draw();
		
		if (turn == Side.WHITE) {System.out.print("\nWhite turn: ");}
		else {System.out.print("\nBlack turn: ");}
	}
	
	private void clearConsole()
	{
		//Dummy implementation to clear the screen, to be modified in the future(or not)! :D:D:D
		
		System.out.println(	"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
							"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
							"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
							"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" );
	}
	
	private void gameGreetings()
	{
		int i = 0;
		String tobesplitted = "| / -- \\";
		String[] strings = tobesplitted.split(" ");
		
		do
		{
			for (String loading : strings)
			{
				clearConsole();
				
				System.out.println("      #   #####  #     # #######  #####   #####"	);
				System.out.println("      #  #     # #     # #       #     # #     #"	);
				System.out.println("      #  #       #     # #       #       #"			);
				System.out.println("      #  #       ####### #####    #####   #####"	);
				System.out.println("#     #  #       #     # #             #       #"	);
				System.out.println("#     #  #     # #     # #       #     # #     #"	);
				System.out.println(" #####    #####  #     # #######  #####   #####"	);
				System.out.println("\n\n");
				System.out.print("Loading...");
				
				try
				{
					Thread.sleep(200);
					System.out.print(loading);
				}
				catch (InterruptedException e)
				{
					System.out.println("Something unexpected happened: \n\n" + e.getMessage());
				}
			}
			
			i++;
		}
		while (i < 5);
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
	
	/**
	 * This method check all possible illegal movements, if and only if none of them match, it'll call movePiece() method.
	 * @return
	 * @throws ChessException
	 */
	private boolean moveRealization() throws ChessException
	{
		boolean bool = false;
		
		if (jog.orig == jog.dest) {throw new ChessSameCoordException();}
		else if (chessBoard.getPiece(jog.orig) == null) {throw new ChessNullCoordException();}
		else if (turn != chessBoard.getPiece(jog.orig).getSide()) {throw new ChessWrongTurnException();}
		else if (chessBoard.getPiece(jog.dest) != null
				 && chessBoard.getPiece(jog.orig).getSide() 
				 == chessBoard.getPiece(jog.dest).getSide()) {throw new ChessCannibalException();}
		
		else {bool = chessBoard.movePiece(jog.orig, jog.dest);}
		
		return bool;
	}
}
