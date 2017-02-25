import java.io.FileNotFoundException;
/**
 * The Exception that occurs if the region is unknown
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public class UnknownRegionException extends FileNotFoundException {
    /**
    * Creates a new UnknownRegionException
    */
    public UnknownRegionException() {
        super("Could not find your region!");
    }
}