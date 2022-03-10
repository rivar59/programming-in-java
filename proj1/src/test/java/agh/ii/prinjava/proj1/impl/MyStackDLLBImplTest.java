package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();

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
        MyStack<Integer> s = MyStack.create();
        assertTrue(s.isEmpty());
    }

    /**
     *
     * Add on element to the Stack and check the number of elements
     *
     */
    @Test
    void enqueue1Element(){
        MyStack<Integer> s = MyStack.create();
        s.push(10);
        assertEquals(1,s.numOfElems());
    }

    /**
     *
     * Add on element to the Stack and peek it
     *
     */
    @Test
    void enqueue1andpeek(){
        MyStack<Integer> s = MyStack.create();
        s.push(10);
        assertEquals(10,s.peek());
    }

    /**
     * Push and pop one element
     */
    @Test
    void enqueue1andqeueue(){
        MyStack<Integer> s = MyStack.create();
        s.push(10);
        int a = (int) s.pop();
        assertEquals(10,a);
    }

    /**
     * Add enqueue and dequeue with test
     */
    @Test
    void hardqueue(){
        MyStack<Integer> s = MyStack.create();
        for (int i = 0; i < 50; i++) {
            s.push(i);
            assertEquals(i,s.peek());
        }
        int add = 49;
        assertEquals(49,s.peek());
        while (!s.isEmpty()){
            int ret = (int) s.pop();
            assertEquals(add,ret);
            add -= 1;
        }
    }
}