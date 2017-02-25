/**
 * The Exception that occurs if a pokemon already exists
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public class PokemonAlreadyExistsException extends RuntimeException {
    /**
    * Creates a new PokemonAlreadyExistsException
    * @param message the exception's message
    */
    public PokemonAlreadyExistsException(String message) {
        super(message);
    }
    /**
    * Creates a new PokemonAlreadyExistsException
    */
    public PokemonAlreadyExistsException() {
        this("Sorry that pokemon already exists");
    }

}