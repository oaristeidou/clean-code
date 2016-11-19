package de.oaristeidou.cleancode;

import de.oaristeidou.cleancode.linkedList.LinkedList;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by odyssefs on 15.10.16.
 */
public class TestLinkedList {

    @Test
    public void testPush() {
        LinkedList linkedList = new LinkedList();
        linkedList.push(new String("Element 1"));
        linkedList.push(new String("Element 2"));
        linkedList.push(new String("Element 3"));
        linkedList.push(new String("Element 4"));
        linkedList.push(new String("Element 5"));

        System.out.println(linkedList);
        assertEquals(linkedList.length(), 5);
    }

    @Test
    public void testPushCase2() {
        LinkedList linkedList = new LinkedList();
        linkedList.push(new String("Element 1"));
        linkedList.push(new Integer(1));
        linkedList.push(new Double(4));
        linkedList.push(new Long(2));

        assertEquals(linkedList.length(), 4);
    }

    @Test
    public void testPrintLinkedList (){
        LinkedList linkedList = new LinkedList();
        linkedList.push(new String("Element 1"));
        linkedList.push(new String("Element 2"));
        linkedList.push(new String("Element 3"));
        linkedList.push(new String("Element 4"));
        linkedList.push(new String("Element 5"));

        linkedList.printLinkedList();
    }
}
