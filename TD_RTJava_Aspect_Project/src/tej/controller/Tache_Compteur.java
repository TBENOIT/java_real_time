package tej.controller;

import javax.realtime.*; 

public class Tache_Compteur extends RealtimeThread
{ 
 
  int compteur = 0;
  int cycle = 0;
  
  public Tache_Compteur(SchedulingParameters sched, ReleaseParameters release)
  {
    super(sched, release); 
  }
  
  public void run()
  {
	  
	  System.out.println("debut de la tache");
	  while(true)
	  {
		 do{
			 compteur++;
			 System.out.println("La valeur du compteur = "+compteur);
		 }while(waitForNextPeriod());
		  
		 System.out.println("Depassement ! ");
		  
		  if(++cycle>25){
			  	System.out.println("Temps trop grand");
			  	break;
		  }
		 
		  
	  }
		  
	  System.out.println("fin de la tache");
  } 
}

