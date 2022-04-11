import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() {

        // null file
        CompetitionDijkstra test = new CompetitionDijkstra(null, 90, 70, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        // invalid filename
        test = new CompetitionDijkstra("test", 70, 55, 96);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("input-J.txt", 70, 60, 75);
        assertEquals(-1, test.timeRequiredforCompetition());

        // less than 50
        test = new CompetitionDijkstra("input-A.txt", 45, 70, 90);
        assertEquals(-1, test.timeRequiredforCompetition());

        // greater than 100
        test = new CompetitionDijkstra("input-L.txt", 50, 70, 140);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("input-A.txt", 50, 30, 70);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("input-A.txt", 50, 80, 75);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("input-K.txt", 51, 70, 88);
        assertEquals(314, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("input-I.txt", 72, 70, 65);
        assertEquals(185, test.timeRequiredforCompetition());

        test = new CompetitionDijkstra("input-B.txt", 60, 80, 50);
        assertEquals(10000, test.timeRequiredforCompetition());

        //1000EWD.txt
        test = new CompetitionDijkstra("1000EWD.txt", 90, 60, 55);
        assertEquals(26, test.timeRequiredforCompetition());

        // tinyEWD.txt
        test = new CompetitionDijkstra("tinyEWD.txt", 90, 60, 75);
        assertEquals(31, test.timeRequiredforCompetition());


    }

    @Test
    public void testFWConstructor() {
        // null file
        CompetitionFloydWarshall test = new CompetitionFloydWarshall(null, 90, 70, 50);
        assertEquals(-1, test.timeRequiredforCompetition());

        // invalid filename
        test = new CompetitionFloydWarshall("test", 70, 55, 96);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("input-J.txt", 70, 60, 75);
        assertEquals(-1, test.timeRequiredforCompetition());

        // less than 50
        test = new CompetitionFloydWarshall("input-A.txt", 45, 70, 90);
        assertEquals(-1, test.timeRequiredforCompetition());

        // greater than 100
        test = new CompetitionFloydWarshall("input-A.txt", 50, 70, 140);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("input-L.txt", 50, 30, 70);
        assertEquals(-1, test.timeRequiredforCompetition());


        test = new CompetitionFloydWarshall("input-A.txt", 50, 80, 75);
        assertEquals(-1, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("input-K.txt", 51, 70, 88);
        assertEquals(314, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("input-I.txt", 72, 70, 65);
        assertEquals(185, test.timeRequiredforCompetition());

        test = new CompetitionFloydWarshall("input-B.txt", 60, 80, 50);
        assertEquals(10000, test.timeRequiredforCompetition());

        //1000EWD.txt
        test = new CompetitionFloydWarshall("1000EWD.txt", 90, 60, 75);
        assertEquals(24, test.timeRequiredforCompetition());

        // tinyEWD.txt
        test = new CompetitionFloydWarshall("tinyEWD.txt", 90, 60, 75);
        assertEquals(31, test.timeRequiredforCompetition());

    }

    // do tests

}
