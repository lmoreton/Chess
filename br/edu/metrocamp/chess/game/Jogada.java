package br.edu.metrocamp.chess.game;

import br.edu.metrocamp.chess.piece.Coordinate;
import br.edu.metrocamp.chess.piece.Piece;
import br.edu.metrocamp.chess.piece.Side;

/**
 * The purpose of this class is to maintain a structured data of all elements used to make a move.
 * Only getters were made, because once a "Jogada" object is created, it's values won't be changed.
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class Jogada
{
	private Coordinate orig;
	private Coordinate dest;
	private Piece origin;
	private Piece destination;
	private Side turn;
	
	
	public Jogada(Coordinate orig, Coordinate dest, Piece origin, Piece destination, Side turn)
	{
		this.orig = orig;
		this.dest = dest;
		this.origin = origin;
		this.destination = destination;
		this.turn = turn;
	}
	
	public Coordinate getOrigCoord() {return this.orig;}
	public Coordinate getDestCoord() {return this.dest;}
	public Piece getOrigPiece() {return this.origin;}
	public Piece getDestPiece() {return this.destination;}
	public Side getTurn() {return this.turn;}
}
