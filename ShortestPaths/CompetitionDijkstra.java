/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

import java.io.*;
import java.util.*;

public class CompetitionDijkstra {

    int sA, sB, sC;
    private  int N;
    private int S;
    private DirectedGraph graph;


    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA,sB,sC: speeds for 3 contestants
     */
    CompetitionDijkstra(String filename, int sA, int sB, int sC) {
        this.sA = sA;
        this.sB = sB;
        this.sC = sC;

        String edge;
        String[] s;

        if(filename == null) {
            this.graph = null;
        } else  {
        try {
            Scanner scanner = new Scanner(new File(filename));
            N = Integer.parseInt(scanner.nextLine());
            S = Integer.parseInt(scanner.nextLine());
            if (N == 0 || S == 0) {
                this.graph = null;
            } else{
                this.graph = new DirectedGraph(N,S);
                while (scanner.hasNextLine()) {
                edge = scanner.nextLine();
                s = edge.trim().split("\\s+");
                int start = Integer.parseInt(s[0]);
                int finish = Integer.parseInt(s[1]);
                double weight = Double.parseDouble(s[2]);

                List<DirectedEdge> index = graph.adj.getOrDefault(start, new ArrayList<>());
                index.add(new DirectedEdge(start, finish, weight));
                graph.adj.put(start, index);
                }
            } scanner.close();
        } catch (FileNotFoundException e) {
            this.graph = null;
            }
        }
    }


    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition() {
        if(graph == null)
            return -1;
        int slowestSpeed;
        if (sA < sC && sA < sB) {
            slowestSpeed = sA;
        } else if (sB < sC && sB < sA) {
            slowestSpeed = sB;
        } else {
            slowestSpeed = sC;
        }

        double maximumDist = 0.0;
        int graphVertices = graph.V;

        if ((sA > 100 || sA < 50) || (sB > 100 || sB < 50) || (sC > 100 || sC < 50))
            return -1;

        for(int i = 0; i < graphVertices; i++) {
            double[] intervals = dijkstraAlgorithm(i);

            for (int j = 0; j < graphVertices; j++) {
                double distance = intervals[j];
                if (distance == Double.POSITIVE_INFINITY)
                    return -1;

                maximumDist = Math.max(maximumDist, distance);
            }
        }
        return (int)Math.ceil(maximumDist * 1000 / slowestSpeed);

    }


    public double[] dijkstraAlgorithm(int startVert) {
        boolean[] seenEdge = new boolean[graph.V];
        double[] distTo = new double[graph.V];
        PriorityQueue<Integer> PriorityQ = new PriorityQueue<>(Comparator.comparing(vertex -> distTo[vertex]));
        Map<Integer, List<DirectedEdge>> adj = graph.adj;

        for (int v = 0; v < distTo.length; v++)
            distTo[v] = Double.POSITIVE_INFINITY;

        distTo[startVert] = 0.0;
        PriorityQ.add(startVert);

        while (!PriorityQ.isEmpty()) {
            int currentVertex = PriorityQ.poll();
            seenEdge[currentVertex] = true;
            for (DirectedEdge borderingV : adj.getOrDefault(currentVertex, new ArrayList<>())) {
                int newNode = borderingV.dest;
                if (!seenEdge[newNode]) {
                    double newDist = distTo[currentVertex] + borderingV.weight;
                    if (newDist < distTo[newNode])
                        distTo[newNode] = newDist;
                    PriorityQ.remove(newNode);
                    PriorityQ.add(newNode);

                }
            }
        }
        return distTo;
    }












































}



















