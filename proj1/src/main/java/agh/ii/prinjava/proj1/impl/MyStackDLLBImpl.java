package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

/**
 * FILO
 * We will push element in the front of the DList
 * And pop element from the front of the Dlist
 *
 * @param <E> Generic type
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems;

    public MyStackDLLBImpl(){
        elems = new DLinkList<>();
    }

    /**
     * Take off the last element push in the stack
     *
     * @return the last element push
     */
    @Override
    public E pop() {
        return elems.removeFirst();
    }

    /**
     * Will push the element in the front of the list
     *
     * @param x element to be push
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     * get the number of current element in the Stack
     *
     * @return number of element
     */
    @Override
    public int numOfElems() {
        return elems.getNumOfElems();
    }

    /**
     * allow acces data to the first element of the stack
     *
     * @return the data of the next element to be pop
     */
    @Override
    public E peek() {
        return elems.peekFirst();
    }
}
