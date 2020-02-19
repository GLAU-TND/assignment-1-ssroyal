package Definition;

import Adt.MyListADT;

public class MyList<E> implements MyListADT {
    private Node<E> head = null;
    private int size = 0;

    private Node<E> getNode(int index) {
        Node<E> response = head;
        for (int i = 0; i < index; i++) {
            response = response.getNext();

        }
        return response;

    }

    public void add(E item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            addFirst(item);
        } else {
            addafter(item, getNode(index - 1));
        }

    }

    public void addFirst(E item) {
        head = new Node(item, head);
        size++;
    }

    public void addafter(E item, Node<E> afternode) {
        afternode.next = new Node<>(item, afternode.next);
        size++;
    }

    @Override
    public void add(Object item) {

    }



    @Override
    public Object remove(Object item) {
        return null;
    }

    @Override
    public int search(Object item) {
        return 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public void print() {

    }


    private static  class Node<E>
    {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }
    }
}
