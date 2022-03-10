package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {
    MyQueue<Integer> queueOfInts = MyQueue.create();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Creating a list and test if it is empty
     */
    @Test
    void creation(){
        MyQueue<Integer> q = MyQueue.create();
        assertTrue(q.isEmpty());
    }

    /**
     *
     * Add an element to the list
     *
     */
    @Test
    void enqueue1element(){
        MyQueue<Integer> q = MyQueue.create();
        q.enqueue(10);
        assertEquals(1,q.numOfElems());
    }

    /**
     *
     * Add an element to the list and peek
     *
     */
    @Test
    void enqueue1andpeek(){
        MyQueue<Integer> q = MyQueue.create();
        q.enqueue(10);
        assertEquals(10,q.peek());
    }

    /**
     * Enqueue and dequeue one element
     */
    @Test
    void enqueue1andqeueue(){
        MyQueue<Integer> q = MyQueue.create();
        q.enqueue(10);
        assertEquals(10,q.peek());
        int a = (int) q.dequeue();
        assertEquals(10,a);
    }

    /**
     * Add enqueue and dequeue with test
     */
    @Test
    void hardqueue(){
        MyQueue<Integer> q = MyQueue.create();
        for (int i = 0; i < 50; i++) {
            q.enqueue(i);
            assertEquals(0,q.peek());
        }
        int add = 0;
        while (!q.isEmpty()){
            int ret = (int) q.dequeue();
            assertEquals(add,ret);
            add += 1;
        }
    }
}