package elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class includes the Dijkstra algorithm, which we use both to find the
 * shortest path for a pod, but also to find the adjacent stations of each
 * station for a possible pod request.
 * 
 * @author Maxence QUINET, Adam AISSOU, Daoud BOUSRI
 *
 */
public class DijkstraAlgorithm {

	/**
	 * **********************************
	 * Fields
	 * **********************************
	 **/
	private final List<Station> nodes;
	private final List<Rail> edges;
	private Set<Station> settledNodes;
	private Set<Station> unSettledNodes;
	private Map<Station, Station> predecessors;
	private Map<Station, Integer> distance;

	/**
	 * **********************************
	 * Constructor
	 * **********************************
	 * using our graph values for Stations & Rails
	 **/
	public DijkstraAlgorithm(Graph graph) {
		// create a copy of the array so that we can operate on this array
		this.nodes = new ArrayList<Station>(graph.getVertexes());
		this.edges = new ArrayList<Rail>(graph.getEdges());
	}

	/**
	 * **********************************
	 * Functions
	 * **********************************
	 **/

	/**
	 * Execute function is the main setup of the Djikstra algorithm
	 * @param source source station from which every route will be processed
	 */
	public void execute(Station source) {
		settledNodes = new HashSet<Station>();
		unSettledNodes = new HashSet<Station>();
		distance = new HashMap<Station, Integer>();
		predecessors = new HashMap<Station, Station>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		/**
		 * Node after node, it will process the minimal distance.
		 * after having processed a node, the node get stored in settledNodes hashSet
		 * while getting removed from unSettledNodes set
		 */
		while (unSettledNodes.size() > 0) {
			Station node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	/**
	 * Processing of minimal distances for each adjacent nodes
	 * this function, after having done the processing, will add new targets
	 * into the unSettledNodes hashSet until there is none remaining
	 **/
	private void findMinimalDistances(Station node) {
		List<Station> adjacentNodes = getNeighbors(node);
		for (Station target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	/**
	 * Check used to see if a node has been settled or not
	 **/
	private boolean isSettled(Station vertex) {
		return settledNodes.contains(vertex);
	}

	/**
	 * **********************************
	 * Getters & Setters
	 * **********************************
	 **/
	private int getDistance(Station node, Station target) {
		for (Rail edge : edges) {
			if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	/**
	 * This function allows you to add the neighbors that each Station owns.
	 * Checking all the rails that leave from the requested station, it takes the
	 * station of the destination of the rails and adds it to the List of neighbors
	 * of the starting station.
	 * @param node Node from which finding nearby stations
	 **/
	public List<Station> getNeighbors(Station node) {
		List<Station> neighbors = new ArrayList<Station>();
		for (Rail edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}

		for (Station station : neighbors) {
			node.neighborsList.add(station);
		}

		return neighbors;
	}

	private Station getMinimum(Set<Station> vertexes) {
		Station minimum = null;
		for (Station vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	/**
	 * getter of distance in between stations, from this to destination
	 * @param destination
	 * @return the distance between this. and destination station
	 */
	private int getShortestDistance(Station destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/**
	 * This method returns the path from the source to the selected target and NULL
	 * if no path exists
	 **/
	public LinkedList<Station> getPath(Station target) {
		LinkedList<Station> path = new LinkedList<Station>();
		Station step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

}