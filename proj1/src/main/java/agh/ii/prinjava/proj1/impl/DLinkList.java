package agh.ii.prinjava.proj1.impl;

public class DLinkList<E> {
    // ...
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;
    }

    private Node first = null;
    private Node last = null;

    private int numOfElems = 0;
}
