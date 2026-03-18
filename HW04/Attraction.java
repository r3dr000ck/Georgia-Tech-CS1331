/**
 * Represents an attraction that admits and rates groups of visitors.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Attraction implements Admittable, Comparable<Attraction> {
    private final String name;
    private long sumRatings;
    private int numRatings;
    private final double admissionFee;
    private Group[] visitors;

    /**
     * Constructs an attraction with the provided name and admission fee.
     *
     * @param name the attraction name
     * @param admissionFee the cost of admission
     */
    public Attraction(String name, double admissionFee) {
        if (name == null || name.isBlank()) {
            this.name = "No name";
        } else {
            this.name = name;
        }

        this.sumRatings = 0;
        this.numRatings = 0;
        if (admissionFee < 0) {
            this.admissionFee = 0.0;
        } else {
            this.admissionFee = admissionFee;
        }

        this.visitors = new Group[5];
    }

    /**
     * Constructs an attraction with the provided name and the default fee.
     *
     * @param name the attraction name
     */
    public Attraction(String name) {
        this(name, 5.25);
    }

    /**
     * Admits visitors in groups of up to five people.
     *
     * @param names the visitor names to admit
     */
    @Override
    public void admit(String[] names) {
        int nextIndex = openIndex();

        for (int start = 0; start < names.length; start += 5) {
            if (nextIndex >= visitors.length) {
                resizeVisitors();
            }

            int groupSize = Math.min(5, names.length - start);
            String[] groupPeople = new String[groupSize];
            for (int i = 0; i < groupSize; i++) {
                groupPeople[i] = names[start + i];
            }

            visitors[nextIndex] = new Group(groupPeople);
            nextIndex++;
        }
    }

    /**
     * Returns the first open visitor slot.
     *
     * @return the next available visitor index
     */
    private int openIndex() {
        int i = 0;
        while (i < visitors.length && visitors[i] != null) {
            i++;
        }
        return i;
    }

    /**
     * Doubles the capacity of the visitor array.
     */
    private void resizeVisitors() {
        Group[] tmp = new Group[visitors.length * 2];
        for (int i = 0; i < visitors.length; i++) {
            tmp[i] = visitors[i];
        }
        visitors = tmp;
    }

    /**
     * Updates the attraction rating and removes the group at the given index.
     *
     * @param index the visitor index to remove
     * @param rate the rating to record
     * @return the removed group size, or {@code -1} if the index is invalid
     */
    public int rateAndExit(int index, int rate) {
        if (index < 0 || index >= visitors.length || visitors[index] == null) {
            System.out.println("Could not update rating. Index invalid.");
            return -1;
        }

        numRatings++;
        sumRatings += Math.min(10, Math.max(1, rate));
        int ret = visitors[index].size();
        for (int i = index; i < visitors.length - 1; i++) {
            visitors[i] = visitors[i + 1];
        }
        visitors[visitors.length - 1] = null;
        return ret;
    }

    /**
     * Returns the average rating for the attraction.
     *
     * @return the average rating
     */
    public double averageRating() {
        if (numRatings == 0) {
            return 0.0;
        }
        return Math.round((double) sumRatings / numRatings * 100.0) / 100.0;
    }

    /**
     * Prints the attraction details followed by each visiting group.
     */
    public void printVisitors() {
        System.out.println(this.toString());
        for (int i = 0; i < visitors.length; i++) {
            if (visitors[i] != null) {
                System.out.printf("Group %d: %s\n", i + 1, visitors[i].toString());
            }
        }
    }

    /**
     * Returns the formatted attraction summary.
     *
     * @return the attraction as a string
     */
    @Override
    public String toString() {
        return String.format("%s/%.2f/%.2f", name, averageRating(), admissionFee);
    }

    /**
     * Compares this attraction to another by rating, then by admission fee.
     *
     * @param other the other attraction to compare against
     * @return a positive value if this attraction is greater, {@code 0} if equal,
     *     or a negative value otherwise
     */
    @Override
    public int compareTo(Attraction other) {
        if (other != null) {
            if (this.averageRating() == other.averageRating()) {
                if (this.admissionFee == other.admissionFee) {
                    return 0;
                } else {
                    if (this.admissionFee > other.admissionFee) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            } else {
                if (this.averageRating() > other.averageRating()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
