package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

/**
 * FIFO data
 * First in, First out
 *
 * We use the DLinkList as a corridor
 * We enqueue an element at the beginning of the DLinkList
 * We dequeue an element at the end of the DLinkList
 *
 * @param <E> Generic type
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems;

    public MyQueueDLLBImpl(){
        elems = new DLinkList<>();
    }

    /**
     * Add an element to the beginning of the DLinkList
     *
     * @param x : parameter added to the queue
     */
    @Override
    public void enqueue(E x) {
        elems.addFirst(x);
    }

    /**
     * Dequeue the first element which was enqueued
     *
     * @return the dequeued element
     */
    @Override
    public E dequeue() {
        return elems.removeLast();
    }

    /**
     * Allow access to the number of elements in the queue
     *
     * @return number of elements
     */
    @Override
    public int numOfElems() {
        return elems.getNumOfElems();
    }

    /**
     * Allow knowing which element will be enqueued next time
     *
     * @return the data of the next element to be enqueued
     */
    @Override
    public E peek() {
        return elems.peekLast();
    }
}
