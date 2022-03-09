package agh.ii.prinjava.proj1.impl;

public class DLinkList<E> {
    // ...

    public DLinkList(){

    }
    /**
     * Class Node with Generic Parameter
     * Allow the connexion between every element
     *
     * @param <T>
     */
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        /**
         * Class constructor
         *
         * @param elem
         */
        public Node(T elem) {
            this.elem = elem;
            this.next = null;
            this.prev = null;
        }

        /**
         * Override method
         *
         * Allow the representation of elem
         *
         * @return
         */
        @Override
        public String toString(){
            return elem.toString();
        }
    }

    /**
     * Pointer on the first and the last element of the list
     *
     */
    private Node first = null;
    private Node last = null;

    private int numOfElems = 0;

    /**
     * Return if the list is empty (symbolized by 0 number of elements)
     *
     * @return is the list empty ?
     */
    public boolean isempty(){
        return numOfElems == 0;
    }

    /**
     * Return the number of elements
     *
     * @return number of elements
     */
    public int getNumOfElems(){
        return numOfElems;
    }

    /**
     * Will add a node to the first position of the List
     * If the list is empty (symbolized by : first = null),
     * We update the last position too
     *
     * We increment the number of element and update the pointer of the Node
     *
     * @param e : The data added to the list
     */
    public void addFirst(E e){
        Node<E> n = new Node<>(e);
        n.next = first;
        if (first == null){
            last = n;
        }
        else{
            first.prev = n;
        }
        first = n;
        numOfElems++;
    }

    /**
     * Will add a node to the last position of the List
     * If the list is empty (symbolized by : last == null),
     * We update the first position too
     *
     * @param e : The data added to the list
     */
    public void addLast(E e){
        Node<E> n = new Node<>(e);
        n.prev = last;
        if (last == null){
            first = n;
        }
        else{
            last.next = n;
        }
        last = n;
        numOfElems++;
    }

    /**
     * Will return the data of the first element and delete it
     * If it's the last element of the list we update "last" to null too
     *
     * @return the data of the first elem
     */
    public E removeFirst(){
        if (isempty())
            return null;
        Node ret = first;
        if (first == last) {
            last = null;
            first = null;
        }
        else{
            first = first.next;
            first.prev = null;
        }

        numOfElems--;
        return (E)ret.elem;
    }

    /**
     * Will return the data of the last element and delete it
     * If it's the last element of the list we update "first" to null too
     *
     * @return the data of the last elem
     */
    public E removeLast(){
        if (isempty())
            return null;
        Node ret = last;
        if (last == first) {
            first = null;
            last = null;
        }
        else{

            last = last.prev;
            last.next = null;
        }
        numOfElems--;
        return (E)ret.elem;
    }

    /**
     * Create a representation of the List
     *
     * @return String representation of the List
     */
    @Override
    public String toString(){
        if (isempty())
            return "Linked list is Empty";

        String ret = "Linked list : \n";
        Node n = first;
        while(n.next != null){
            ret += n.toString() + " - ";
            n = n.next;
        }
        ret += n.toString();

        return ret;
    }

    /**
     * Allow the access to the data of the last element
     *
     * TODO : make a copy of this element to protect this
     *
     * @return the data of the last element
     */
    public E peekLast(){
        if(!isempty())
            return (E)last.elem;
        return null;
    }

    /**
     * Allow the access to the data of the first element
     *
     * TODO : make a copy of this element to protect this
     *
     * @return the data of the first element
     */
    public E peekFirst(){
        if (!isempty())
            return (E)first.elem;
        return null;
    }

}
