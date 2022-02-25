package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class LinkedListBasedImpl implements StackOfInts {

    @Override
    public int pop() {
        if (numOfElems == 0)
            throw new IllegalStateException("POP emplty list !");

        Node ret = first;
        first = first.next;
        numOfElems--;

        return ret.elem;
    }

    @Override
    public void push(int x) {
        Node nod = new Node(x,first);
        first = nod;
        numOfElems++;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        if (numOfElems == 0)
            throw new IllegalStateException("POP emplty list !");
        return first.elem;
    }

    private static class Node {
        int elem;
        Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Node first = null;
    private int numOfElems = 0;
}
