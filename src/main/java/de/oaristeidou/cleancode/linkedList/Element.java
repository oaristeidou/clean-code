package de.oaristeidou.cleancode.linkedList;

/**
 * Created by odyssefs on 15.10.16.
 */
public class Element<T> {
    private T item;
    private Element<T> next;

    public Element(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;

    }

    public void setItem(T item) {
        this.item = item;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }
}
