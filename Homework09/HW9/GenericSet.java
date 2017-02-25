/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, George Wang,
Siva Movva for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * GenericSet represents a generic set
 * @param <T> the type that the generic set will contain
 * @author Sreeramamurthy Tripuramallu
 * @version 1
 */
public class GenericSet<T> implements ExtendedSet<T> {
    private ArrayList<T> arraylist = new ArrayList<T>();
    private ArrayList<String> combinations = new ArrayList<String>();
    @Override
    public boolean add(T e) {
        if (!arraylist.contains(e)) {
            return arraylist.add(e);
        }
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        int counter = 0;
        for (T element : c) {
            if (!arraylist.contains(element)) {
                arraylist.add(element);
                counter++;
            }
        }
        return !(counter == 0);
    }
    @Override
    public void clear() {
        arraylist.clear();
    }
    @Override
    public boolean contains(Object o) {
        return arraylist.contains(o);
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return arraylist.containsAll(c);
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (o.getClass() == this.getClass()) {
            GenericSet<T> other = (GenericSet<T>) o;
            if (other.size() == arraylist.size()) {
                return arraylist.equals(other);
            }
        }
        return false;

    }
    @Override
    public int hashCode() {
        return arraylist.hashCode();
    }
    @Override
    public boolean isEmpty() {
        return arraylist.isEmpty();
    }
    @Override
    public Iterator<T> iterator() {
        return arraylist.iterator();
    }
    @Override
    public boolean remove(Object o) {
        return arraylist.remove(o);
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        return arraylist.removeAll(c);
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return arraylist.retainAll(c);
    }
    @Override
    public int size() {
        return arraylist.size();
    }
    @Override
    public Object[] toArray() {
        return arraylist.toArray();
    }
    @Override
    public <T> T[] toArray(T[] a) {
        return arraylist.toArray(a);
    }
    @Override
    public GenericSet<T> union(ExtendedSet<T> set) {
        GenericSet<T> temp = new GenericSet<T>();
        for (int i = 0; i < arraylist.size(); i++) {
            temp.add(arraylist.get(i));
        }
        for (T element : set) {
            if (!temp.contains(element)) {
                temp.add(element);
            }
        }
        return temp;
    }
    @Override
    public GenericSet<T> intersection(ExtendedSet<T> set) {
        GenericSet<T> temp = new GenericSet<T>();
        for (T element : set) {
            if (arraylist.contains(element)) {
                temp.add(element);
            }
        }
        return temp;
    }
    @Override
    public GenericSet<T> difference(ExtendedSet<T> set) {
        GenericSet<T> temp = new GenericSet<T>();
        for (T element : arraylist) {
            if (!set.contains(element)) {
                temp.add(element);
            }
        }
        return temp;
    }
    @Override
    public GenericSet<T> symmetricDifference(ExtendedSet<T> set) {
        GenericSet<T> temp = new GenericSet<T>();
        for (T element : arraylist) {
            if (!set.contains(element)) {
                temp.add(element);
            }
        }
        for (T element : set) {
            if (!arraylist.contains(element)) {
                temp.add(element);
            }
        }
        return temp;
    }
    @Override
    public ExtendedSet<ExtendedSet<T>> powerSet() {
        ExtendedSet<ExtendedSet<T>> pS = new GenericSet<ExtendedSet<T>>();
        generate("", arraylist.size());
        for (int i = 0; i < combinations.size(); i++) {
            ExtendedSet<T> helper = new GenericSet<T>();
            for (int j = 0; j < combinations.get(i).length(); j++) {
                Character t = combinations.get(i).charAt(j);
                if (t.equals('1')) {
                    helper.add(arraylist.get(j));
                }
            }
            pS.add(helper);
        }
        return pS;
    }
    private void generate(String current, int len) {
        if (current.length() == len) {
            combinations.add(current);
            return;
        }
        generate(current + "0", len);
        generate(current + "1", len);
    }
    @Override
    public ExtendedSet<Tuple<T>> product(ExtendedSet<T> set) {
        ExtendedSet<Tuple<T>> temp = new GenericSet<Tuple<T>>();
        for (T element1 : arraylist) {
            for (T element2 : set) {
                GenericTuple<T> t = new GenericTuple<T>(element1, element2);
                temp.add(t);
            }
        }
        return temp;
    }
    @Override
    public <E> GenericSet<E> map(LMap<T, E> map) {
        GenericSet<E> temp = new GenericSet<E>();
        for (T element: arraylist) {
            temp.add(map.map(element));
        }
        return temp;
    }
    @Override
    public T reduce(LReduce<T> reduce) {
        if (arraylist.isEmpty()) {
            return null;
        }
        T temp = arraylist.get(0);
        for (int i = 1; i < arraylist.size(); i++) {
            temp = reduce.reduce(temp, arraylist.get(i));
        }
        return temp;
    }
    @Override
    public GenericSet<T> filter(LFilter<T> filter) {
        GenericSet<T> temp = new GenericSet<T>();
        for (T element : arraylist) {
            if (filter.filter(element)) {
                temp.add(element);
            }
        }
        return temp;
    }
}