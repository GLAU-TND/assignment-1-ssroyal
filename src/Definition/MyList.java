package Definition;

import Adt.MyListADT;

public class MyList<E> implements MyListADT<E> {
    private Node head = null;
    public int size = 0;

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

    private void addFirst(E item) {
        head = new Node(item, head);
        size++;
    }

    private void addafter(E item, Node<E> afternode) {
        afternode.next = new Node<>(item, afternode.next);
        size++;
    }

    @Override
    public void add(E item) {
        add(item, size);

    }

    private E removefirst() {
        Node<E> temp = head;
        E response = null;
        if (head != null) {
            head = head.getNext();
        }
        if (temp != null) {
            size--;
            response = temp.getData();

        }
        return response;
    }

    private E removeAfter(Node<E> afternode) {
        Node<E> temp = afternode.getNext();
        if (temp != null) {
            afternode.next = temp.getNext();
            size--;
        }
        E respone = temp.getData();
        return respone;
    }

    public E remove(int index) {
        E response = null;

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            response = removefirst();
        } else {
            Node<E> previousNode = getNode(index - 1);
            response = removeAfter(previousNode);
        }
        return response;
    }

    @Override
    public E remove() {
        return remove(size - 1);
    }

    @Override
    public E getData(int index) {
        return getNode(index).getData();
    }

    private static class Node<E> {
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
