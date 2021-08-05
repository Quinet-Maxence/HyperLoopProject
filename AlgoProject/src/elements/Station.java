package elements;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the stations of our simulation. It extends from the
 * Thread class, because each station will also have to do a little process in
 * case no Pod is available.
 * 
 * @author Maxence QUINET, Adam AISSOU, Daoud BOUSRI
 *
 */
public class Station extends Thread {

	/**
	 * **********************************
	 * Fields
	 * **********************************
	 *
	 * The station has a name, an id, a passenger waiting list, a list of waiting-to-go pods, and a list of nearby stations
	 **/
	final private char id;
	final private String name;
	private List<Passenger> passengerList = null;
	private List<Pod> podList = null;
	List<Station> neighborsList = null;
	private Graph graph;

	/**
	 * **********************************
	* Constructor
	 * **********************************
	 **/
	public Station(char idStation, String nameStation, Graph graph) {
		this.id = idStation;
		this.name = nameStation;
		this.passengerList = new ArrayList<>();
		this.podList = new ArrayList<>();
		this.neighborsList = new ArrayList<>();
		this.graph = graph;
	}

	/**
	* run() --> As the class extends Thread, it needs a run function to work proprely
	 * @see Thread
	 *
	 * The main
	 **/
	@Override
	public void run() {
		if (!this.getPassengerList().isEmpty()){

		while (!this.getPassengerList().isEmpty()) {
			DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph);
			dijkstraAlgorithm.execute(this);

			/*
			 * To see the list of neighboring stations for (Station station : neighborsList)
			 * { System.out.println(station); }
			 */

			this.searchPods(graph);
		}
			System.out.println("All passengers of the " + this.getterName() + " were taken away.");
		} else {
			System.out.println("There is no passenger that want to travel through this station");
		}
	}

	/**
	 * **********************************
	* Functions
	 * **********************************
	 **/

	/**
	 * SearchPods is the function that will call for a pod in any nearby station in case there is none at this one.
	 * @param graph the world where it is
	 */
	public void searchPods(Graph graph) {
		if (!podList.isEmpty()) {
			this.podList.get(0).searchDestination();
		} else {
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!passengerList.isEmpty()) {
				this.podQuery();
			}
		}
	}

	/**
	 * Ascii conversion of alphabet char to integers, starting by 0
	 * @param a
	 * @return a translation of the char id of the station to an integer fitting the graph list of stations
	 */
	public int charToIndex(int a) {
		return (this.getterId() - 65);
	}

	/**
	 * PodQuery is the mean for a station to call for a pod in nearby station
	 * it will check in neighborList for one free pod to bring here
	 */
	public void podQuery() {
		boolean trainFound = false;

		System.out.println(this.getterName() + " needs a pod.");

		try { // There is one possible error here about one case of Running configuration, but
				// it does not impact the programm itself
			for (Station station : neighborsList) {

				if (trainFound == false) {
					if (!station.getPodList().isEmpty()) {
						trainFound = true;
						System.out.println("Pod find");
						station.getPodList().get(0).answerQuery(this);
					}
				}
			}

		} catch (Exception e) {
		}
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	/**
	* **********************************
	* Getters & Setters
	* **********************************
	**/
	public List<Pod> getPodList() {
		return podList;
	}

	public char getterId() {
		return id;
	}

	public String getterName() {
		return name;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passagerList) {
		this.passengerList = passagerList;
	}

	public void setPodList(List<Pod> trainList) {
		this.podList = trainList;
	}

	public Graph getGraph() {
		return graph;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
}