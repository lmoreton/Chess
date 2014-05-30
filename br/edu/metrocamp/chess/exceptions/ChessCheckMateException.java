package br.edu.metrocamp.chess.exceptions;

/**
 * @author Lucas
 * @author Fabi
 * @author Vini
 * @author Marcos
 * @author Adailton
 * @category Class
 */
public class ChessCheckMateException extends ChessException
{
	private static final long serialVersionUID = -3537957080665598648L;

	public ChessCheckMateException ()
	{
		super(	"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
				"\n		 #####" +
				"\n		 #     #  #    #  ######   ####   #    #" +
				"\n		 #        #    #  #       #    #  #   #" +
				"\n		 #        ######  #####   #       ####" +
				"\n		 #        #    #  #       #       #  #" +
				"\n		 #     #  #    #  #       #    #  #   #" +
				"\n		  #####   #    #  ######   ####   #    #" +
				"\n\n" +
				"\n		 #     #" +
				"\n		 ##   ##    ##     #####  ######" +
				"\n		 # # # #   #  #      #    #" +
				"\n		 #  #  #  #    #     #    #####" +
				"\n		 #     #  ######     #    #" +
				"\n		 #     #  #    #     #    #" +
				"\n		 #     #  #    #     #    ######" +
				"\n" );
	}
}
