package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

/**
 * Classic Stack implementation and method
 *
 * @param <E> generic type
 */
public interface MyStack<E> {
    /**
     * Remove the last element pushed
     *
     * @return
     */
    E pop();

    /**
     * push an element which will be the next pop
     *
     * @param x
     */
    void push(E x);

    /**
     * Check if the Stack is empty
     *
     * @return true if the list is empty otherwise false
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Get the number of element in the list
     *
     * @return the number of element on the Stack
     */
    int numOfElems();

    /**
     *  Get the data of the top element of the Stack
     *
     * @return the data of the next element to be pop
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
