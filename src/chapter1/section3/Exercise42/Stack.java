package chapter1.section3.exercise42;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Stack() {
    }

    public Stack(Stack<Item> s) {
        Stack<Item> tmp = new Stack<>();
        for (Item item : s) {
            tmp.push(item);
        }
        for (Item item : tmp) {
            push(item);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        return first.item;
    }

    @Override
    public String toString() {
        Node current = first;
        String s = "";
        while (current != null) {
            s = current.item + " " + s;
            current = current.next;
        }
        s = s.stripTrailing();
        return "Stack [" + s + "](top) @" + System.identityHashCode(this);
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");
        StdOut.println("s: " + s);

        Stack<String> t = new Stack<>(s);
        s.pop();
        s.pop();
        StdOut.println("s: " + s);
        StdOut.println("t: " + t);
    }
}
