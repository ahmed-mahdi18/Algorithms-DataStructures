import java.util.*;
import java.io.*;

public class DirectedGraph {

   private static final String NEWLINE = System.getProperty("line.separator");

    public int V;                         // number of vertices in this digraph
    public int E;                      // number of edges in this digraph
    public HashMap<Integer,List<DirectedEdge>> adj; // adj[v] = adjacency list for vertex v*/


/**
 * Initializes an empty edge-weighted digraph with {@code V} vertices and 0 edges.
 *
 * @param  V the number of vertices
 * @throws IllegalArgumentException if {@code V < 0}
 */
    DirectedGraph(int V, int E) {
        this.V = V;
        this.E = E;
        this.adj = new HashMap<>();

    }

}















