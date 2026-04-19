/**
 * This class contains recursive methods for organizing superhero arrays.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class ComicBookBin {

    /**
     * Sorts the given array of heroes in ascending lexicographical order by
     * name using recursive merge sort.
     *
     * @param heroes the array to sort
     * @return a sorted array containing the same heroes
     */
    public static Superhero[] mergeSortHeroes(Superhero[] heroes) {
        if (heroes.length <= 1) {
            return heroes;
        }

        int mid = heroes.length / 2;
        Superhero[] left = RecursionUtils.copyOfRange(heroes, 0, mid);
        Superhero[] right = RecursionUtils.copyOfRange(heroes, mid, heroes.length);

        return RecursionUtils.merge(mergeSortHeroes(left), mergeSortHeroes(right));
    }

    /**
     * Merges all sorted sub-teams into one sorted array.
     *
     * @param teams the sorted sub-teams to merge
     * @return one sorted array containing every hero from every sub-team
     */
    public static Superhero[] mergeHeroes(Superhero[][] teams) {
        return m(teams, 0, teams.length);
    }

    /**
     * Recursively merges the sorted sub-teams in the given range.
     *
     * @param teams the full array of sub-teams
     * @param start the inclusive starting index
     * @param end the exclusive ending index
     * @return a sorted merge of all teams in the range
     */
    private static Superhero[] m(Superhero[][] teams, int start, int end) {
        if (start >= end) {
            return new Superhero[0];
        } else if (end - start == 1) {
            return teams[start];
        }

        int mid = (start + end) / 2;
        Superhero[] left = m(teams, start, mid);
        Superhero[] right = m(teams, mid, end);
        return RecursionUtils.merge(left, right);
    }

    /**
     * Returns a sorted array containing only the heroes on the given alliance.
     *
     * @param heroes the sorted array of heroes to filter
     * @param alliance the alliance to keep
     * @return a sorted array containing only heroes on the given alliance
     */
    public static Superhero[] heroesOfAlliance(Superhero[] heroes, Alliance alliance) {
        Superhero[] ret = new Superhero[countAlliance(heroes, alliance, 0)];
        fillAlliance(heroes, alliance, 0, ret, 0);
        return ret;
    }

    /**
     * Counts the heroes in the array that belong to the given alliance.
     *
     * @param heroes the heroes to inspect
     * @param alliance the alliance to count
     * @param i the current index being inspected
     * @return the number of matching heroes from index onward
     */
    private static int countAlliance(Superhero[] heroes, Alliance alliance, int i) {
        if (i == heroes.length) {
            return 0;
        }

        int currentMatch = heroes[i].getAlliance() == alliance ? 1 : 0;
        return currentMatch + countAlliance(heroes, alliance, i + 1);
    }

    /**
     * Calculates the total strength of all heroes in the given array.
     *
     * @param heroes the heroes whose total strength should be computed
     * @return the total strength of all heroes
     */
    public static double totalStrength(Superhero[] heroes) {
        return totalStrength(heroes, 0);
    }

    /**
     * Reverses the sorted array in place so it becomes descending by name.
     *
     * @param heroes the sorted array to reverse
     */
    public static void flip(Superhero[] heroes) {
        flip(heroes, 0, heroes.length - 1);
    }

    /**
     * Copies matching heroes into the destination array while preserving order.
     *
     * @param heroes the source heroes
     * @param alliance the alliance to keep
     * @param si the current source index
     * @param filtered the destination array for matching heroes
     * @param di the next destination index to fill
     */
    private static void fillAlliance(Superhero[] heroes, Alliance alliance,
        int si, Superhero[] filtered, int di) {
        if (si == heroes.length) {
            return;
        }

        if (heroes[si].getAlliance() == alliance) {
            filtered[di] = heroes[si];
            fillAlliance(heroes, alliance, si + 1, filtered, di + 1);
        } else {
            fillAlliance(heroes, alliance, si + 1, filtered, di);
        }
    }

    /**
     * Recursively computes the total strength from the given index onward.
     *
     * @param heroes the heroes to inspect
     * @param index the current index
     * @return the total strength from index onward
     */
    private static double totalStrength(Superhero[] heroes, int index) {
        if (index == heroes.length) {
            return 0.0;
        }

        return heroes[index].getAlliance().getStrength()
            + totalStrength(heroes, index + 1);
    }

    /**
     * Recursively swaps heroes at both ends of the active range.
     *
     * @param heroes the array being reversed
     * @param left the current left index
     * @param right the current right index
     */
    private static void flip(Superhero[] heroes, int left, int right) {
        if (left >= right) {
            return;
        }

        Superhero temp = heroes[left];
        heroes[left] = heroes[right];
        heroes[right] = temp;
        flip(heroes, left + 1, right - 1);
    }
}
