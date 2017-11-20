// ****************KeyboardAEHHandler.java

package tej.controller;

import javax.realtime.*;

public class KeyboardAEHHandler extends AsyncEventHandler{

    RealtimeThread th;
    String entree;
  
    KeyboardAEHHandler () {
        super(new PriorityParameters(
              PriorityScheduler.instance().getMinPriority() + 10), null, null, null, null, null);   // à modifier éventuellement
    }
   
    public void handleAsyncEvent() {

        System.out.println("Keyboard Handler \t ");
	    System.out.println("Entree clavier = " + entree + "\t");
       
        if (entree.equals("QUIT")){
        	System.exit(0);
        }else{
        	System.out.println("La valeur entree est "+entree); 
        }
        
        
        
        
         
        // Permet la reprise de la tache preemptee (th) par ce AEH
        // Cas missHandler ou OverrunHandler par exemple
        th.schedulePeriodic(); // Let the thread continue
    }


	public void setThread(RealtimeThread th) {
        this.th = th;
    }

	void setEntree(String buffer) {
		entree=buffer;		
	}
   
    public String getEntree() {
		return entree;
	}

}
