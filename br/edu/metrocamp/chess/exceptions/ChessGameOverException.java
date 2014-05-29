package br.edu.metrocamp.chess.exceptions;

/**
 * @author lucasmo
 *
 */
public class ChessGameOverException extends ChessException
{
	private static final long serialVersionUID = -3537957080665598648L;

	public ChessGameOverException()
	{
		super(	"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
				"\n		 #####" +
				"\n		 #     #    ##    #    #  ######" +
				"\n		 #         #  #   ##  ##  #" +
				"\n		 #  ####  #    #  # ## #  #####" +
				"\n		 #     #  ######  #    #  #" +
				"\n		 #     #  #    #  #    #  #" +
				"\n		  #####   #    #  #    #  ######" +
				"\n\n" +
				"\n		 #######                           ###" +
				"\n		 #     #  #    #  ######  #####    ###" +
				"\n		 #     #  #    #  #       #    #   ###" +
				"\n		 #     #  #    #  #####   #    #    #" +
				"\n		 #     #  #    #  #       #####" +
				"\n		 #     #   #  #   #       #   #    ###" +
				"\n		 #######    ##    ######  #    #   ###" +
				"\n\n");
	}
}
