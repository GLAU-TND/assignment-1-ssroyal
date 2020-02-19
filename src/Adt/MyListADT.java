package Adt;

public interface MyListADT<E> {
    void add(E item);

    E remove(E item);

    int search(E item);

    void sort();

    void print();

}
