/**
  *SetTest has a basic main method that does
  *basic sanity testing
  *@author Matt Gruchacz
  *@version 4 3/26/14
  **/

public class SetTest {
    /**
      *Basic tests executed in mian
      *@param args - the ignored command line arguments
      */
    public static void main(String... args) {

        //sanity add test
        GenericSet<Integer> add = new GenericSet<>();
        for (int i = 0; i < 1000; i++) {
            add.add(i);
            add.addAll(add);
        }
        System.out.println(add.size());
        if (add.size() == 1000) {
            System.out.println("Sanity add passed");
        } else {
            System.out.println("Sanity add failed");
        }


        //powerset test
        GenericSet<Integer> ps = new GenericSet<>();
        for (int i = 0; i < 10; i++) {
            ps.add(i);
        }
        ExtendedSet<ExtendedSet<Integer>> powerSet = ps.powerSet();
        if (powerSet.size() == 1024) {
            System.out.println("powerSet size correct");
        } else {
            System.out.println("powerSet size incorrect");
        }

        GenericSet<Integer> temp1 = new GenericSet<>();
        GenericSet<Integer> temp2 = new GenericSet<>();
        temp1.add(1);
        temp1.add(2);
        temp1.add(3);
        temp2.add(3);
        temp2.add(4);

        //Union
        ExtendedSet<Integer> temp3 = new GenericSet<>();
        temp3 = temp1.union(temp2);
        for (Integer element : temp3) {
            System.out.println(element);
        }
        System.out.println();

        //Intersection
        ExtendedSet<Integer> temp4 = new GenericSet<>();
        temp4 = temp1.intersection(temp2);
        for (Integer element : temp4) {
            System.out.println(element);
        }
        System.out.println();

        //Difference
        ExtendedSet<Integer> temp5 = new GenericSet<>();
        temp5 = temp1.difference(temp2);
        for (Integer element : temp5) {
            System.out.println(element);
        }
        System.out.println();

        //Symmetric Difference
        ExtendedSet<Integer> temp6 = new GenericSet<>();
        temp6 = temp1.symmetricDifference(temp2);
        for (Integer element : temp6) {
            System.out.println(element);
        }
        System.out.println();

        //Product
        ExtendedSet<Tuple<Integer>> temp7 = new GenericSet<>();
        temp7 = temp1.product(temp2);
        for (Tuple<Integer> element : temp7) {
            System.out.println(element.getA() + " " + element.getB());
        }
        System.out.println();





        //Map Reduce Filter test
        GenericSet<Integer> set = new GenericSet<>();
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
        String accum = "";
        for (int j = 0; j < 100; j += 2) {
            accum += j + " ";
        }
        accum = accum.trim();


        String all = set.filter(i -> (((i.intValue()) & 1) == 0))
            .<String>map(a -> a.toString())
            .reduce((a, b) -> a + " " + b);

        if (accum.equals(all)) {
            System.out.println("Passed map reduce filter test");
        } else {
            System.out.println("Test failed");
        }
        System.out.println("Accum: ");
        System.out.println(accum + "\n");
        System.out.println("All: ");
        System.out.println(all);
    }
}