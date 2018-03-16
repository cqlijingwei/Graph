
import java.util.*;

/**
 * This class implements a directed graph. An undirected grapph can be implemented
 * by subclassing this class. Weights may be attached to the edges by subclassing the
 * Neighbor class accordingly.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> The type of object used to represent vertices.
 */
public class DirGraph<T> {
	// Stack for DFS
	Stack<T> dfsStack;
	
	// Queue for linked list.
	LinkedList<T> bfsQueue;
	
	/**
	 * Array of Vertex instances (vertex info and adjacency list)
	 */
	protected ArrayList<Vertex<T>> adjlists;     
	
	// Visited list.
	ArrayList<T> visit;
	
	/**
	 * Initializes a new directed graph instance of default initial vertex capacity.
	 */
	public DirGraph() {
		adjlists = new ArrayList<Vertex<T>>();
	}
	
	/**
	 * Initializes a new directed graph instance of given initial vertex capacity.
	 * 
	 * @param vertexCap Initial capacity (number of vertices).
	 */
	public DirGraph(int vertexCap) {
		adjlists = new ArrayList<Vertex<T>>(vertexCap);
	}
	
	/**
	 * Returns the number of vertices in this graph.
	 * 
	 * @return Number of vertices in this graph.
	 */
	public int numberOfVertices() {
		return adjlists.size();
	}
	
	/**
	 * Adds a vertex to this graph.
	 * 
	 * @param vertex Vertex to be added.
	 * @return Number assigned to this vertex in the graph.
	 */
	public int addVertex(T vertex) {
		if (!containsVertex(vertex)) {
			adjlists.add(new Vertex<T>(vertex));
		}
		return adjlists.size() - 1;
	}
	
	/**
	 * Tells whether this graph contains a given vertex or not.
	 * 
	 * @param vertex Vertex to be searched for in this graph.
	 * @return True if the given vertex is in this graph, false otherwise.
	 */
	public boolean containsVertex(T vertex) {
		return adjlists.indexOf(new Vertex<T>(vertex)) != -1;
	}
	
	/**
	 * Returns the internal vertex number for the given vertex.
	 * 
	 * @param vertex Vertex for which internal number is needed.
	 * @return Internal number assigned to the given vertex, -1 if the vertex is not in this graph.
	 */
	public int vertexNumberOf(T vertex) {
		return adjlists.indexOf(new Vertex<T>(vertex));
	}
	
	/**
	 * Returns the client-supplied vertex information associated with a given internal vertex number.
	 * 
	 * @param vertexNumber Internal vertex number.
	 * @return Associated client-supplied vertex information.
	 */
	public T vertexInfoOf(int vertexNumber) {
		Vertex<T> v = adjlists.get(vertexNumber);
		return v.info;
	}
	
	/**
	 * Tells whether there is an edge from a given vertex (internal number) to another (neighbor).
	 * 
	 * @param vertexNumber Internal number of vertex.
	 * @param nbr Neighbor to which edge is sought.
	 * @return True if there is an edge, false otherwise.
	 */
	public boolean containsEdge(int vertexNumber, Neighbor nbr) {
		Vertex<T> v = adjlists.get(vertexNumber);
		return v.neighbors.contains(nbr);
	}
	
	/**
	 * Adds an edge from a given vertex (internal number) to another (neighbor). Note: If
	 * this vertex already has an edge to this neighbor, this method will return without
	 * doing anything. In other words, multiple edges are not supported.
	 * 
	 * @param vertexNumber Internal number of vertex.
	 * @param nbr Neighbor to which edge is added.
	 */
	public void addEdge(int vertexNumber, Neighbor nbr) {
		Vertex<T> fromVertex = adjlists.get(vertexNumber);
		if (!fromVertex.neighbors.contains(nbr)) {
			fromVertex.neighbors.add(nbr);
		}
	}
	
	/**
	 * Returns the first neighbor of a given vertex.
	 * 
	 * @param vertexNumber Internal number of vertex.
	 * @return First neighbor of given vertex, null if there are no neighbors.
	 */
	public Neighbor firstNeighbor(int vertexNumber) {
		Vertex<T> v = adjlists.get(vertexNumber);
		return v.neighbors.first();
	}
	
	/**
	 * Returns the next neighbor of a given vertex.
	 * 
	 * @param vertexNumber Internal number of vertex.
	 * @return Next neighbor of given vertex, relative to an earlier call to
	 * 			first() or or next(); null if end of neighbors list is reached.
	 */
	public Neighbor nextNeighbor(int vertexNumber) {
		Vertex<T> v = adjlists.get(vertexNumber);
		return v.neighbors.next();
	}
	
