package com.epam.daria_ivanova2.task2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class ArraySet implements Collection {
    
    private Object[] array;
    
    public ArraySet() {
        array = new Object[0];
    }
    
    public int size() {
        return array.length;
    }
    
    public boolean isEmpty() {
        return array.length == 0;
    }
    
    public boolean contains(Object o) {
        for (Object object : array) {
            if (object.equals(o)) return true;
        }
        return false;
    }
    
    public Iterator iterator() {
        return null;
    }
    
    public Object[] toArray() {
        return array;
    }
    
    public boolean add(Object o) {
        if (!contains(o)) {
            Object[] temp = array;
            array = new Object[array.length + 1];
            System.arraycopy(temp, 0, array, 0, temp.length);
            array[array.length - 1] = o;
        }
        return false;
    }
    
    public boolean remove(Object o) {
        for(int i = 0; i<array.length; i++)
            if (Objects.equals(array[i], o)){
                Object[] temp = array;
                array = new Object[array.length-1];
                System.arraycopy(array, 0, temp, 0, i);
                System.arraycopy(array, i, temp, i+1, array.length-i);
            }
            return false;
    }
    
    public boolean addAll(Collection c) {
        return false;
    }
    
    public void clear() {
        array = new Object[0];
    }
    
    public boolean retainAll(Collection c) {
        return false;
    }
    
    public boolean removeAll(Collection c) {
        return false;
    }
    
    public boolean containsAll(Collection c) {
        return false;
    }
    
    public Object[] toArray(Object[] a) {
        return array;
    }
    
    public void setArray(Object[] array) {
        this.array = array;
    }
    
    public Object[] getArray() {
        return array;
    }
}
