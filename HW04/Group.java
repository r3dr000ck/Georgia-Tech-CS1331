/**
 * Represents a group of visitors.
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Group {
    private final String[] people;

    /**
     * Constructs a group from the provided people.
     *
     * @param people the people in the group
     */
    public Group(String[] people) {
        if (people == null) {
            this.people = new String[0];
        } else {
            this.people = new String[people.length];
            for (int i = 0; i < people.length; i++) {
                this.people[i] = people[i];
            }
        }
    }

    /**
     * Returns the number of people in the group.
     *
     * @return the group size
     */
    public int size() {
        return people.length;
    }

    /**
     * Returns the group names joined by forward slashes.
     *
     * @return the group as a string
     */
    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < people.length; i++) {
            if (i > 0) {
                ret += "/";
            }
            ret += people[i];
        }
        return ret;
    }
}
