

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {


    private Node first, last;
    private int N;

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class Node{
        Item item;
        Node next;
    }

    public Queue() {
        N = 0;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else          oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }
}
