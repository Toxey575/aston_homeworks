package com.roma.bfg;

public class MyArrayListImpl<E> implements MyArrayList<E>{

    private static final int DEFAULT_SIZE = 10;

    private E[] elements;
    private int size;

    public MyArrayListImpl() {
        this.elements = (E[])new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public void add(E element) {
        if (isFull()) {
            resize();
        }

        this.elements[size] = element;
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index >= 0 && index < size) {
            if (isEmpty()) {
                this.add(element);
                return;
            }
            for (int i = size - 1; i > index; i--) {
                if (isFull()) {
                    resize();
                }
                this.elements[i + 1] = this.elements[i];
            }
            this.elements[index] = element;
            size++;
        }
    }

    @Override
    public void addAll(MyArrayList<? extends E> list) {
        if (!isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                this.add(list.get(i));
            }
        }
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        } else return null;
    }

    @Override
    public E set(int index, E element) {
        if (index >= 0 && index < size) {
            this.elements[index] = element;
        }

        return null;
    }

    @Override
    public int indexOf(E element) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (this.get(i).equals(element)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < size) {
            E target = this.elements[index];
            if (index == size - 1) {
                size--;
                return target;
            }
            for (int i = index + 1; i < size; i++) {
                this.elements[i - 1] = this.elements[i];
            }
            size--;
            return target;
        }
        return null;
    }

    @Override
    public E remove(E element) {
        if (!this.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (this.elements[i].equals(element)) {
                    E target = this.elements[i];
                    if (i == size - 1) {
                        size--;
                        return target;
                    }
                    for (int j = i + 1; j < size; j++) {
                        this.elements[j - 1] = this.elements[j];
                    }
                    size--;
                    return target;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        string.append("[");
        for (int i = 0; i < size; i++) {
            string.append(elements[i]);
            if (i == size - 1) break;
            string.append(", ");
        }
        string.append("]");

        return string.toString();
    }

    private void resize() {
        E[] oldElements = this.elements;

        this.elements =(E[])new Object[oldElements.length + oldElements.length / 2];
        for (int i = 0; i < size; i++) {
            this.elements[i] = oldElements[i];
        }
    }

    private boolean isFull() {
        return size == elements.length;
    }
}
