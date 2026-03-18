public class Driver {

    public static void main(String[] args) {

        Collection myCollection = new Collection(new Card[4]);

        Card card1 = new Card(12, "Blastoise",
                PokemonType.WATER, "Quick", 50);

        Card card2 = new Card(34, "Sandshrew",
                PokemonType.GROUND, "Fast", 80);

        Card card3 = new Card();

        myCollection.addCard(0, card1);
        myCollection.addCard(1, card2);
        myCollection.addCard(2, card3);

        System.out.println("\n--- After Adding ---");
        System.out.println(myCollection);

        myCollection.sellCard(1);

        System.out.println("\n--- After Selling ---");
        System.out.println(myCollection);

        System.out.println("\n--- Showing Cards Above 85 ---");
        myCollection.showCertainCards(85);


        System.out.println("\n--- Restoring Cards ---");
        myCollection.restoreAllCards();

        System.out.println("\n--- After Restoring ---");
        System.out.println(myCollection);

        System.out.println("\n--- Battle ---");
        myCollection.battle(0);

        System.out.println("\n--- After Battle ---");
        System.out.println(myCollection);
    }
}