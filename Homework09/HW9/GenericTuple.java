/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, George Wang,
Siva Movva for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**//**
 * GenericTuple represents a generic tuple
 * @param <T> the type that the generic tuple will contain
 * @author Sreeramamurthy Tripuramallu
 * @version 1
 */
public class GenericTuple<T> implements Tuple {
    private T a;
    private T b;
    /**
    * Creates a Generic Tuple
    * @param a object of type T
    * @param b object of type T
    */
    public  GenericTuple(T a, T b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public T getA() {
        return a;
    }
    @Override
    public T getB() {
        return b;
    }
}