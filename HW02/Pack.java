/**
 * This class stores details about a pack of dinosaurs.
 * Pack is an immutable class.
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Pack {
    private final int size;
    private final String packName;

    /**
     * Constructor that takes in size and packName.
     * @param size the number of dinosaurs in the pack
     * @param packName the name of the pack
     */
    public Pack(int size, String packName) {
        if (size < 0) {
            this.size = 4;
        } else {
            this.size = size;
        }

        if (packName == null || packName.trim().length() < 1) {
            this.packName = "The Power Pack";
        } else {
            this.packName = packName;
        }
    }

    /**
     * Returns the string representation of this pack.
     * @return formatted string
     */
    public String toString() {
        return String.format("%s is a family of dinosaurs of size %d!", this.packName, this.size);
    }

    /**
     * Gets the size of this pack.
     * @return size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Gets the name of this pack.
     * @return packName
     */
    public String getPackName() {
        return this.packName;
    }
}