	/**
	 * Clears this graph of all vertices and edges.
	 */
	public void clear() {
		adjlists.clear();
	}
	
	/**
	 * Get the list of neighbors.
	 * @param vertex
	 * @return
	 */
	public List<Neighbor> neighbors(T vertex) {
		return this.adjlists.get(this.vertexNumberOf(vertex)).neighbors;
	}
	
	/**
	 * Get the element connected
	 * @param vertex
	 * @return
	 */
	public T connected(T vertex) {
		return this.vertexInfoOf(this.firstNeighbor(this.vertexNumberOf(vertex)).vertexNumber);
	}
	
	/**
	 * Connect two vertices.
	 * @param vertex1
	 * @param vertex2
	 */
	public void connect2(T vertex1, T vertex2) {
		// Define the number variables.
		int vertexN1 = this.vertexNumberOf(vertex1);
		int vertexN2 = this.vertexNumberOf(vertex2);
		
		// Define the neighbor variable.
		Neighbor neighbor = new Neighbor(vertexN2);
		
		// Connect vertices.
		Vertex<T> vertex = this.adjlists.get(vertexN1);
		vertex.neighbors.add(neighbor);	
	}
	
	/**
	 * Add two vertices
	 * @param vertex1
	 * @param vertex2
	 */
	public void add2(T vertex1, T vertex2) {
		// Define variables.
		int temp;
		Neighbor tempN;
		
		// Add vertices.
		temp = this.addVertex(vertex1);
		tempN = new Neighbor(temp);
		temp = this.addVertex(vertex2);
		this.addEdge(temp, tempN);
	}

	/**
	 * This method is to create one new vertex with given token, and connect with an old vertex
	 * @param oldVertexToken vertex one name
	 * @param newVertexToken vertex two name
	 */
	public void connectAdd(T vertex1, T vertex2) {
		// Get the values.
		int vertexN1 = this.vertexNumberOf(vertex1);
		Neighbor neighbor = new Neighbor(vertexN1);
		int vertexN2 = this.addVertex(vertex2);
		
		// Connect vertices.
		this.addEdge(vertexN2, neighbor);
	}

	/**
	 * Get the next vertex.
	 * @param original
	 * @return
	 */
	public T getNext(T original) {
		// Get the list and define the current vertex.
		List<Neighbor> neighborList = this.neighbors(original);
		Neighbor current = neighborList.first();
		
		// Loop until finding the first vertex not visited.
		while (current != null ) {
			T vertex = this.vertexInfoOf(current.vertexNumber);
			if (!this.visit.contains(vertex)) {
				return vertex;
			}
			current = neighborList.next();
		}
		return null;
	}
	
	/**
	 * Depth First Search.
	 * @param original
	 */
	public void DFS(T original) {
		// Initialize variables.
		this.dfsStack = new Stack<>();
		this.visit = new ArrayList<>();
		this.visit.add(original);
		this.dfsStack.push(original);

		// Print
		System.out.printf("First vertex: [%s]\n", original);
		
		// Get the connected vertex.
		T next = this.getNext(original);
		
		// Loop through every vertex.
		while ( !this.dfsStack.isEmpty() ) {
			if (next != null) {
				// Add remaining vertex to the stack.
				this.visit.add(next);
				this.dfsStack.push(next);
				
				// Print
				System.out.printf("Vertex: [%s]\n", next);
			}
			else {
				this.dfsStack.pop();
			}
			
			if (!this.dfsStack.isEmpty()) {
				next = this.getNext(this.dfsStack.peek());
			}			
		}
	}
	
	/**
	 * Breadth First Search
	 * @param original
	 */
	public void BFS(T original) {
		// Initialize the variables.
		this.visit = new ArrayList<>();
		this.bfsQueue = new LinkedList<>();
		this.visit.add(original);
		this.bfsQueue.add(original);
		
		// Print.
		System.out.printf("First vertex: [%s]\n", original);
		
		// Get the connected vertex.
		T next = this.getNext(original);
		
		// Loop through every connected vertex.
		while ( !this.bfsQueue.isEmpty()) {
			if (next != null) {
				// Add remaining vertex to the queue.
				this.visit.add(next);
				this.bfsQueue.add(next);
				
				// Print
				System.out.printf("Vertex: [%s]\n", next);
			}
			else {
				this.bfsQueue.removeAt(0);
			}
			
			if (!this.bfsQueue.isEmpty()) {
				next = this.getNext(this.bfsQueue.getAt(0));
			}
		}				
	}
}