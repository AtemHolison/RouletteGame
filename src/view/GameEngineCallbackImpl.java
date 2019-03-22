package view;


import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
	private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());
	   
   
   
   public GameEngineCallbackImpl()
   {
      // FINE shows wheel spinning output, INFO only shows result
	   logger.setUseParentHandlers(false);
	   logger.setLevel(Level.FINE);
      ConsoleHandler handler = new ConsoleHandler();
      // PUBLISH this level
      handler.setLevel(Level.FINE);
      logger.addHandler(handler);
      
   }

   @Override
   public void nextSlot(Slot slot, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
      //logger.log(Level.FINE, "Intermediate data to log .. String.format() is good here!");
      // TODO: complete this method to log intermediate results
      
      logger.log(Level.FINE,  "Next slot: " + slot.toString());
   }

   
   @Override
   public void result(Slot result, GameEngine engine)
   {
      // final results logged at Level.INFO
      logger.log(Level.INFO, "RESULT= " + result.toString());
      System.out.println("");
      logger.log(Level.INFO, "FINAL PLAYER POINT BALANCES" );
     
      String c = "";
      for(Player p : engine.getAllPlayers()) {
    	   c += p.toString() + "\n";
    	  }
      logger.log(Level.INFO , "\n" +  c   ) ;
      
      // TODO: complete this method to log results
   }
}
