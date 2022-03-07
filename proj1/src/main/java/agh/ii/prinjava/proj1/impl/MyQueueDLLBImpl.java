package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

/**
 * FIFO data
 * First in, First out
 *
 * So we use the DlinkList as a corridor
 * We enqueue element at the beginning of the DlinkList
 * We dequeue element at the end of the DLinkList
 *
 * @param <E> Generic type
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems;

    public MyQueueDLLBImpl(){
        elems = new DLinkList<>();
    }

    /**
     *
     * Add an element to the beginning of the Dlist
     *
     * @param x parameter added to the queue
     */
    @Override
    public void enqueue(E x) {
        elems.addFirst(x);
    }

    /**
     * Dequeue the first element which was enqueued
     *
     * @return one element
     */
    @Override
    public E dequeue() {
        return elems.removeLast();
    }

    /**
     * Allow acces to the number of element in the queue
     *
     * @return number of element
     */
    @Override
    public int numOfElems() {
        return elems.getNumOfElems();
    }

    /**
     * allow to know which element will be enqueued next time
     *
     * @return the data of the next element to be enqueue
     */
    @Override
    public E peek() {
        return elems.peekLast();
    }
}
