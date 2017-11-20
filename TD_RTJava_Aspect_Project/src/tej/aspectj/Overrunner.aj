package tej.aspectj;

import javax.realtime.RelativeTime;

public aspect Overrunner {

	RelativeTime DELAY_INC = new RelativeTime(200,0);
	RelativeTime delay= new RelativeTime (DELAY_INC);
	
	
	before():set(int tej.controller.Tache_Compteur.compteur) && withincode(void tej.controller.Tache_Compteur.run() ){
		ralentir();
	}
	
	// Traitement pour ralentir progressivement la t�che
	public void ralentir(){
		try {
			System.out.print("ralentir... \t");
			Thread.sleep(delay.getMilliseconds());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		delay.add(DELAY_INC,delay);		
	}

}