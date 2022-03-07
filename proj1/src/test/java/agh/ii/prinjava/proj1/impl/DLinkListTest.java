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
     *Creating a list and test if this one is empty
     *
     */
    @Test
    void newQueueIsEmpty() {
        DLinkList dl = new DLinkList();
        assertTrue(dl.isempty());
    }

    /**
     *
     * Creating a dlist and adding an element at the first position
     * Checking the number of element
     *
     */
    @Test
    void pushFrontAndCount() {
        DLinkList dl = new DLinkList();
        dl.addFirst(5);
        assertEquals(1,dl.getNumOfElems());
    }

    /**
     *Add one lement in the front and remove from the last position
     *
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
     * We push 3 elements and verify the number of element
     * the last element remove from last position
     * the new number of element
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
     * We push 3 elements and remove this and see if the list is empty
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
     * We push in the back of the list and remove from it
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
     * We see the String represnetation with full add last
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
     * add some elements in different order and see the string representation
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
    }


}