package com.roma.bfg;

public interface MyArrayList<E> {

    void add(E element);

    void add(int index, E element);

    void addAll(MyArrayList<? extends E> list);

    void clear();

    E get(int index);

    E set(int index, E element);

    int indexOf(E element);

    E remove(int index);

    E remove(E element);

    int size();

    boolean isEmpty();

}
