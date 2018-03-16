/**
 * @author Li Jingwei
 * Test graph
 */
public class TestGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Graph 1:");
		
		// Define the variable.
		UndirGraph<String> undir = new UndirGraph<>();
		
		undir.add2("F", "H");
		undir.connectAdd("F", "E");
		undir.connectAdd("F", "G");
		undir.connectAdd("G", "B");
		undir.connectAdd("E", "A");
		undir.connect2("B", "A");
		undir.connectAdd("A", "C");
		undir.connectAdd("B", "D");
		undir.connect2("D", "C");

		System.out.println("Depth First Search:");
		undir.DFS("F");
		System.out.println("Breadth First Search");
		undir.BFS("F");
		
		System.out.println();
		
		undir = new UndirGraph<>();
		
		System.out.println("Graph 2:");
		
		undir.add2("A", "B");
		undir.connectAdd("A", "C");
		undir.connectAdd("C", "D");
		undir.connectAdd("C", "F");
		undir.connectAdd("C", "G");
		undir.connect2("F", "G");
		undir.connectAdd("G", "H");
		undir.connectAdd("H", "E");

		System.out.println("Depth First Search:");
		undir.DFS("A");
		System.out.println("Breadth First Search");
		undir.BFS("A");
		
		System.out.println();
		
		undir = new UndirGraph<>();
		
		System.out.println("Graph 3:");
		
		undir.add2("A", "G");
		undir.connectAdd("A", "D");
		undir.connectAdd("G", "E");
		undir.connectAdd("E", "B");
		undir.connectAdd("D", "F");
		undir.connect2("B", "A");
		undir.connectAdd("F", "C");
		undir.connectAdd("C", "H");
		undir.connect2("B", "F");

		System.out.println("Depth First Search:");
		undir.DFS("A");
		System.out.println("Breadth First Search");
		undir.BFS("A");
		
		System.out.println();
		
		undir = new UndirGraph<>();
		
		System.out.println("Graph 4:");
		
		undir.add2("A", "B");
		undir.connectAdd("A", "C");
		undir.connectAdd("B", "D");
		undir.connectAdd("A", "E");
		undir.connectAdd("E", "F");
		undir.connect2("B", "C");
		undir.connectAdd("F", "G");
		undir.connectAdd("G", "H");

		System.out.println("Depth First Search:");
		undir.DFS("A");
		System.out.println("Breadth First Search");
		undir.BFS("A");
		
		System.out.println();
		
		undir = new UndirGraph<>();
		
		System.out.println("Graph 5:");
		
		undir.add2("A", "B");
		undir.connectAdd("B", "C");
		undir.connectAdd("B", "D");
		undir.connectAdd("B", "E");
		undir.connectAdd("D", "F");
		undir.connect2("C", "D");
		undir.connectAdd("E", "G");
		undir.connectAdd("G", "H");
		undir.connect2("E", "F");

		System.out.println("Depth First Search:");
		undir.DFS("A");
		System.out.println("Breadth First Search");
		undir.BFS("A");
		
		System.out.println();
		
		/**
		 * Output:
		 * Graph 1:
		 * Depth First Search:
		 * First vertex: [F]
		 * Vertex: [H]
		 * Vertex: [E]
		 * Vertex: [A]
		 * Vertex: [C]
		 * Vertex: [G]
		 * Vertex: [B]
		 * Vertex: [D]
		 * Breadth First Search
		 * First vertex: [F]
		 * Vertex: [H]
		 * Vertex: [E]
		 * Vertex: [G]
		 * Vertex: [A]
		 * Vertex: [B]
		 * Vertex: [C]
		 * Vertex: [D]
		 * 
		 * Graph 2:
		 * Depth First Search:
		 * First vertex: [A]
		 * Vertex: [B]
		 * Vertex: [C]
		 * Vertex: [D]
		 * Vertex: [F]
		 * Vertex: [G]
		 * Vertex: [H]
		 * Vertex: [E]
		 * Breadth First Search
		 * First vertex: [A]
		 * Vertex: [B]
		 * Vertex: [C]
		 * Vertex: [D]
		 * Vertex: [F]
		 * Vertex: [G]
		 * Vertex: [H]
		 * Vertex: [E]
		 * 
		 * Graph 3:
		 * Depth First Search:
		 * First vertex: [A]
		 * Vertex: [G]
		 * Vertex: [E]
		 * Vertex: [B]
		 * Vertex: [F]
		 * Vertex: [D]
		 * Vertex: [C]
		 * Vertex: [H]
		 * Breadth First Search
		 * First vertex: [A]
		 * Vertex: [G]
		 * Vertex: [D]
		 * Vertex: [E]
		 * Vertex: [F]
		 * Vertex: [B]
		 * Vertex: [C]
		 * Vertex: [H]
		 * 
		 * Graph 4:
		 * Depth First Search:
		 * First vertex: [A]
		 * Vertex: [B]
		 * Vertex: [D]
		 * Vertex: [C]
		 * Vertex: [E]
		 * Vertex: [F]
		 * Vertex: [G]
		 * Vertex: [H]
		 * Breadth First Search
		 * First vertex: [A]
		 * Vertex: [B]
		 * Vertex: [C]
		 * Vertex: [E]
		 * Vertex: [D]
		 * Vertex: [F]
		 * Vertex: [G]
		 * Vertex: [H]
		 * 
		 * Graph 5:
		 * Depth First Search:
		 * First vertex: [A]
		 * Vertex: [B]
		 * Vertex: [C]
		 * Vertex: [D]
		 * Vertex: [F]
		 * Vertex: [E]
		 * Vertex: [G]
		 * Vertex: [H]
		 * Breadth First Search
		 * First vertex: [A]
		 * Vertex: [B]
		 * Vertex: [C]
		 * Vertex: [D]
		 * Vertex: [E]
		 * Vertex: [F]
		 * Vertex: [G]
		 * Vertex: [H]
		 * 
		 * 
		 */
	}

}
