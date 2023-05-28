package application.reader.ReaderDefiner;

import application.reader.CSVReader;
import application.reader.Reader;
import application.reader.TXTReader;

public class ReaderDefiner {

    /**
     * Based on the extension of the file that is supposed to be read the method choose to define one of the present reader classes.
     */

    public Reader define(String filepath) {

        if (filepath.endsWith(".csv")) {
            return new CSVReader(filepath);
        } else if (filepath.endsWith(".txt")) {
            return new TXTReader(filepath);
        } else {
            throw new IllegalArgumentException("Illegal file extension!");
        }
    }
}
