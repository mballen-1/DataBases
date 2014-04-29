package OperativeSystems;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import java.util.Scanner;



class Hilo extends UntypedActor{
	
	
	public static int saldo;

	 @Override

	 public void onReceive(Object message) throws Exception {

	 if(message instanceof int[] ) {

		
		 
		 	int [] opprueba = ((int []) message).clone();
		 	
		 	for (int i=0; i<opprueba.length; i++){
		 		
			saldo=saldo + opprueba[i];		
		
			}
			
			System.out.println("saldo" + saldo);

	

	 }

	 else{

	 unhandled(message);

	 }

	 }
	}


public class Mensajes {

	public static void main(String[] args) {
		
		
		
		Scanner lec= new Scanner(System.in);
		
		int opant= lec.nextInt();
		  int opblanca=lec.nextInt();
		  
		int op1[]=new int [opant];
		int op2[]=new int [opblanca];
		
		for (int i=0; i< op1.length; i++){			
			op1[i]=lec.nextInt();
			
		}
		

		for (int i=0; i< op2.length; i++){			
			op1[i]=lec.nextInt();
			
		}
		
		
		
		
		 ActorSystem system=ActorSystem.create( "something");

		 ActorRef Antonio = system.actorOf(new Props( Hilo.class));
		 
		 ActorRef Blanca = system.actorOf(new Props( Hilo.class));

		 Antonio.tell(op1,null);

		 Blanca.tell(op2,null);		

		 system.shutdown();

		 system.awaitTermination();//JOIN

		 }

		
	

}
