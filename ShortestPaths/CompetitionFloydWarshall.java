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
 * This class implements the competition using Floyd-Warshall algorithm
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CompetitionFloydWarshall {

    int sA, sB, sC;
    private  int N;
    private int S;
    private DirectedGraph graph;
    private  double[][] totalDist;

    /**
     * @param sA, sB, sC: speeds for 3 contestants
     * @param filename : A filename containing the details of the city road network
     */
    CompetitionFloydWarshall(String filename, int sA, int sB, int sC){
        this.sA = sA;
        this.sB = sB;
        this.sC = sC;
        String line;
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
                    totalDist = new double[graph.V][graph.V];
                    for(int i = 0; i < graph.V; i++) {
                        for(int j = 0; j < graph.V; j++) {
                            this.totalDist[i][j] = Double.POSITIVE_INFINITY;
                        }
                    }
                    while(scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        s = line.trim().split("\\s+");
                        int start = Integer.parseInt(s[0]);
                        int finish = Integer.parseInt(s[1]);
                        double weight = Double.parseDouble(s[2]);

                        this.totalDist[start][finish] = weight;
                        this.totalDist[start][start] = 0;
                    }
                }scanner.close();
            } catch (FileNotFoundException e) {
                this.graph = null;
            }
        }
    }


    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){
        if(graph == null) {
            return -1;
        }
        int SlowestSpeed;
        if (sA < sC && sA < sB) {
            SlowestSpeed = sA;
        } else if (sB < sC && sB < sA) {
            SlowestSpeed = sB;
        } else {
            SlowestSpeed = sC;
        }
        double maxDistance = 0.0;
        double[][] shortestPaths = floydWarshallAlgorithm();

        if ((sA > 100 || sA < 50) || (sB > 100 || sB < 50) || (sC > 100 || sC < 50))
            return -1;

        for(int i = 0; i < graph.V; i++) {
            for (int j = 0; j < graph.V; j++) {
                double d = shortestPaths[i][j];
                if (d == Double.POSITIVE_INFINITY) return -1;

                maxDistance = Math.max(maxDistance, d);
            }
        }
        return (int)Math.ceil(maxDistance * 1000 / SlowestSpeed);
    }




    public double[][] floydWarshallAlgorithm() {
        for(int x = 0; x < graph.V; x++) {
            for(int y = 0; y < graph.V; y++) {
                for(int z = 0; z < graph.V; z++) {
                    if(totalDist[y][x] + totalDist[x][z] < totalDist[y][z]) {
                        totalDist[y][z] = totalDist[y][x] + totalDist[x][z];
                    }
                }
            }
        }
        return totalDist;
    }

}