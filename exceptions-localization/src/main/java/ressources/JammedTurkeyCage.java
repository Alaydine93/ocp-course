package ressources;

public class JammedTurkeyCage implements AutoCloseable{
    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Turkeys out!");
    }
}
