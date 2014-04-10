/**
 * 
 */
package br.edu.metrocamp.chess.game;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.metrocamp.chess.board.Board;
import br.edu.metrocamp.chess.piece.*;

/**
 * @author lucasmo
 *
 */
public class Game
{
	private ArrayList<Piece> pieceList = new ArrayList<Piece>();
	private Board chessBoard;
	private Side turn;
	private Scanner readKeyboard = new Scanner(System.in);
	//private Message message = new Message();
	
	public Game()
	{
		//pieceList = newGame();
		pieceList = newGame();
		chessBoard = new Board(pieceList);
		//print the game initial interface (?)
		gameGreetings();
		//be ready to receive commands from users (?)
		turn = Side.WHITE;
		gameLoop();
	}
	
	private void gameLoop()
	{
		boolean gameOver = false;
		String keyboardInput;
		do
		{
			clearConsole();
			display();
			keyboardInput = "";
			readKeyboard.next(keyboardInput);
			
		} while (!gameOver);
	}
	
	private void display()
	{
		chessBoard.draw();
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
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
	}
	
	private void gameGreetings()
	{
		System.out.println("      #  #####  #     # #######  #####   #####");
		System.out.println("      # #     # #     # #       #     # #     #");
		System.out.println("      # #       #     # #       #       #");
		System.out.println("      # #       ####### #####    #####   #####");
		System.out.println("#     # #       #     # #             #       #");
		System.out.println("#     # #     # #     # #       #     # #     #");
		System.out.println(" #####   #####  #     # #######  #####   #####");
		System.out.println("\n\n");
		System.out.print("Loading");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(".");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(".");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(".");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ArrayList<Piece> newGame()
	{
		ArrayList<Piece> pieceList = new ArrayList<Piece>();
		
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
		
		return pieceList;
	}
}
