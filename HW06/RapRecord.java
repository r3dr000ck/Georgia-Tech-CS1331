/**
 * Represents a rap record.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class RapRecord extends Record {
    private String producer;

    /**
     * Constructs a new RapRecord.
     *
     * @param artist the artist name
     * @param title the song title
     * @param duration the record duration
     * @param releaseDate the release date
     * @param timesPlayed the number of times played
     * @param grade the quality grade
     * @param producer the producer
     */
    public RapRecord(String artist, String title, String duration,
        String releaseDate, int timesPlayed, char grade, String producer) {
        super(artist, title, duration, releaseDate, timesPlayed, grade);
        if (producer == null || producer.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        this.producer = producer.trim();
    }

    /**
     * Returns the producer.
     *
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * Returns this rap record as a CSV line.
     *
     * @return the CSV representation
     */
    @Override
    public String toString() {
        return "RapRecord," + super.toString() + "," + producer;
    }

    /**
     * Compares this rap record with another object.
     *
     * @param obj the object to compare against
     * @return true if the objects are equal; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        RapRecord other = (RapRecord) obj;
        return producer.equals(other.producer);
    }
}
