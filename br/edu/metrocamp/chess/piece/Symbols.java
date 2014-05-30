package br.edu.metrocamp.chess.piece;

/**
 * Symbols is an enumeration intend to map the symbols a piece can assume and provide a visual representation for it.
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Enum
 */
public enum Symbols
{
	W_Rook('t'), B_Rook('T'), W_Knight('h'), B_Knight('H'), W_Bishop('b'), B_Bishop('B'), 
	W_Queen('q'), B_Queen('Q'), W_King('k'), B_King('K'), W_Pawn('p'), B_Pawn('P');
	
	/**
	 * This method provides a visual representation for each symbol.
	 * @return char tochar
	 */
	public char toChar() {return toChar;}
	
	private final char toChar;
	
	private Symbols(char toChar)
	{
		this.toChar = toChar;
	}
}
