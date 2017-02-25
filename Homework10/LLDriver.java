import java.util.ArrayList;

public class LLDriver {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        Integer a, b, c, d, e, f, g, h, i;
        int size;
        boolean emptiness, added, doesContain1, doesContain2, doesContain3, doesContain4, removed1, removed2, removed3;
        ArrayList<Integer> toAdd, toAdd2;

        // Check empty list case for get method:
        System.out.println("Check get method for case of empty list:");
        a = list.get(0);
        System.out.println("Output: " + a);
        System.out.println("Correct: null");
        System.out.println();

        // Check add to back method for empty list:
        System.out.println("Check add (to back) method for case of empty list:");
        list.add(new Integer(1));
        b = list.get(0);
        System.out.println("Output: " + b);
        System.out.println("Correct: 1");
        System.out.println();

        // Check add to back method for list of length 1:
        System.out.println("Check add (to back) method for list of length 1:");
        list.add(new Integer(2));
        c = list.get(1);
        System.out.println("Output: " + c);
        System.out.println("Correct: 2");
        System.out.println();

        // Check add to back method for list of length 2+:
        System.out.println("Check add (to back) method for list of length 2+:");
        list.add(new Integer(3));
        list.add(new Integer(4));
        d = list.get(2);
        e = list.get(3);
        System.out.println("Output: " + d + ", " + e);
        System.out.println("Correct: 3, 4");
        System.out.println();

        // Check size, isEmpty, and clear:
        System.out.println("Check size, isEmpty, and clear methods:");
        size = list.size();
        System.out.println("Output: " + size);
        System.out.println("Correct: 4");
        System.out.println();

        emptiness = list.isEmpty();
        System.out.println("Output: " + emptiness);
        System.out.println("Correct: false");
        System.out.println();

        list.clear();
        a = list.get(0);
        b = list.get(1);
        c = list.get(2);
        d = list.get(3);
        e = list.get(4);

        size = list.size();
        System.out.println("Output: " + size);
        System.out.println("Correct: 0");
        System.out.println();

        emptiness = list.isEmpty();
        System.out.println("Output: " + emptiness);
        System.out.println("Correct: true");
        System.out.println();

        // Check get method for index out of bounds:
        System.out.println("Check get method for indices out of bounds:");
        System.out.println("Output: " + a + ", " + b + ", " + c + ", " + d + ", " + e);
        System.out.println("Correct: null, null, null, null, null");
        System.out.println();

        // Check add to index method for adding to back (of empty list):
        added = list.add(0, new Integer(0));
        a = list.get(0);
        System.out.println("Check add (to index) method for adding to the back of the list:");
        System.out.println("Output: " + added + ", " + a);
        System.out.println("Correct: true, 0");
        System.out.println();

        // Check add to index method for adding to front (of empty list):
        added = list.add(0, new Integer(-1));
        b = list.get(0);
        System.out.println("Check add (to index) method for adding to the front of the list:");
        System.out.println("Output: " + added + ", " + b);
        System.out.println("Correct: true, -1");
        System.out.println();

        // Check add to index method for indexing out of bounds:
        added = list.add(5, new Integer(5));
        System.out.println("Check add (to index) method for indexing out of bounds:");
        System.out.println("Output: " + added);
        System.out.println("Correct: false");
        System.out.println();

        // Check add to index method for adding to a 2+ element list:
        added = list.add(1, new Integer(1));
        added = list.add(2, new Integer(2));
        a = list.get(0);
        b = list.get(1);
        c = list.get(2);
        d = list.get(3);
        System.out.println("Check add (to index) method for adding to a list of 2+ elements:");
        System.out.println("Output: " + a + ", " + b + ", " + c + ", " + d);
        System.out.println("Correct: -1, 1, 2, 0");
        System.out.println();

