import java.util.Random;

public class Collection {
    private Card[] binder;
    private int cardsOwned;

    public Collection(Card[] binder) {
        this.binder = binder.clone();

        int cnt = 0;
        for (Card c : binder) {
            if (c != null) {
                cnt++;
            }
        }

        this.cardsOwned = cnt;
    }

    public Collection() {
        this.binder = new Card[4];
        this.cardsOwned = 0;
    }

    public Card addCard(int index, Card newCard) {
        if (index >= this.binder.length || index < 0 || newCard == null) {
            System.out.println("Cannot add a card to this spot.");
            return null;
        } else if (this.binder[index] != null) {
            Card old = this.binder[index];
            this.binder[index] = newCard;
            System.out.println("Replaced: " + old.toString());
            return old;
        } else {
            this.binder[index] = newCard;
            System.out.println("Inserted: " + newCard.toString());
            this.cardsOwned++;
            return null;
        }
    }

    public Card sellCard(int index) {
        if (index >= this.binder.length || index < 0 || this.binder[index] == null) {
            System.out.println("There was no card to sell!");
            return null;
        } else {
            Card old = this.binder[index];
            System.out.println("Sold: " + old.toString());
            this.binder[index] = null;
            this.cardsOwned--;
            return old;
        }
    }

    public void showCertainCards(int thres) {
        int cnt = 0;
        for (Card c : this.binder) {
            if (c != null && c.getCondition() > thres) {
                cnt++;
                System.out.println(c.toString());
            }
        }
    }

    public void restoreAllCards() {
        int cnt = 0;
        Random rand = new Random();

        for (Card c : this.binder) {
            int res = rand.nextInt(10) + 1;

            if (c != null && c.isRestorable()) {
                int oldcond = c.getCondition();
                int newcond = Math.min(100, oldcond + res);
                System.out.printf("Restored to %d: %s\n", newcond, c.toString());
                cnt++;
                c.setCondition(newcond - oldcond);
            }
        }

        if (cnt == 0) {
            System.out.println("There were no cards to restore.");
        }
    }

    public void battle(int index) {
        Random rand = new Random();
        if (index < 0 || index >= this.binder.length || this.binder[index] == null) {
            System.out.println("Cannot battle with a card at this spot.");
        } else {
            int damage = rand.nextInt(10) + 1;
            Card c = this.binder[index];
            int newcond = c.getCondition() - damage;

            if (newcond < 40) {
                newcond = 40;
            }

            c.setCondition(newcond - c.getCondition());

            System.out.println("Used: " + c.toString());
        }
    }

    public String toString() {
        if (this.cardsOwned == 0) {
            return "I own no cards!";
        } else {
            String ret = String.format("I own %d cards.\n", this.cardsOwned);
            for (Card c : this.binder) {
                if (c != null) {
                    ret += c.toString();
                    ret += "\n";
                }
            }
            return ret.trim();
        }
    }
}