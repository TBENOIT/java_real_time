package tej.aspectj;

import javax.realtime.AbsoluteTime;
import javax.realtime.Clock;
import javax.realtime.RelativeTime;

public aspect TimedLogging {
	
	public volatile AbsoluteTime start_time, t_time ;
	RelativeTime delta_time;
	public volatile Clock clk = Clock.getRealtimeClock();
	
	pointcut capture(int Val):set(int tej.controller.Tache_Compteur.compteur) && args(Val) && withincode(void tej.controller.Tache_Compteur.run() );
	
    before():execution(void tej.controller.Tache_Compteur.run()) {
	start_time = clk.getTime();
	}
    
   // args 
	after(int Val ): capture(Val) {	
		t_time = clk.getTime();		
		delta_time = t_time.subtract(start_time);
		System.out.println("Pour la valeur compteur = "+Val+" Le temps ecoule est de "+delta_time);
	}	



//slide 39 event 
// System.exit(0);
// asyncevent(fire)
// if (buffer.equals() == ("put")
}
