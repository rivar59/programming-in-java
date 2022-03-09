package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {
    DLinkList<Integer> dLinkList = new DLinkList<>();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     *
     * Creating a list and test if it is empty
     *
     */
    @Test
    void newQueueIsEmpty() {
        DLinkList dl = new DLinkList();
        assertTrue(dl.isempty());
    }

    /**
     *
     * Creating a DLinklist and adding an element at the first position
     * Checking the number of elements
     *
     */
    @Test
    void pushFrontAndCount() {
        DLinkList dl = new DLinkList();
        dl.addFirst(5);
        assertEquals(1,dl.getNumOfElems());
    }

    /**
     *
     * Add one element in the front and remove it from the last position
     */
    @Test
    void pushFrontAndRemoveLast() {
        DLinkList dl = new DLinkList();
        dl.addFirst(5);
        int i = (int)dl.removeLast();
        dl.removeLast();
        assertEquals(5,i);
    }

    /**
     *
     * We push 3 elements and verify the number of elements
     * The last element is removed from the last position
     * Checking the number of elements
     *
     */
    @Test
    void pushFront3ElementsAndRemoveLast() {
        DLinkList dl = new DLinkList();
        dl.addFirst(5);
        dl.addFirst(4);
        dl.addFirst(3);
        assertEquals(3,dl.getNumOfElems());
        int i = (int)dl.removeLast();
        assertEquals(5,i);
        assertEquals(2,dl.getNumOfElems());
    }

    /**
     *
     * We push 3 elements and then remove them
     * Checking if the list is empty
     *
     */
    @Test
    void pushFront3ElementsAndRemoveall() {
        DLinkList dl = new DLinkList();
        dl.addFirst(5);
        dl.addFirst(4);
        dl.addFirst(3);
        System.out.println(dl.toString());
        dl.removeLast();
        dl.removeLast();
        dl.removeLast();
        assertTrue(dl.isempty());
    }

    /**
     *
     * We push an element in the back of the list and remove it from there
     *
     */
    @Test
    void pushBackandremoveLast() {
        DLinkList dl = new DLinkList();
        dl.addLast(5);
        int i = (int)dl.removeLast();
        assertEquals(5,i);
    }

    /**
     *
     * Peek first
     *
     */
    @Test
    void pushBackandPeekFirst() {
        DLinkList dl = new DLinkList();
        dl.addLast(5);
        assertEquals(5,dl.peekFirst());
    }

    /**
     *
     * Peek last
     *
     */
    @Test
    void pushBackandPeekLast() {
        DLinkList dl = new DLinkList();
        dl.addLast(5);
        assertEquals(5,dl.peekLast());
    }

    /**
     *
     * Peek with some elements
     *
     */
    @Test
    void pushTwoandPeek() {
        DLinkList dl = new DLinkList();
        dl.addLast(5);
        dl.addFirst(1);
        dl.addLast(0);
        assertEquals(0,dl.peekLast());
        assertEquals(1,dl.peekFirst());
    }


    /**
     *
     * We push in the back of the list and remove from it
     */
    @Test
    void pushBackandremoveFirst() {
        DLinkList dl = new DLinkList();
        dl.addFirst(5);
        int i = (int)dl.removeLast();
        assertEquals(5,i);
    }

    /**
     *
     * We see the String representation with full add last
     *
     */
    @Test
    void pushBack5ElementandPrint() {
        DLinkList dl = new DLinkList();
        dl.addLast(5);
        dl.addLast(10);
        dl.addLast(15);
        dl.addLast(20);
        dl.addLast(25);
        System.out.println(dl.toString());
    }

    /**
     *
     * Add some elements in different orders and see the String representation
     *
     */
    @Test
    void addelement() {
        DLinkList dl = new DLinkList();
        dl.addLast(5);
        dl.addLast(10);
        dl.addLast(15);
        dl.addLast(20);
        dl.addLast(25);
        dl.addFirst(1);
        dl.addFirst(3);
        dl.addFirst(4);
        dl.addFirst(5);
        dl.addFirst(0);
        dl.addLast(99);
        System.out.println(dl.toString());
        dl.removeLast();
        dl.removeFirst();
        dl.removeFirst();
        dl.removeLast();
        dl.removeLast();
        System.out.println(dl.getNumOfElems());
        System.out.println(dl.toString());
    }
}