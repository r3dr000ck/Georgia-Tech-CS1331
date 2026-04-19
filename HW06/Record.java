/**
 * Represents a musical record.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public abstract class Record {
    private String artist;
    private String title;
    private String duration;
    private String releaseDate;
    private int timesPlayed;
    private char grade;

    /**
     * Constructs a new Record.
     *
     * @param artist the artist name
     * @param title the song title
     * @param duration the record duration
     * @param releaseDate the release date
     * @param timesPlayed the number of times played
     * @param grade the quality grade
     * @throws IllegalArgumentException if any argument is invalid
     */
    public Record(String artist, String title, String duration,
        String releaseDate, int timesPlayed, char grade) {
        if (artist == null || artist.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        if (title == null || title.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        if (duration == null || duration.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        if (releaseDate == null || releaseDate.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        if (timesPlayed < 0) {
            throw new IllegalArgumentException();
        }
        if (!(grade == 'M' || grade == 'E' || grade == 'G'
            || grade == 'F' || grade == 'P')) {
            throw new IllegalArgumentException();
        }

        this.artist = artist.trim();
        this.title = title.trim();
        this.duration = duration.trim();
        this.releaseDate = releaseDate.trim();
        this.timesPlayed = timesPlayed;
        this.grade = grade;
    }

    /**
     * Returns the artist.
     *
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the duration.
     *
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Returns the release date.
     *
     * @return the release date
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Returns the number of times played.
     *
     * @return the number of times played
     */
    public int getTimesPlayed() {
        return timesPlayed;
    }

    /**
     * Returns the grade.
     *
     * @return the grade
     */
    public char getGrade() {
        return grade;
    }

    /**
     * Returns this record as CSV fields.
     *
     * @return the CSV representation
     */
    @Override
    public String toString() {
        return artist + "," + title + "," + duration + "," + releaseDate
            + "," + timesPlayed + "," + grade;
    }

    /**
     * Compares this record with another object.
     *
     * @param obj the object to compare against
     * @return true if the objects are equal; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Record other = (Record) obj;
        return timesPlayed == other.timesPlayed
            && grade == other.grade
            && artist.equals(other.artist)
            && title.equals(other.title)
            && duration.equals(other.duration)
            && releaseDate.equals(other.releaseDate);
    }
}
