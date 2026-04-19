/**
 * Represents a jazz record.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class JazzRecord extends Record {
    private String audioEngineer;

    /**
     * Constructs a new JazzRecord.
     *
     * @param artist the artist name
     * @param title the song title
     * @param duration the record duration
     * @param releaseDate the release date
     * @param timesPlayed the number of times played
     * @param grade the quality grade
     * @param audioEngineer the audio engineer
     */
    public JazzRecord(String artist, String title, String duration,
        String releaseDate, int timesPlayed, char grade,
        String audioEngineer) {
        super(artist, title, duration, releaseDate, timesPlayed, grade);
        if (audioEngineer == null || audioEngineer.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        this.audioEngineer = audioEngineer.trim();
    }

    /**
     * Returns the audio engineer.
     *
     * @return the audio engineer
     */
    public String getAudioEngineer() {
        return audioEngineer;
    }

    /**
     * Returns this jazz record as a CSV line.
     *
     * @return the CSV representation
     */
    @Override
    public String toString() {
        return "JazzRecord," + super.toString() + "," + audioEngineer;
    }

    /**
     * Compares this jazz record with another object.
     *
     * @param obj the object to compare against
     * @return true if the objects are equal; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        JazzRecord other = (JazzRecord) obj;
        return audioEngineer.equals(other.audioEngineer);
    }
}
