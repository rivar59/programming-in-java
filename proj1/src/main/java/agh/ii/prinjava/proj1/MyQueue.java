package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

/**
 * Classic Queue implementation
 * FILO
 *
 * @param <E> Generic type
 */
public interface MyQueue<E> {
    /**
     * Add an element to the Queue
     *
     * @param x
     */
    void enqueue(E x);

    /**
     * Remove an element to the Queue
     *
     * @return E the element of the queue
     */
    E dequeue();

    /**
     * Return a boolean considering if the list is empty
     *
     * @return is the queue empty
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Return the number of elements of the Queue
     *
     *  @return number of elements of the Queue
     */
    int numOfElems();

    /**
     * Return the data of the next element to be dequeued
     *
     * @return data of the next element to be enqueued
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
