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
     * add an element to the Queue
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
     * return the number of element of the Queue
     *
     *  @return number of element of the Queue
     */
    int numOfElems();

    /**
     * return the data of the next element to be dequeue
     *
     * @return data of the next element to be enqueue
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
