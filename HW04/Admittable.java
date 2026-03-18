/**
 * Represents behavior for admitting visitors.
 * @author Keigo Yoshioka
 * @version 1.0
 */
public interface Admittable {
    /**
     * Admits the provided visitors.
     *
     * @param names the names of the visitors to admit
     */
    void admit(String[] names);
}
