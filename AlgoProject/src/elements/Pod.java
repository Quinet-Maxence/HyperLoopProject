package elements;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This class concerns the Pods of our simulation. It extends from the Thread
 * class, because each of them will do a small process
 *
 * @author Maxence QUINET, Adam AISSOU, Daoud BOUSRI
 **/

public class Pod extends Thread {

	// **********************************
	// Fields
	// **********************************
	private String name;
	private Station actualGare;
	private Station destinationGare;
	private List<Passenger> podPassengersList;
	private Graph graph;
	private Station stationQuery;
	private LinkedList<Rail> railPath = new LinkedList<Rail>();

	/**
	 ***********************************
	 Constructor
	 **********************************
	 * @param actualGare To setup the actual station
	 * @param graph The map in which the hyperloop network take place
	 * @param name  The Name of the pod
	 **/
	public Pod(Station actualGare, String name, Graph graph) {
		this.actualGare = actualGare;
		this.destinationGare = null;
		this.name = name;
		this.graph = graph;
		podPassengersList = new ArrayList<Passenger>();
		stationQuery = null;
	}
	/**
	 * **********************************
	* run() --> As the class extends Thread, it needs a run function to work proprely
	* @see Thread

	* This function works with a condition to check if the trip is requested by a client or
	* by a station, because the process will not be exactly the same depending on
	* the request.
	* **********************************
 	**/
	public void run() {

		if (stationQuery == null) {

			/**
			 * In our program, each pod uses its own Djikstra algorithm to process its path
			 */
			this.addPassengers();
			/** creation of djikstra object **/
			DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
			/** setup of djikstra depart station **/
			dijkstra.execute(graph.getVertexes().get(this.getActualGare().charToIndex(this.actualGare.getterId())));
			/** getter for a quick path towards destination **/
			LinkedList<Station> path = dijkstra.getPath(
					graph.getVertexes().get(this.getDestinationGare().charToIndex(this.destinationGare.getterId())));

			// If you want to see the stations through which the pod must pass during its
			// journey.
			// for (Station vertex : path) { System.out.println(vertex); }

			/**
			 *This piece of code usage is to setup the route by which the pod must travel to get to its destination
			 */

			for (int i = 0; i < (path.size() - 1); i++) {
				for (Rail rail : graph.getEdges()) {
					if (rail.getSource() == path.get(i) && rail.getDestination() == path.get(i + 1)) {
						railPath.add(rail);
					}
				}
			}

			// If you want to see the path use by the pod during his ride.
			// for (Rail railPath : railPath) { System.out.println(railPath.getId()); }

			System.out.println(this.name + " is about to leave.");
			try {
				this.ride();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.podComing();
			this.exitPassenger();
			this.interrupt();
		} 

	}

	/**
	 **********************************
	 Functions
	 **********************************

	 We assume that the customer at the top of the list was the first to arrive at
	 the ticket office. Because of this, since a pod works on demand, the pod's
	 destination is the same as that client.
	 **/

	public void searchDestination() {
		this.destinationGare = this.actualGare.getPassengerList().get(0).getDestination();
		Pod pod = new Pod(this.actualGare, this.name, this.graph);
		pod.setDestinationGare(pod.actualGare.getPassengerList().get(0).getDestination());
		this.interrupt();
		if (!this.actualGare.getPodList().isEmpty()) {
			this.actualGare.getPodList().remove(0);
		}
		pod.start();
	}
	

	/**
	 * This function searches for all the station customers who have the same
	 * destination as the 1st customer's pod, to optimize the number of trips. (A
	 * pod contains a maximum of 4 people)
	 **/
	public void addPassengers() {

		List<Passenger> tempo = new ArrayList<>();
		for (int i = 0; i < this.actualGare.getPassengerList().size(); i++) {

			if (this.destinationGare == this.actualGare.getPassengerList().get(i).getDestination()
					&& this.podPassengersList.size() < 4) {
				this.podPassengersList.add(this.actualGare.getPassengerList().get(i));
			} else {
				tempo.add(this.actualGare.getPassengerList().get(i));
			}

		}

		this.actualGare.getPassengerList().clear();
		this.actualGare.getPassengerList().addAll(tempo);

		/**
		 * You can uncomment this piece of comment to check if passengers are doing
		 * this route well: current station -> in the train.
		 * 
		 * System.out.println("Here are passenger travelling in the pod right now :"
		 * ); for (int i = 0; i < this.getPassagerTrainList().size(); i++) {
		 * System.out.println(this.getPassagerTrainList().get(i).getName()); }
		 * 
		 * System.out.println("Here are passagenr in the hyperloop station right now :");
		 * for (int i = 0; i < this.actualGare.getPassagerList().size(); i++) {
		 * System.out.println(this.actualGare.getPassagerList().get(i).getName()); }
		 **/

	}

	/**
	 * Because passenger will not stay all their lives in stations, we decided to
	 * simply remove them from the pod to simulate passenger leaving their station
	 **/

	public void exitPassenger() {
		if (!this.podPassengersList.isEmpty()) {
			this.podPassengersList.clear();
			System.out.println(" \n ---------------  The " + this.name + " arrived.");

		}
		System.out.println("  --- The " + this.name + " is now available. \n");

	}
	
	/**
	 * This function allows you to pass the pod from rail to rail, so that the
	 * result is realistic, and not a teleportation from station to station. The pod
	 * travel time is equivalent to: 10km = 1 second
	 **/
	public void ride() throws InterruptedException {
		for (Rail rail : railPath) {

			rail.takeRail();

			System.out.println(this.name + " is currently on the rail " + rail.getId());
			this.sleep(rail.getWeight() * 100);

			this.actualGare = rail.getDestination();
			System.out.println("The " + this.name + " arrived at: " + this.actualGare);
			rail.freeRail();
		}

	}

	/**
	 * This function setups the destination gare before coming
	 **/

	public void podComing() {
		this.setActualGare(destinationGare);
		this.getActualGare().getPodList().add(this);
		this.setDestinationGare(null);
	}

	/**
	 * Pod coming -> Pod query follow Up
	 * @see Station
	 * In case a Station calls for a pod in nearby station, here is the function that setup
	 * the departure for a pod, in order to to answer this calling
	 **/

	public void answerQuery(Station station) {
        this.setStationQuery(station);
        Pod pod = new Pod(this.actualGare, this.name, this.graph);
        pod.setDestinationGare(stationQuery);
        this.interrupt();
    	if (!this.actualGare.getPodList().isEmpty()) {
			this.actualGare.getPodList().remove(0);
		}
        pod.start();
    }


	/**
	 * 	**********************************
	 * 	 Getters & Setters
	 * 	**********************************
 	 */

	public Station getStationQuery() {
		return stationQuery;
	}

	public void setStationQuery(Station stationQuery) {
		this.stationQuery = stationQuery;
	}

	public Station getDestinationGare() {
		return destinationGare;
	}

	public void setDestinationGare(Station destinationGare) {
		this.destinationGare = destinationGare;
	}

	public List<Passenger> getPodPassengersList() {
		return podPassengersList;
	}

	public void setPodPassengersList(List<Passenger> passagerTrainList) {
		this.podPassengersList = passagerTrainList;
	}

	public Station getActualGare() {
		return actualGare;
	}

	public void setActualGare(Station gare) {
		this.actualGare = gare;
	}
	
	public String getterName() {
		return this.name;
	}

}
