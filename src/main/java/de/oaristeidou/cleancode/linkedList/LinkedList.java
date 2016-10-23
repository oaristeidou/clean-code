package de.oaristeidou.cleancode.linkedList;

import java.util.*;

/**
 * Created by odyssefs on 15.10.16.
 */
public class LinkedList<T>{
    Element<T> head;
    private int size = 0;

    public void push(T element) {
        // 1 & 2: Allocate the Element & Put in the data
        Element<T> newElement = new Element<>(element);

        // 3. Make next of new Element as head
        newElement.setNext(head);

        // 4. Move the head to point to new Element
        head = newElement;

        // 5. Increate the size by one
        size++;
    }

    public boolean delete(Element<T> element) {
        // Decrease the size by one
        size--;
        return true;
    }

    public int length() {
        return size;
    }

    public Element<T> getHead() {
        return head;
    }

    public void printLinkedList() {
        Element<T> printPointer = this.head;
        for (int i = 1; i <= length(); i++) {
            System.out.println(printPointer.getItem().toString());
            printPointer = printPointer.getNext();
        }
    }

}
