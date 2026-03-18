public class Card {
    private int hitpoints;
    private String pokemonName;
    private PokemonType pokemonType;
    private String attack;
    private int condition;

    public Card(int hitpoints, String pokemonName, PokemonType pokemonType, String attack, int condition) {
        this.hitpoints = hitpoints;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.attack = attack;

        if (condition <= 100 && condition >= 90) {
            this.condition = condition;
            System.out.println("Card condition: Mint");
        } else if (condition <= 89 && condition >= 80) {
            this.condition = condition;
            System.out.println("Card condition: Excellent");
        } else if (condition <= 79 && condition >= 70) {
            this.condition = condition;
            System.out.println("Card condition: Very Good");
        } else if (condition <= 69 && condition >= 60) {
            this.condition = condition;
            System.out.println("Card condition: Good");
        } else if (condition <= 59 && condition >= 50) {
            this.condition = condition;
            System.out.println("Card condition: Fine");
        } else if (condition <= 49 && condition >= 40) {
            this.condition = condition;
            System.out.println("Card condition: Damaged");
        } else {
            this.condition = 80;
            System.out.println("Card condition: Excellent");
        }
    }

    public Card(int hitpoints, String pokemonName, PokemonType pokemonType) {
        this(hitpoints, pokemonName, pokemonType, "Hyperbeam", 80);
    }

    public Card() {
        this(120, "Ditto", PokemonType.NORMAL, "Imposter", 89);
    }

    public boolean isRestorable() {
        return (this.condition >= 50 && this.condition <= 89);
    }

    public String toString() {
        return String.format("<%d,%s,%s,%s,%d,%b>", this.hitpoints, this.pokemonName, this.pokemonType.name(),
            this.attack, this.condition, this.isRestorable());
    }

    public int hitpoints() {
        return this.hitpoints;
    }

    public String pokemonName() {
        return this.pokemonName;
    }

    public PokemonType pokemonType() {
        return this.pokemonType;
    }

    public String attack() {
        return this.attack;
    }

    public int getCondition() {
        return this.condition;
    }

    public void setCondition(int d) {
        int newv = this.condition + d;
        if (newv >= 40 && newv <= 100) {
            this.condition = newv;
        }
    }

}