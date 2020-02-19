package Adt;

public interface MyListADT<E> {
    void add(E item);

    E remove();

    int search(E item);

    void sort();

    void print();

}
