package br.edu.metrocamp.chess.piece;

import java.util.List;

import br.edu.metrocamp.chess.exceptions.*;

/**
 * Piece class is the superclass which provides the common base to all other specific pieces.
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Abstract Class
 */
public abstract class Piece
{
	private static int id; //ID to make each piece unique.
	private String name; //piece name.
	private Side side; //piece side (white or black).
	private Symbols symbol; //piece symbol.
	private Coordinate coord; //current piece coordinate.
	private Boolean hasmoved; //if the piece never moved before, this will be false.
	private Boolean isAlive; //True - if the piece is on the board/playing; False - if it has been eaten.
	
	/**
	 * 
	 * @param name
	 * @param init
	 * @param side
	 * @param hasmoved
	 */
	public Piece(String name, Coordinate init, Side side, Boolean hasmoved, Boolean isAlive)
	{
		this.name = name;
		this.coord = init;
		this.side = side;
		this.symbol = defSymbol(side);
		this.hasmoved = hasmoved;
		this.isAlive = isAlive;
		Piece.id += 1;
	}
	
	public int getID() {return id;}
	
	public String getName() {return this.name;}
	
	public Side getSide() {return this.side;}
	
	public Symbols getSymbol() {return this.symbol;}
	
	public Coordinate getCoord() {return this.coord;}
	
	public void setCoord(Coordinate coord) {this.coord = coord;}
	
	public Boolean getHasmoved() {return this.hasmoved;}
	
	public void setHasmoved(Boolean hasmoved) {this.hasmoved = hasmoved;}
	
	public Boolean getIsAlive() {return this.isAlive;}
	
	public void setIsAlive(Boolean isAlive) {this.isAlive = isAlive;}
	
	public abstract List<Coordinate> movementValidator(Coordinate dest, Piece hasPiece) throws ChessException;
	
	protected abstract List<Coordinate> getCoordinates(Coordinate orig, Coordinate dest);
	
	protected abstract Symbols defSymbol(Side side);
}
