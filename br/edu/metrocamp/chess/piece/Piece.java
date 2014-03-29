package br.edu.metrocamp.chess.piece;


public abstract class Piece
{
	private String name; //piece name.
	private Side side; //piece side (white or black).
	private Symbols symbol; //piece symbol.
	private Coordinate coord; //current piece coordinate.
	private Boolean hasmoved; //if the piece never moved before, this will be false.
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Side getSide()
	{
		return side;
	}
	
	public void setSide(Side side)
	{
		this.side = side;
	}
	
	public Symbols getSymbol()
	{
		return symbol;
	}
	
	public void setSymbol(Symbols symbol)
	{
		this.symbol = symbol;
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
	
	public abstract Boolean movementValidator(Coordinate dest, Piece hasPiece);
}
