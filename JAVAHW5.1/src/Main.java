

public class Main {
    public static void main(String[] args) {

        Boss boss = new Boss();
        boss.setBossHealth(700);
        boss.setBossDamage(50);
        boss.setBossDefenceType("Mag ");


        System.out.println("Both health: " + boss.getBossHealth() + ", Boss damage: " + boss.getBossDamage() +
                ", boss defence type: " + boss.getBossDefenceType());


        Hero[] heroes = createHeroes();
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getSuperPower() + " "+
                    heroes[i].getHeroDamage() +" "+ heroes[i].getHeroHealth());
        }
    }

    public static Hero[] createHeroes() {
        Hero mag = new Hero(200, 20, "Magic");
        Hero golem = new Hero(220, 15);
        Hero lucky = new Hero(210, 10, "Lucky");

        Hero [] heroes = {mag, golem, lucky};

        return heroes;
    }
}