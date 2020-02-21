package Adt;

public interface MyListADT<E> {
    void add(E item);

    E remove();

    E getData(int index);


}
