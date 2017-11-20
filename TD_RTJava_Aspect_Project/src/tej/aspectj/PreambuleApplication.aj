package tej.aspectj;

public aspect PreambuleApplication {

	     // Coupe :
	     pointcut mainCall() :
	          execution(* tej..Application.main(..));
	    
	      before() : mainCall() {
	    	  System.out.println("<Aspect Preambule/> Hello RT world!");
	      }
	     	     
}
