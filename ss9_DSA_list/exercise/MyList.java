package ss9_DSA_list.exercise;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IndexOutOfBoundsException("Capcity: " + capacity);
        }
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("Index:" + index);
        } else if (elements.length == size) {
            this.ensureCapacity(DEFAULT_CAPACITY);
        }

        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index:" + index);
        }
        E temp = (E) elements[index];
        for (int i = index; i < elements.length - 2; i++) {
            elements[i] = elements[i + 1];
        }
        return temp;
    }


    public int size() {
        return this.size;
    }
    public MyList<E> clone () {
        MyList<E> newClone = new MyList<>();
        newClone.elements = Arrays.copyOf(this.elements, this.size);
        newClone.size = this.size;
        return newClone;
    }

    public boolean contains(E o) {
        boolean flag = false;
        for (int i = 0; i < elements.length; i++) {
            if (o.equals(this.elements[i])) {
                return flag = true;
            }
        }
        return flag;
    }


    public int indexOf(E o) {
        int index = -1;
        for (int i = 0; i < elements.length - 1; i++) {
            if (o.equals(this.elements[i])) {
                return i;
            }
        }
        return index;
    }

    public boolean add(E e) {
        if (elements.length == size) {
            this.ensureCapacity(DEFAULT_CAPACITY);
        }
        elements[size] = e;
        size++;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new IndexOutOfBoundsException("Min capacity: " + minCapacity);
        } else {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    public E get(int i) {
        return (E) elements[i];
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    @Override
    public String toString() {
        String elementList ="";
        for (int i = 0; i < elements.length; i++) {
            elementList += elements[i] + ", ";
        }
        return  elementList;
    }
}
