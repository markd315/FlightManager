import java.util.Scanner;


public class FlightManager {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
	System.out.println("Creating first flight");
	Flight flight1 = createFlight();
	System.out.println("Creating second flight");
	Flight flight2 = createFlight();
	int entry = -1;
	while(entry != 5) {
		entry = mainMenu();
		switch(entry) {
		case 1:
			int sel = getSelection("Which flight would you like to print the info of (1 or 2)?");
			if(sel == 1)
			flight1.printFlight();
			if(sel == 2)
			flight2.printFlight();
			break;
		case 2:
			System.out.println("This is the number of flights: " + Flight.getNumFlights());
			break;
		case 3:
			sel = getSelection("Which flight would you like to change the departure time of (1 or 2)?");
			if(sel != 1 && sel != 2)
			break;
			System.out.println("What is the new departure time for flight " + sel + "?");
			String a = in.nextLine();
			if(sel == 1)
			flight1.changeDeptTime(a);
			if(sel == 2)
			flight2.changeDeptTime(a);
			break;
		case 4:
			sel = getSelection("Which flight would you like to change the departure gate of (1 or 2)?");
			if(sel != 1 && sel != 2)
			break;
			System.out.println("What is the new departure gate for flight " + sel + "?");
			a = in.nextLine();
			if(sel == 1)
			flight1.changeDeptGate(a);
			if(sel == 2)
			flight2.changeDeptGate(a);
			break;
		default:
			break;
		}
	}
	in.close();
	}

	private static int getSelection(String string) {
	System.out.println(string);
	int entry = -1;
	try {
		entry = Integer.parseInt(in.nextLine());
		if(entry > 2 || entry < 1)
		throw new NumberFormatException();
	} catch(Exception e) {
		System.out.println("Invalid Choice");
		entry = -1;
	}
	return entry;
	}

	private static int mainMenu() {
	System.out.println("Now what would you like to do?\n1.Print out a flight's info\n2.Print out the number of flights through the static variable.\n3.Change the departure time of a flight.\n4.Change the departure gate of a flight.\n5.Exit");
	int entry = -1;
	while(entry > 5 || entry < 1)
		try {
		entry = Integer.parseInt(in.nextLine());
		if(entry > 5 || entry < 1)
			throw new NumberFormatException();
		} catch(Exception e) {
		System.out.println("Invalid choice");
		System.out.println("Now what would you like to do?\n1.Print out a flight's info\n2.Print out the number of flights through the static variable.\n3.Change the departure time of a flight.\n4.Change the departure gate of a flight.\n5.Exit");
		entry = -1;
		}
	return entry;
	}

	private static Flight createFlight() {
	System.out.println("What is the name of the flight?");
	String name = in.nextLine();
	System.out.println("What is the destination of the flight?");
	String destination = in.nextLine();
	System.out.println("What is the departure time of the flight?");
	String time = in.nextLine();
	System.out.println("What is the departure gate of the flight?");
	String gate = in.nextLine();
	return new Flight(name, destination, gate, time);
	}
}
