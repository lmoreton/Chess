package br.edu.metrocamp.chess.piece;

import java.util.ArrayList;

import br.edu.metrocamp.chess.exceptions.*;


public abstract class Piece
{
	private String name; //piece name.
	private Side side; //piece side (white or black).
	private Symbols symbol; //piece symbol.
	private Coordinate coord; //current piece coordinate.
	private Boolean hasmoved; //if the piece never moved before, this will be false.
	
	/**
	 * 
	 * @param name
	 * @param init
	 * @param side
	 * @param hasmoved
	 */
	public Piece(String name, Coordinate init, Side side, Boolean hasmoved)
	{
		this.name = name;
		this.coord = init;
		this.side = side;
		this.symbol = defSymbol(side);
		this.hasmoved = hasmoved;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Side getSide()
	{
		return side;
	}
	
	public Symbols getSymbol()
	{
		return symbol;
	}
	
	public Coordinate getCoord()
	{
		return coord;
	}
	
	public void setCoord(Coordinate coord)
	{
		this.coord = coord;
	}
	
	public Boolean getHasmoved()
	{
		return hasmoved;
	}
	
	public void setHasmoved(Boolean hasmoved)
	{
		this.hasmoved = hasmoved;
	}
	
	public abstract ArrayList<Coordinate> movementValidator(Coordinate dest, Piece hasPiece) throws ChessException;
	
	protected abstract ArrayList<Coordinate> getCoordinates(Coordinate orig, Coordinate dest);
	
	protected abstract Symbols defSymbol(Side side);
}
