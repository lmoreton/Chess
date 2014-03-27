package br.edu.metrocamp.chess.piece;

public abstract class Piece
{
	protected String name; //piece name.
	protected Side side; //piece side (white or black).
	protected Symbols symbol; //piece symbol.
	protected Coordinate coord; //current piece coordinate.
	protected Boolean hasmoved; //if the piece never moved before, this will be false.
	
	public Side getSide()
	{
		return side;
	}
	
	public Symbols getSymbol()
	{
		return symbol;
	}
	
	public String getPieceName()
	{
		return name;
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
	
	public void setHasmoved(Boolean bool)
	{
		hasmoved = bool;
	}
	
	public abstract Boolean movementValidator(Coordinate dest, Boolean dest_piece);
}
