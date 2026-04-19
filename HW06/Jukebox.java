import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides static helper methods for reading and writing jukebox records.
 *
 * @author Keigo
 * @version 1.0
 */
public class Jukebox {
    /**
     * Reads every record from a CSV file.
     *
     * @param path the file path
     * @return the records in the file
     * @throws FileNotFoundException if the path is invalid or the file does not exist
     * @throws InvalidRecordException if a line contains an invalid record type
     */
    public static ArrayList<Record> retrieveRecords(String path)
        throws FileNotFoundException, InvalidRecordException {
        File file = validateExistingFile(path);
        Scanner scan = new Scanner(file);
        ArrayList<Record> records = new ArrayList<Record>();

        try {
            while (scan.hasNextLine()) {
                records.add(processInfo(scan.nextLine()));
            }
        } finally {
            scan.close();
        }

        return records;
    }

    /**
     * Writes records to the jukebox file, appending to existing contents.
     *
     * @param path the file path
     * @param jukebox the records to add
     * @throws FileNotFoundException if the path is invalid
     * @throws InvalidRecordException if an existing line contains an invalid record
     */
    public static void stockJukebox(String path, ArrayList<Record> jukebox)
        throws FileNotFoundException, InvalidRecordException {
        if (jukebox == null) {
            throw new IllegalArgumentException();
        }

        validatePath(path);
        File file = new File(path);
        ArrayList<Record> allRecords = new ArrayList<Record>();
        if (file.exists()) {
            allRecords = retrieveRecords(path);
        }
        for (int i = 0; i < jukebox.size(); i++) {
            allRecords.add(jukebox.get(i));
        }

        writeRecords(file, allRecords);
    }

    /**
     * Finds all line numbers containing the given record.
     *
     * @param path the file path
     * @param record the record to find
     * @return the line numbers containing the record
     * @throws FileNotFoundException if the path is invalid or the file does not exist
     * @throws InvalidRecordException if the record is not found or a line is invalid
     */
    public static ArrayList<Integer> findRecords(String path, Record record)
        throws FileNotFoundException, InvalidRecordException {
        if (record == null) {
            throw new IllegalArgumentException();
        }

        ArrayList<Record> records = retrieveRecords(path);
        ArrayList<Integer> matches = new ArrayList<Integer>();

        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).equals(record)) {
                matches.add(i);
            }
        }

        if (matches.size() == 0) {
            throw new InvalidRecordException();
        }

        return matches;
    }

    /**
     * Spins every matching record in the jukebox.
     *
     * @param path the file path
     * @param record the record to spin
     * @throws FileNotFoundException if the path is invalid or the file does not exist
     * @throws InvalidRecordException if the record is not found or a line is invalid
     */
    public static void spinRecord(String path, Record record)
        throws FileNotFoundException, InvalidRecordException {
        ArrayList<Integer> matches = findRecords(path, record);
        ArrayList<Record> records = retrieveRecords(path);

        for (int i = 0; i < matches.size(); i++) {
            int index = matches.get(i);
            records.set(index, spinSingleRecord(records.get(index)));
        }

        writeRecords(validateExistingFile(path), records);
    }

    /**
     * Removes every matching record from the jukebox file.
     *
     * @param path the file path
     * @param record the record to remove
     * @throws FileNotFoundException if the path is invalid or the file does not exist
     * @throws InvalidRecordException if the record is not found or a line is invalid
     */
    public static void removeRecord(String path, Record record)
        throws FileNotFoundException, InvalidRecordException {
        findRecords(path, record);
        ArrayList<Record> records = retrieveRecords(path);
        ArrayList<Record> keptRecords = new ArrayList<Record>();

        for (int i = 0; i < records.size(); i++) {
            if (!records.get(i).equals(record)) {
                keptRecords.add(records.get(i));
            }
        }

        writeRecords(validateExistingFile(path), keptRecords);
    }

    /**
     * Converts one CSV line into a Record object.
     *
     * @param info one CSV line
     * @return the parsed record
     * @throws InvalidRecordException if the record type is invalid
     */
    private static Record processInfo(String info) throws InvalidRecordException {
        String[] parts = info.split(",");
        if (parts[0].equals("JazzRecord")) {
            return new JazzRecord(parts[1], parts[2], parts[3], parts[4],
                Integer.parseInt(parts[5]), parts[6].charAt(0), parts[7]);
        } else if (parts[0].equals("RapRecord")) {
            return new RapRecord(parts[1], parts[2], parts[3], parts[4],
                Integer.parseInt(parts[5]), parts[6].charAt(0), parts[7]);
        } else {
            throw new InvalidRecordException();
        }
    }

    /**
     * Writes a list of records back to a file, omitting poor-quality records.
     *
     * @param file the file to write
     * @param records the records to write
     * @throws FileNotFoundException if the file cannot be opened for writing
     */
    private static void writeRecords(File file, ArrayList<Record> records)
        throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);

        try {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).getGrade() != 'P') {
                    writer.println(records.get(i));
                }
            }
        } finally {
            writer.close();
        }
    }

    /**
     * Validates a file path and ensures the file exists.
     *
     * @param path the file path
     * @return the file at the given path
     * @throws FileNotFoundException if the path is invalid or the file does not exist
     */
    private static File validateExistingFile(String path)
        throws FileNotFoundException {
        File file = validatePath(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        return file;
    }

    /**
     * Validates a file path.
     *
     * @param path the file path
     * @return the file at the given path
     * @throws FileNotFoundException if the path is null or blank
     */
    private static File validatePath(String path) throws FileNotFoundException {
        if (path == null || path.trim().length() == 0) {
            throw new FileNotFoundException();
        }
        return new File(path);
    }

    /**
     * Spins one record once, updating play count and possibly lowering grade.
     *
     * @param record the record to spin
     * @return the spun record
     * @throws InvalidRecordException if the updated record cannot be rebuilt
     */
    private static Record spinSingleRecord(Record record)
        throws InvalidRecordException {
        String[] parts = record.toString().split(",");
        int timesPlayed = Integer.parseInt(parts[5]) + 1;
        char grade = parts[6].charAt(0);

        if (Math.random() < 0.3) {
            grade = lowerGrade(grade);
        }

        return processInfo(parts[0] + "," + parts[1] + "," + parts[2] + ","
            + parts[3] + "," + parts[4] + "," + timesPlayed + ","
            + grade + "," + parts[7]);
    }

    /**
     * Lowers a record grade by one level.
     *
     * @param grade the current grade
     * @return the lowered grade
     */
    private static char lowerGrade(char grade) {
        if (grade == 'M') {
            return 'E';
        } else if (grade == 'E') {
            return 'G';
        } else if (grade == 'G') {
            return 'F';
        } else {
            return 'P';
        }
    }
}
