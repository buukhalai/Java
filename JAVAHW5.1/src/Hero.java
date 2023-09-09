public class Hero {
    private int heroHealth;
    private int heroDamage;
    private String superPower;

    public Hero(int heroHealth, int heroDamage, String superPower){
        this.heroDamage = heroDamage;
        this.heroHealth = heroHealth;
        this.superPower = superPower;
    }
    public Hero(int heroHealth, int heroDamage){
        this.heroDamage = heroDamage;
        this.heroHealth = heroHealth;
    }

    public int getHeroHealth() {
        return heroHealth;
    }

    public int getHeroDamage() {
        return heroDamage;
    }

    public String getSuperPower() {
        return superPower;
    }
}
