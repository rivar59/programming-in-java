package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

public class LinkedListBasedImpl implements QueueOfInts {

    @Override
    public void enqueue(int x) {
        Node n = new Node(x,first,null);
        numOfElems++;

        if (first == null) {
            first = n;
            last = n;
            return;
        }
        else {
        first.prev = n;
        first = n;
        }
    }

    @Override
    public int dequeue() {
        if (last == null)
            throw new IllegalStateException("Queue is empty");
        int ret = last.elem;
        last = last.prev;

        numOfElems--;
        return ret;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        if (first == null)
            throw new IllegalStateException("Queue is empty");
        else
            return last.elem;
    }

    private static class Node {
        int elem;
        Node next;
        Node prev;

        public Node(int elem) {
            this.elem = elem;
        }

        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node first = null;
    private Node last = null;

    private int numOfElems = 0;
}
