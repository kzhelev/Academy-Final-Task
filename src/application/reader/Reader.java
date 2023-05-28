package application.reader;

/**
 * An interface that defines methods for reading lines from a file.
 */

public interface Reader {

    public String nextLine();
    public boolean hasNextLine();
    public void close();
}
