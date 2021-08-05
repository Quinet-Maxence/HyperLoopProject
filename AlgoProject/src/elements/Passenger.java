package elements;

/**
 * This class represents passengers who are basic in one station, and who wish
 * to travel to another station through a pod.
 * 
 * @author Maxence QUINET, Adam AISSOU, Daoud BOUSRI
 *
 */

public class Passenger {

	// **********************************
	// Fields
	// **********************************
	private Station starting;
	private Station destination;
	private String name;

	// **********************************
	// Constructor
	// **********************************
	public Passenger(Station starting, Station destination, String name) {
		this.starting = starting;
		this.destination = destination;
		this.name = name;
	}

	// **********************************
	// Getter & Setter
	// **********************************
	public Station getStarting() {
		return starting;
	}

	public void setStarting(Station depart) {
		this.starting = depart;
	}

	public Station getDestination() {
		return destination;
	}

	public void setDestination(Station destination) {
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