        //Check addAll method:
         toAdd = new ArrayList<Integer>(0);
        toAdd.add(new Integer(5));
        toAdd.add(new Integer(6));
        toAdd.add(new Integer(7));
        toAdd.add(new Integer(8));
        list.addAll(toAdd);
        e = list.get(4);
        f = list.get(5);
        g = list.get(6);
        h = list.get(7);
        System.out.println("Check addAll method:");
        System.out.println("Output: " + e + ", " + f + ", " + g + ", " + h);
        System.out.println("Correct: -1, 1, 2, 0, 5, 6, 7, 8");
        System.out.println();




        // Check containsAll method:
        toAdd2 = new ArrayList<Integer>(0);
        toAdd2.add(new Integer(1));
        toAdd2.add(new Integer(5));
        toAdd2.add(new Integer(3));
        doesContain1 = list.containsAll(toAdd);
        doesContain2 = list.containsAll(toAdd2);
        System.out.println("Check containsAll method:");
        System.out.println("Output: " + doesContain1 + ", " + doesContain2);
        System.out.println("Correct: true, false");
        System.out.println();

        // Check contains method:
        doesContain1 = list.contains(new Integer(5));
        doesContain2 = list.contains(new Integer(0));
        doesContain3 = list.contains(new Integer(-5));
        list.clear();
        doesContain4 = list.contains(new Integer(0));
        System.out.println("Check contains method:");
        System.out.println("Output: " + doesContain1 + ", " + doesContain2 + ", " + doesContain3 + ", " + doesContain4);
        System.out.println("Correct: true, true, false, false");
        System.out.println();

        // Check remove (first element) method for case of empty list:
        list.clear();
        removed1 = list.remove(new Integer(8));
        size = list.size();
        System.out.println("Check remove (first element) method for an empty list:");
        System.out.println("Output: " + removed1 + ", " + size);
        System.out.println("Correct: false, 0");
        System.out.println();

        // Check remove (first element) method for case of 1 element list:
        list.add(new Integer(0));
        removed1 = list.remove(new Integer(1));
        removed2 = list.remove(new Integer(0));
        size = list.size();
        System.out.println("Check remove (first element) method for a list of 1 element:");
        System.out.println("Output: " + removed1 + ", " + removed2 + ", " + size);
        System.out.println("Correct: false, true, 0");
        System.out.println();

        // Check remove (first element) method for case of 2+ element list:
        list.addAll(toAdd);
        removed1 = list.remove(new Integer(0));
        removed2 = list.remove(new Integer(8));
        removed3 = list.remove(new Integer(8));
        size = list.size();
        System.out.println("Check remove (first element) method for a list of 2+ elements:");
        System.out.println("Output: " + removed1 + ", " + removed2 + ", " + removed3 + ", " + size);
        System.out.println("Correct: false, true, false, 3");
        System.out.println();

        // Check remove (at index) method for case of empty list:
        list.clear();
        a = list.remove(0);
        size = list.size();
        System.out.println("Check remove (at index) method for an empty list:");
        System.out.println("Output: " + a + ", " + size);
        System.out.println("Correct: null, 0");
        System.out.println();

        // Check remove (at index) method for case of 1+ element list:
        list.addAll(toAdd);
        a = list.remove(-1);
        b = list.remove(3);
        c = list.remove(3);
        size = list.size();
        System.out.println("Check remove (at index) method for a list of 1+ elements:");
        System.out.println("Output: " + a + ", " + b + ", " + c + ", " + size);
        System.out.println("Correct: null, 8, null, 3");
        System.out.println();

        // Check removeAll method
        list.clear();
        list.addAll(toAdd);
        list.addAll(toAdd2);
        removed1 = list.removeAll(toAdd);
        toAdd2.add(new Integer(10));
        removed2 = list.removeAll(toAdd2);
        size = list.size();
        System.out.println("Check removeAll method:");
        System.out.println("Output: " + removed1 + ", " + removed2 + ", " + size);
        System.out.println("Correct: true, false, 0");
        System.out.println();
    }
}