
public class Flight {
private static int numFlights =0;
private String flightName, destination;
private String departureGate;
private String departureTime;
public Flight(String name, String destination, String gate, String time){
	this.flightName = name;
	this.destination = destination;
	this.departureGate = gate;
	this.departureTime = time;
	numFlights++;
}
public void finalize(){
	numFlights--;
}
public static int getNumFlights(){
	return numFlights;
}
public void printFlight(){
	System.out.println("Flight name: " + this.flightName);
	System.out.println("Destination: " + this.destination);
	System.out.println("Departure time: " + this.departureTime);
	System.out.println("Departure gate: " + this.departureGate);
	System.out.println();
}
public void changeDeptTime(String a){
	this.departureTime = a;
}
public void changeDeptGate(String a){
	this.departureGate = a;
}
}
