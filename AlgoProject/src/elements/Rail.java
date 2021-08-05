package elements;

import java.util.concurrent.locks.ReentrantLock;

/**
 * This class concerns the rails of our Graph. They allow you to link stations
 * together, and using a synchronized method, to do Multi-Threading with several
 * pods.
 * 
 * @author Maxence QUINET, Adam AISSOU, Daoud BOUSRI
 *
 */

public class Rail {

	/**
	 * **********************************
	 * Fields
	 * **********************************
	 **/
	private final String id;
	private final Station source;
	private final Station destination;
	private final int weight;
	private boolean isFree = true;
	private boolean bidirectionnal = false;
	private int nbPlaces = 1;
	Graph graph;
	private ReentrantLock lock;

	/**
	 * **********************************
	 * Constructor
	 * **********************************
	 **/

	public Rail(String id, Station source, Station destination, int weight, Graph graph) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.graph = graph;
	}

	/**
	 * **********************************
	 * Getters & Setters
	 * **********************************
	 **/

	public boolean getBidirectionnal() {
		return bidirectionnal;
	}

	public String getId() {
		return id;
	}

	public Station getDestination() {
		return destination;
	}

	public Station getSource() {
		return source;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return source + " " + destination;
	}

	/**
	 * Setup a lock to simulate a BIDIRECTIONNAL rail between this. and parameter a
	 *
	 * (We choosed this implementation for simplicity porpuse instead of creating a new type of rail with other charactersitics,
	 * because indeed our first idea was to create an inheritance from a abstract Rail class,
	 * the way we choosed was simple & effective enough to stay like that)
	 *
	 * @param a for the second rail that shares the BIDIRECTIONNAL characteristics
	 */

	public void setLock(ReentrantLock a){
		bidirectionnal = true;
		lock = a;
	}

	/**
	* **********************************
	* Method to synchronize the 'Pod' Threads so that they do not use the same rail
	* at the same time.
	 * @see Pod
	 *
	 * Bidirectionnal rail uses locks to block the travel
	 * while Unidirectionnal ones uses a synchronize for the same purpose.
	* **********************************
	 **/

	public void takeRail() {
		if (getBidirectionnal()) {
			lock.lock();
		}else{
		synchronized (this) {
			while (nbPlaces <= 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				nbPlaces = 0;
		}
		}
	}

	/**
	 * Frees the rail after usage from a pod
	 * @see Pod
	 */

	public void freeRail() {
		try{
			lock.unlock();
		} catch (NullPointerException e){

		}
		synchronized (this) {
			nbPlaces = 1;
			this.notify();

		}
	}

}
