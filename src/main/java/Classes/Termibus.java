package Classes;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
//
//import BD.DBException;
//
//public class Termibus {
//	
//	public static void main(String[] args) throws DBException {
//		 
//		DB db = DB.getInstance();
//		
//		List<Trip> trips = new ArrayList<Trip>(db.getTrips());
//		int desOpt;
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("\tWelcome to Termibus Online:\n+-----------------------------------------+\n\t1 - Book a ticket\n\t2 - View trips\n\t3 - Exit\n");
//		
//		int option = sc.nextInt();
//		
//		switch(option) {
//		  case 1:
//		    System.out.println("\t      Book a ticket:\n+-----------------------------------------+\nDestiny:\n\n(Origin: Bilbao)\n");
//		    	for (int i = 0; i < trips.size(); i++) {
//					System.out.println(i + " - " + trips.get(i).getDestiny());
//				}
//		    	desOpt = sc.nextInt();
//		    	
//		    	if(desOpt > (trips.size() - 1)) {
//		    		System.out.println("Didnt work");
//		    		desOpt = sc.nextInt();
//		    	} else {
//		    		System.out.println(new Trip(
//		    				trips.get(desOpt).getDestiny(),
//		    				trips.get(desOpt).getDate(),
//		    				trips.get(desOpt).getBusID(),
//		    				trips.get(desOpt).getTripCode(),
//		    				trips.get(desOpt).getCost())
//		    				);
//		    	}
//		    	break;
//		  case 2:
//			  System.out.println("\t      View trips:\n+-----------------------------------------+\n");
//			  System.out.println(trips);
//			  
//		    break;
//		  case 3:
//			  System.out.println("\t      Thank you for your time!");
//			break;
//		  default:
//		    System.out.println("Something went wrong, please restart the application.");
//		}
//	}
//}
