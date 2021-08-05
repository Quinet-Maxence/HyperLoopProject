package elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class is used to create the 'map' of our program, called 'Graph'. It
 * contains nodes and tracks. By creating a Graph value, the map is created,
 * which makes it possible to lighten the 'Main.java'.
 * 
 * @author Maxence QUINET, Adam AISSOU, Daoud BOUSRI
 *
 */

public class Graph {

	/**
	 * **********************************
	 * Fields
	 * **********************************
	 **/
	private List<Station> stationList;
	private List<Rail> railList;

	/**
	 * **********************************
	 * Constructor
	 * **********************************
	 **/
	public Graph() {

		stationList = new ArrayList<Station>();
		railList = new ArrayList<Rail>();

		/** Initialization of the Map with its stations & pods **/
		Station clervaux = new Station('A', "Clervaux Station", this);
		Station vianden = new Station('B', "Vianden Station", this);
		Station dierkich = new Station('C', "Dierkich Station", this);
		Station erpeldange = new Station('D', "Erpeldange Station", this);
		Station berdorf = new Station('E', "Berdorf Station", this);
		Station grevenmacher = new Station('F', "Grevenmacher Station", this);
		Station luxCity = new Station('G', "Luxembourg City Station", this);
		Station bous = new Station('H', "Bous Station", this);
		Station petange = new Station('I', "Petange Station", this);
		Station belval = new Station('J', "Belval Station", this);
		Station dudelange = new Station('K', "Dudelange Station", this);

		/** We add all of our stations in a list which stock all of them **/
		this.stationList.add(clervaux);
		this.stationList.add(vianden);
		this.stationList.add(dierkich);
		this.stationList.add(erpeldange);
		this.stationList.add(berdorf);
		this.stationList.add(grevenmacher);
		this.stationList.add(luxCity);
		this.stationList.add(bous);
		this.stationList.add(petange);
		this.stationList.add(belval);
		this.stationList.add(dudelange);

		/** We add all of our rails (edges) in a list which stock all of them **/
		addLane("Clervaux <-> Erpeldange", 0, 3, 75);
		addLane("Erpeldange <-> Clervaux", 3, 0, 75);
		ReentrantLock lock1 = new ReentrantLock();
		railList.get(0).setLock(lock1);
		railList.get(1).setLock(lock1);
		addLane("Erpeldange -> Dierkich", 3, 2, 15);
		addLane("Erpeldange -> Luxembourg City", 3, 6, 95);
		addLane("Dierkich -> Vianden", 2, 1, 20);
		addLane("Dierkich <-> Berdorf", 2, 4, 50);
		addLane("Berdorf <-> Dierkich", 4, 2, 50);
		ReentrantLock lock2 = new ReentrantLock();
		railList.get(5).setLock(lock1);
		railList.get(6).setLock(lock1);
		addLane("Dierkich -> Erpeldange ", 2, 3, 15);
		addLane("Vianden -> Dierkich", 1, 2, 20);
		addLane("Berdorf <-> Gravenmacher", 4, 5, 30);
		addLane("Gravenmacher <-> Berdorf", 5, 4, 30);
		ReentrantLock lock3 = new ReentrantLock();
		railList.get(9).setLock(lock1);
		railList.get(10).setLock(lock1);
		addLane("Gravenmacher -> Luxembourg City", 5, 6, 100);
		addLane("Luxembourg City -> Erpeldange", 6, 3, 95);
		addLane("Luxembourg City -> Gravenmacher", 6, 5, 100);
		addLane("Luxembourg City <-> Bous", 6, 7, 60);
		addLane("Luxembourg City <-> Bous", 7, 6, 60);
		ReentrantLock lock4 = new ReentrantLock();
		railList.get(14).setLock(lock1);
		railList.get(15).setLock(lock1);
		addLane("Luxembourg City -> Belval", 6, 9, 30);
		addLane("Belval -> Dudelange", 9, 10, 10);
		addLane("Belval -> Luxembourg City", 9, 6, 30);
		addLane("Belval -> Petange", 9, 8, 5);
		addLane("Dudelange -> Belval", 10, 9, 10);
		addLane("Petange -> Belval", 8, 9, 5);

	}

	/**
	 * **********************************
	 * Getters & Setters
	 * **********************************
	 **/
	public List<Station> getVertexes() {
		return stationList;
	}

	public List<Rail> getEdges() {
		return railList;
	}

	/**
	 * Function to quicken the rail creation
	 **/
	private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
		railList.add(new Rail(laneId, stationList.get(sourceLocNo), stationList.get(destLocNo), duration,this));
	}

}