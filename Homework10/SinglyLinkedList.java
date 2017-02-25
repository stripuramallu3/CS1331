/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.util.Collection;
/**
 * The SinglyLinkedList interface defines a set of standard operations that are
 * typically associated with singly linked list, such as adding, removing, and
 * checking to see if the list contains an item.
 *
 * @author Sreerama Tripuramallu
 * @version 1
 * @param <E> the type of the elements to store in the linked list
 */
public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node head;
    private Node tail;
    private int size;
    private class Node {
        private E data;
        private Node next;
        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(E data) {
            this(data, null);
        }
        public Node(Node temp) {
            this.data = temp.getData();
            this.next = temp.getNext();
        }
        public Node() {
            this(null, null);
        }
        public Node getNode() {
            return this;
        }
        public E getData() {
            return this.data;
        }
        public Node getNext() {
            return this.next;
        }
    }
    /**
    * Creates a new SinglyLinkedList object
    * @param temp1 the first node
    */
    public SinglyLinkedList(Node temp1) {
        head = temp1;
        tail = temp1;
        if (temp1 != null) {
            size++;
        }
    }
    /**
    * Creates an empty SinglyLinkedList object
    */
    public SinglyLinkedList() {
        this(null);
    }
    @Override
    public E get(int index) {
        if (index >= 0 && index < size) {
            int counter = 0;
            Node current = head;
            while (counter < index) {
                current = current.next;
                counter++;
            }
            return current.getData();
        } else {
            return null;
        }
    }
    private Node get(int index, boolean doesNotMatter) {
        if (index > 0 && index < size) {
            Node current = head;
            int counter = 0;
            while (counter != index) {
                current = current.next;
            }
            return current;
        } else {
            return null;
        }
    }
    @Override
    public void add(E data) {
        if (head == null) {
            head = new Node(data);
            head.next = null;
            tail = head;
        } else if (head == tail) {
            tail = new Node(data);
            head.next = tail;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        size++;
    }
    @Override
    public boolean add(int index, E data) {
        int tempSize = size;
        if (index > size || index < 0) {
            return false;
        } else if (index == 0) {
            Node temp = head;
            head = new Node(data);
            head.next = temp;
            size++;
        } else  if (index == size) {
            add(data);
        } else {
            int counter = 0;
            Node current = head;
            while (counter < index - 1) {
                current = current.next;
                counter++;
            }
            Node hold = current.next;
            current.next = new Node(data);
            current.next.next = hold;
            size++;
        }
        return size > tempSize;
    }
    @Override
    public void addAll(Collection<? extends E> c) {
        for (E element : c) {
            this.add(element);
        }
    }
    @Override
    public boolean contains(E data) {
        Node current = head;
        int counter = 0;
        while (counter < size) {
            if (current.getData().equals(data)) {
                return true;
            }
            counter++;
            current = current.next;
        }
        return false;
    }
    @Override
    public boolean containsAll(Collection<? extends E> c) {
        for (E element : c) {
            if (!this.contains(element)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean remove(E data) {
        if (head == null) {
            return false;
        } else if (this.head.next == null) {
            if (this.head.data.equals(data)) {
                this.clear();
                return true;
            } else {
                return false;
            }
        } else {
            if (this.head.data.equals(data)) {
                this.head = this.head.next;
                this.size--;
                return true;
            }
            Node previous = this.head;
            Node current = previous.next;
            Node temp;
            while (current != null) {
                if (current.data.equals(data)) {
                    previous.next = current.next;
                    size--;
                    return true;
                }
                temp = current.next;
                previous = current;
                current = temp;
            }
            return false;
        }
    }
    @Override
    public E remove(int index) {
        E out;
        if ((index < 0) || (index >= size)) {
            return null;
        } else if (head.next == null) {
            out = head.data;
            this.clear();
        } else {
            if (index == 0) {
                out = head.data;
                head = head.next;
                size--;
                return out;
            }
            int count = 1;
            Node previous = this.head;
            Node current = this.head.next;
            Node temp;
            while ((current != null) && (count < index)) {
                temp = current.next;
                previous = current;
                current = temp;
                count++;
            }
            out = current.data;
            previous.next = current.next;
            size--;
        }
        return out;

    }
    @Override
    public boolean removeAll(Collection<? extends E> c) {
        boolean[] store = new boolean[c.size()];
        int count = 0;
        for (E element : c) {
            store[count] = this.remove(element);
            count++;
        }
        for (int i = 0; i < store.length; i++) {
            if (!store[i]) {
                return false;
            }
        }
        return true;
    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}