import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Simple driver for local testing.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Driver {
    /**
     * Runs a simple end-to-end jukebox test.
     *
     * @param args command-line arguments
     * @throws FileNotFoundException if the test file cannot be accessed
     * @throws InvalidRecordException if a record is invalid
     */
    public static void main(String[] args)
        throws FileNotFoundException, InvalidRecordException {
        File testFile = new File("TestRecords.csv");
        if (testFile.exists()) {
            testFile.delete();
        }

        JazzRecord jazzOne = new JazzRecord("Miles Davis", "So What",
            "09:22", "08-1959", 12, 'M', "Fred Plaut");
        JazzRecord jazzTwo = new JazzRecord("John Coltrane", "Naima",
            "04:23", "01-1960", 8, 'E', "Tom Dowd");
        RapRecord rapOne = new RapRecord("A Tribe Called Quest",
            "Electric Relaxation", "04:03", "11-1993", 15, 'G',
            "A Tribe Called Quest");
        RapRecord rapTwo = new RapRecord("Nas", "N.Y. State of Mind",
            "04:54", "04-1994", 20, 'F', "DJ Premier");

        ArrayList<Record> startingRecords = new ArrayList<Record>();
        startingRecords.add(jazzOne);
        startingRecords.add(jazzTwo);
        startingRecords.add(rapOne);
        startingRecords.add(rapTwo);
        Jukebox.stockJukebox("TestRecords.csv", startingRecords);

        JazzRecord jazzThree = new JazzRecord("Herbie Hancock",
            "Cantaloupe Island", "05:33", "06-1964", 3, 'M',
            "Rudy Van Gelder");
        ArrayList<Record> oneMoreRecord = new ArrayList<Record>();
        oneMoreRecord.add(jazzThree);
        Jukebox.stockJukebox("TestRecords.csv", oneMoreRecord);

        ArrayList<Record> records = Jukebox.retrieveRecords("TestRecords.csv");
        for (int i = 0; i < records.size(); i++) {
            System.out.println(records.get(i));
        }

        Jukebox.spinRecord("TestRecords.csv", jazzOne);
        Jukebox.removeRecord("TestRecords.csv", rapTwo);
    }
}
