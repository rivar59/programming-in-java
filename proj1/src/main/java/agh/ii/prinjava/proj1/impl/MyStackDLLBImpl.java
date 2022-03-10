package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

/**
 * FILO data
 * First in, Last out
 *
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
     * Pop the last element pushed in the stack in front of the List
     *
     * @return the popped element
     */
    @Override
    public E pop() {
        return elems.removeFirst();
    }

    /**
     * Push the element in the front of the list
     *
     * @param x element to be push
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     * Allow access to the number of elements in the stack
     *
     * @return number of elements
     */
    @Override
    public int numOfElems() {
        return elems.getNumOfElems();
    }

    /**
     * Allow knowing which element will be popped next time
     *
     * @return the data of the next element to be popped
     */
    @Override
    public E peek() {
        return elems.peekFirst();
    }
}
