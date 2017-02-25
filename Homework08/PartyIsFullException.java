/**
 * The Exception that occurs if the party is full
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public class PartyIsFullException extends RuntimeException {
    /**
    * Creates a new PartyIsFullException
    * @param message the exception's message
    */
    public PartyIsFullException(String message) {
        super(message);
    }
    /**
    * Creates a new PartyIsFullException
    */
    public PartyIsFullException() {
        this("The party is already full");
    }
}