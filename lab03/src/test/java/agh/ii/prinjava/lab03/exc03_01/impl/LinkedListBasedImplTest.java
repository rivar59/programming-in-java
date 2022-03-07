package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListBasedImplTest {

    // Create an empty queue
    private final QueueOfInts queueOfInts = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty());
    }

    @Test
    void testPushandPeeks01(){
        LinkedListBasedImpl q = new LinkedListBasedImpl();
        q.enqueue(1);
        assertEquals(1,q.peek());
        assertEquals(1,q.numOfElems());
    }

    @Test
    void testDequeue01(){
        LinkedListBasedImpl q = new LinkedListBasedImpl();
        q.enqueue(1);
        assertEquals(1,q.dequeue());
    }

    @Test
    void HardQueue(){
        LinkedListBasedImpl q = new LinkedListBasedImpl();
        for (int i = 0; i < 100; i++) {
            q.enqueue(i);
        }
        int cpt = 0;
        while (!q.isEmpty()){
            assertEquals(cpt,q.dequeue());
            cpt++;
        }
    }

}
