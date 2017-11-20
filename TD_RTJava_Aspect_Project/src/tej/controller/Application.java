package tej.controller;
/** Just start a periodic thread with a one-second period.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.realtime.AsyncEvent;
import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;
import javax.realtime.Scheduler;
import javax.realtime.SchedulingParameters;


public class Application
{
	
  static String buffer = "";
	
  public static void main(String [] args)
  {
    SchedulingParameters scheduling =
        new PriorityParameters(PriorityScheduler.getMinPriority(null)+10); 
    
    ReleaseParameters releaseParam = new PeriodicParameters(
        new RelativeTime(), // Start at .start()
        new RelativeTime( 2000, 0), // PERIOD
        null, // COST
        new RelativeTime(700,0), //DEADLINE
        null, // no overrun handler
        null); // no miss handler
        
    RealtimeThread rtPeriodic= new Tache_Compteur(scheduling, releaseParam); 
             
    
    //Création de la tache apériodique 
    AsyncEvent currentTimeEv = new AsyncEvent();
    
    
    PriorityScheduler boss = PriorityScheduler.instance();
	Scheduler.setDefaultScheduler(boss);
	// pointcut capture (int val, )
	rtPeriodic.setScheduler(boss);

	if (boss.isFeasible()) {
		
		System.out.println("<Application>/ Jeu de taches ordonnancables ...");
		
		// Démarrage du thread
		rtPeriodic.start();

	}
	
	// Creation AEH
	KeyboardAEHHandler clavierHandler = new KeyboardAEHHandler();
	clavierHandler.setThread(rtPeriodic);
	
	currentTimeEv.addHandler(clavierHandler);

	

    InputStreamReader isr;
	BufferedReader br;

	while(true)
	{
	   	    
		try {
		 
		   isr=new InputStreamReader(System.in);
		   br=new BufferedReader(isr);
		   buffer = br.readLine();		      
		   System.out.println("Keyboard input received");
		   clavierHandler.setEntree(buffer);

		   currentTimeEv.fire();
		   
		  
		
		} catch (IOException ioe) { }
	}

    
//    try{
//    	rtPeriodic.join();
//    	
// 
//    }catch(Exception e){}; 
  
  }
}
