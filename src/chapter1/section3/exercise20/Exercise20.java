package chapter1.section3.exercise20;

import edu.princeton.cs.algs4.StdOut;

public class Exercise20 {
    public static class LinkedList<Item> {
        private class Node {
            Item item;
            Node next;
            Node previous;
        }

        private Node first;
        private int N;

        public void addFirst(Item i) {
            Node newFirst = new Node();
            newFirst.item = i;
            newFirst.next = first;
            if (first != null)
                first.previous = newFirst;
            first = newFirst;
            N += 1;
        }

        // Take the element pointed by first as the first element
        public Item delete(int k) throws Exception {
            if (!(k < N))
                throw new Exception("Out of bounds");
            Node i = first;
            while (k > 0) {
                i = i.next;
                k -= 1;
            }
            Node previous = i.previous;
            Node next = i.next;
            Item item = i.item;
            if (previous == null) {
                // Delete first item
                i.next = null;
                next.previous = null;
                first = next;
                return item;
            }
            if (next == null) {
                // Delete last item
                i.previous = null;
                previous.next = null;
                return item;
            }
            previous.next = next;
            next.previous = previous;
            return item;
        }

        @Override
        public String toString() {
            String s = "";
            Node i = first;
            while (i != null) {
                s = i.item + " " + s;
                i = i.next;
            }
            s = s.stripTrailing();
            return "LinkedList [" + s + "](first)@" + System.identityHashCode(this);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        l.addFirst("A");
        l.addFirst("B");
        l.addFirst("C");
        StdOut.println(l);
        int k = 1;
        StdOut.printf("Delete element at index %s%n", k);
        try {
            l.delete(k);
        } catch (Exception e) {
            StdOut.println(e);
        }
        StdOut.println(l);
    }
}
