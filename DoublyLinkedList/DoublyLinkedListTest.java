
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
    /**
     *  Test class for Doubly Linked List
     *
     *  @author: ahmed mahdi
     *  @version 13/10/16 18:15
     */
    @RunWith(JUnit4.class)
    public class DoublyLinkedListTest {
        //~ Constructor ........................................................
        @Test
        public void testConstructor() {
            new DoublyLinkedList<Integer>();
        }

        //~ Public Methods ........................................................

        // ----------------------------------------------------------

        /**
         * Check if the insertBefore works
         */
        @Test
        public void testInsertBefore() {
            // test non-empty list
            DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
            testDLL.insertBefore(0, 1);
            testDLL.insertBefore(1, 2);
            testDLL.insertBefore(2, 3);

            testDLL.insertBefore(0, 4);
            assertEquals("Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString());
            testDLL.insertBefore(1, 5);
            assertEquals("Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString());
            testDLL.insertBefore(2, 6);
            assertEquals("Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString());
            testDLL.insertBefore(-1, 7);
            assertEquals("Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString());
            testDLL.insertBefore(7, 8);
            assertEquals("Checking insertBefore to a list containing 7 elements at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString());
            testDLL.insertBefore(700, 9);
            assertEquals("Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString());

            // test empty list
            testDLL = new DoublyLinkedList<Integer>();
            testDLL.insertBefore(0, 1);
            assertEquals("Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString());
            testDLL = new DoublyLinkedList<Integer>();
            testDLL.insertBefore(10, 1);
            assertEquals("Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString());
            testDLL = new DoublyLinkedList<Integer>();
            testDLL.insertBefore(-10, 1);
            assertEquals("Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString());
        }

        @Test
        public void testReverse() {
            DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
            testDLL.insertBefore(0, 10);
            testDLL.insertBefore(1, 26);
            testDLL.insertBefore(2, 39);
            testDLL.insertBefore(3, 40);
            testDLL.insertBefore(4, 57);
            testDLL.reverse();
            assertEquals("57,40,39,26,10", testDLL.toString());

            testDLL = new DoublyLinkedList<Integer>();
            testDLL.insertBefore(0,3);
            testDLL.reverse();
            assertEquals("3", testDLL.toString());
        }

        @Test
        public void testMakeUnique()
        {
            DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
            testDLL.makeUnique();
            assertEquals("list containing 0 elements" , "", testDLL.toString());

            testDLL.insertBefore(0, 1);
            testDLL.insertBefore(1, 2);
            testDLL.insertBefore(2, 3);
            testDLL.insertBefore(3, 4);
            testDLL.insertBefore(4, 5);
            testDLL.insertBefore(5, 2);
            testDLL.makeUnique();
            assertEquals("1,2,3,4,5" , testDLL.toString());

            testDLL = new DoublyLinkedList<Integer>();
            testDLL.insertBefore(0,1);
            testDLL.insertBefore(1,2);
            testDLL.insertBefore(2,3);
            testDLL.insertBefore(3,4);
            assertEquals("1,2,3,4", testDLL.toString());

        }




        @Test
        public void testDeleteAt() {
            DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
            assertFalse(testDLL.deleteAt(0));

            testDLL.insertBefore(0, 13);
            assertTrue("1 element at position 0", testDLL.deleteAt(0));

            testDLL.insertBefore(0,1);
            testDLL.insertBefore(1,2);
            testDLL.insertBefore(2,3);
            testDLL.deleteAt(0);
            assertEquals( "2,3", testDLL.toString());
            assertTrue(true);

            testDLL = new DoublyLinkedList<Integer>();
            testDLL.insertBefore(0, 10);
            testDLL.insertBefore(1, 20);
            testDLL.insertBefore(2, 30);
            testDLL.insertBefore(3, 40);
            testDLL.insertBefore(4, 50);

            testDLL.deleteAt(1);
            assertEquals("10,30,40,50", testDLL.toString());
            assertFalse( testDLL.deleteAt(5));
            testDLL.deleteAt(0);
            assertEquals("30,40,50", testDLL.toString());
            testDLL.deleteAt(2);
            assertFalse(testDLL.deleteAt(-1));
            assertEquals("30,40", testDLL.toString());
        }

        @Test
        public void testGet() {
            DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
            testDLL.insertBefore(0, 1);
            testDLL.insertBefore(1, 2);
            testDLL.insertBefore(2, 3);
            assertEquals("position 0", "1", testDLL.get(0).toString());
            assertEquals("position 1", "2", testDLL.get(1).toString());
            assertEquals("position 2 ", "3", testDLL.get(2).toString());

            assertNull("position is out of bounds", testDLL.get(3));
            assertNull("negative position", testDLL.get(-2));
            assertNull("position is out of bounds", testDLL.get(50));

            testDLL = new DoublyLinkedList<Integer>();
            assertNull("list containing 0 elements", testDLL.get(0));
        }

        @Test
        public void testPush() {
            DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
            testDLL.push(1);
            testDLL.push(2);
            testDLL.push(3);
            assertEquals( "1,2,3", testDLL.toString());
        }


        @Test
        public void testPop() {
            DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
            testDLL = new DoublyLinkedList<Integer>();
            assertNull(testDLL.pop());

            testDLL.push(17);
            assertEquals(Integer.valueOf(17), testDLL.pop());
            assertEquals("", testDLL.toString());

            testDLL.push(10);
            testDLL.push(20);
            testDLL.push(30);
            assertEquals( Integer.valueOf(30),testDLL.pop());
            assertEquals( "10,20", testDLL.toString());

        }

        @Test
        public void testEnqueue() {
            DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
            testDLL.enqueue(1);
            testDLL.enqueue(2);
            testDLL.enqueue(3);
            assertEquals("1,2,3" , testDLL.toString());
        }

        @Test
        public void testDequeue() {
            DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();

            testDLL.enqueue(1);
            testDLL.enqueue(2);
            testDLL.enqueue(3);
            testDLL.enqueue(4);
            testDLL.dequeue();
            assertEquals(  "2,3,4", testDLL.toString() );
            testDLL.dequeue();
            assertEquals(  "3,4", testDLL.toString() );
            testDLL.dequeue();
            assertEquals( "4", testDLL.toString() );
            testDLL.dequeue();
            assertEquals(  "", testDLL.toString() );
            testDLL.dequeue();
            assertEquals( "dequeue with 0 elements", "", testDLL.toString() );

        }

        @Test
        public void testisEmpty() {
            DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
            assertTrue(testDLL.isEmpty());
            testDLL.insertBefore(0, 5);
            assertFalse(testDLL.isEmpty());
        }


    }





