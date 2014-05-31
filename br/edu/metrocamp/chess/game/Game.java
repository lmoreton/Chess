/**
 * 
 */
package br.edu.metrocamp.chess.game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
	private Deque<Jogada> jogadaStack;
	private Coordinate currentOrig;
	private Coordinate currentDest;
	private Boolean canUndo;
	
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
		currentOrig = new Coordinate();
		currentDest = new Coordinate();
		jogadaStack = new ArrayDeque<Jogada>();
		turn = Side.WHITE;
		canUndo = true;
		gameLoop();
	}
	
	/**
	 * This method contains the game's main loop and the gameplay logic.
	 * @category Method
	 */
	private void gameLoop()
	{
		Jogada jog = null;
		boolean checkmate = false;
		boolean didItWork = false;
		long turnCount = 0;
		
		do
		{
			try
			{
				didItWork = false;
				display();
				keyboardInput = readKeyboard.nextLine();
				
				didItWork = checkInput(keyboardInput);
				
				if (didItWork) { setCurrentCoords(keyboardInput.split(" ")); }
				
				jog = moveRealization();
				
				if (jog != null)
				{
					jogadaStack.push(jog);
					turnCount++;
					turn = defTurn(turnCount);
					canUndo = true;
				}
			}
			catch (ChessUndoException e)
			{
				turnCount--;
				turn = defTurn(turnCount);
				canUndo = false;
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
				jog = null;
				currentOrig = new Coordinate();
				currentDest = new Coordinate();
			}
		}
		while(!checkmate);
	}
	
	private Side defTurn(long x) {return Side.values()[(int) (x % 2)];}
	
	private void display()
	{
		clearConsole();
		System.out.println("\n");
		System.out.println("Examples of input:\n\"Enter your movement: <origin> <destination>\"" +
						   "\n\"Enter your movement: 2a 4a\"" +
						   "\n\"Enter your movement: undo\" --> If you regret your move, type in \"undo\" to make a wiser move!");
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
	
	/**
	 * This method check all possible illegal movements, if and only if none of them match, it'll call movePiece() method.
	 * @throws ChessException
	 */
	private Jogada moveRealization() throws ChessException
	{
		Jogada jog = null;
		
		if (currentOrig == currentDest) {throw new ChessSameCoordException();}
		else if (chessBoard.getPiece(currentOrig) == null) {throw new ChessNullCoordException();}
		else if (turn != chessBoard.getPiece(currentOrig).getSide()) {throw new ChessWrongTurnException();}
		else if (chessBoard.getPiece(currentDest) != null
				 && chessBoard.getPiece(currentOrig).getSide() 
				 == chessBoard.getPiece(currentDest).getSide()) {throw new ChessCannibalException();}
		
		else
		{
			jog = new Jogada(currentOrig, currentDest, chessBoard.getPiece(currentOrig), chessBoard.getPiece(currentDest), turn);
			chessBoard.movePiece(currentOrig, currentDest, null, false);
		}
		
		return jog;
	}
	
	private boolean checkInput(String input) throws ChessArgumentException, ChessUndoException, ChessException
	{
		boolean isOk = false;
		
		if (input == null) {throw new ChessArgumentException();}
		else if (input.isEmpty() || input.length() > 5) {throw new ChessArgumentException();}
		else if (input.equalsIgnoreCase("undo") && canUndo) {undo(); throw new ChessUndoException();}
		else if (input.equalsIgnoreCase("undo") && !canUndo) {throw new ChessCannotUndoException();}
		else if (input.indexOf(' ') < 0) {throw new ChessArgumentException();}
		else if (input.split(" ").length != 2) {throw new ChessArgumentException();}
		else
		{
			String[] strings = input.split(" ");
			
			for (String coord : strings)
			{
				if (coord.length() != 2) {throw new ChessArgumentException();}
				
				if ( (Board.board_size - Character.getNumericValue(coord.charAt(0))) < 0
					  || (Board.board_size - Character.getNumericValue(coord.charAt(0))) > 8
					  || (Character.getNumericValue(coord.charAt(1)) - Character.getNumericValue('a')) < 0
					  || (Character.getNumericValue(coord.charAt(1)) - Character.getNumericValue('a')) > 8)
				{
					throw new ChessArgumentException();
				}
			}
			
			isOk = true;
		}
		
		return isOk;
	}
	
	private void undo() throws ChessException
	{
		Jogada lastmove = null;
		
		if (jogadaStack.isEmpty() || jogadaStack == null) {throw new ChessJogStackException();}
		else
		{
			lastmove = jogadaStack.pop();
			 chessBoard.movePiece(lastmove.getDestCoord(), lastmove.getOrigCoord(), lastmove.getDestPiece(), true);
		}
	}
	
	private void setCurrentCoords(String[] coords)
	{
		int i = 1;
		
		for (String coord : coords)
		{
			if (i == 1) this.currentOrig.set(Board.board_size - Character.getNumericValue(coord.charAt(0)), Character.getNumericValue(coord.charAt(1)) - Character.getNumericValue('a'));
			else currentDest.set(Board.board_size - Character.getNumericValue(coord.charAt(0)), Character.getNumericValue(coord.charAt(1)) - Character.getNumericValue('a'));
			
			i++;
		}
	}
	
	private void newGame()
	{
		pieceList = new ArrayList<Piece>();
		
		pieceList.add(new Pawn(new Coordinate(1,0), Side.BLACK, false, true));
		pieceList.add(new Pawn(new Coordinate(1,1), Side.BLACK, false, true));
		pieceList.add(new Pawn(new Coordinate(1,2), Side.BLACK, false, true));
		pieceList.add(new Pawn(new Coordinate(1,3), Side.BLACK, false, true));
		pieceList.add(new Pawn(new Coordinate(1,4), Side.BLACK, false, true));
		pieceList.add(new Pawn(new Coordinate(1,5), Side.BLACK, false, true));
		pieceList.add(new Pawn(new Coordinate(1,6), Side.BLACK, false, true));
		pieceList.add(new Pawn(new Coordinate(1,7), Side.BLACK, false, true));
		pieceList.add(new Rook(new Coordinate(0,0), Side.BLACK, false, true));
		pieceList.add(new Knight(new Coordinate(0,1), Side.BLACK, false, true));
		pieceList.add(new Bishop(new Coordinate(0,2), Side.BLACK, false, true));
		pieceList.add(new Queen(new Coordinate(0,3), Side.BLACK, false, true));
		pieceList.add(new King(new Coordinate(0,4), Side.BLACK, false, true));
		pieceList.add(new Bishop(new Coordinate(0,5), Side.BLACK, false, true));
		pieceList.add(new Knight(new Coordinate(0,6), Side.BLACK, false, true));
		pieceList.add(new Rook(new Coordinate(0,7), Side.BLACK, false, true));
		//---------------------------------------------------------------
		pieceList.add(new Pawn(new Coordinate(6,0), Side.WHITE, false, true));
		pieceList.add(new Pawn(new Coordinate(6,1), Side.WHITE, false, true));
		pieceList.add(new Pawn(new Coordinate(6,2), Side.WHITE, false, true));
		pieceList.add(new Pawn(new Coordinate(6,3), Side.WHITE, false, true));
		pieceList.add(new Pawn(new Coordinate(6,4), Side.WHITE, false, true));
		pieceList.add(new Pawn(new Coordinate(6,5), Side.WHITE, false, true));
		pieceList.add(new Pawn(new Coordinate(6,6), Side.WHITE, false, true));
		pieceList.add(new Pawn(new Coordinate(6,7), Side.WHITE, false, true));
		pieceList.add(new Rook(new Coordinate(7,0), Side.WHITE, false, true));
		pieceList.add(new Knight(new Coordinate(7,1), Side.WHITE, false, true));
		pieceList.add(new Bishop(new Coordinate(7,2), Side.WHITE, false, true));
		pieceList.add(new Queen(new Coordinate(7,3), Side.WHITE, false, true));
		pieceList.add(new King(new Coordinate(7,4), Side.WHITE, false, true));
		pieceList.add(new Bishop(new Coordinate(7,5), Side.WHITE, false, true));
		pieceList.add(new Knight(new Coordinate(7,6), Side.WHITE, false, true));
		pieceList.add(new Rook(new Coordinate(7,7), Side.WHITE, false, true));
	}
}
