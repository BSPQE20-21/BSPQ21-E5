import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Termibus {
	
	public static void main(String[] args) {
		
		List<Trip> trips = new ArrayList<Trip>();
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		int orOpt;
		int desOpt;
		
		trips.add(new Trip("Bilbao", "Madrid"));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\tWelcome to Termibus Online:\n+-----------------------------------------+\n\t1 - Book a ticket\n\t2 - View trips\n\t3 - Exit\n");
		
		int option = sc.nextInt();
		
		switch(option) {
		  case 1:
		    System.out.println("\t      Book a ticket:\n+-----------------------------------------+\n");
			  
		    	System.out.println("Origin:\n");
		    	for (int i = 0; i < trips.size(); i++) {
					System.out.println(i + " - " + trips.get(i).getOrigin());
					orOpt = sc.nextInt();
					
					System.out.println("Destiny:\n");
					System.out.println(i + " - " + trips.get(i).getDestiny());
					desOpt = sc.nextInt();
					
					
				}
		    	break;
		  case 2:
			  System.out.println("\t      View trips:\n+-----------------------------------------+\n");
			  
		    break;
		  case 3:
			  System.out.println("\t      Thank you for your time!");
			break;
		  default:
		    System.out.println("Something went wrong, please restart the application.");
		}
	}
	
	public void queryDB() {
		DB db = DB.getInstance();
	}
}
