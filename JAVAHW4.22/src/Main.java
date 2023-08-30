import java.util.Random;

public class Main {
    public static int bossHealth = 1000;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int medicTreatType = 0;
    public static int[] heroesHealth = {250, 260, 270, 300, 280, 290};
    public static int[] heroesDamage = {20, 15, 25, 2, 10, 5};

    public static int medicHealth = 500;
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Golem", "Lucky", "Berseck", "Thor"};
    public static int roundNumber = 0;
    public static int berseckHits = 0;

    public static void main(String[] args) {
        System.out.println("Game start");
        printStatistics();
        while (!isGameFinish()) {
            roundNumber++;
            System.out.println("Round " + roundNumber);
            round();
        }

    }

    public static void changeBossDefence() {
        Random r = new Random();
        int randomIndex = r.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[randomIndex];
        System.out.println("Boss choose " + bossDefenceType);

    }

    public static void round() {
        changeBossDefence();
        medicTreat();
        heroesHit();

        if (bossHealth > 0) {
            bossHits();
        }

        printStatistics();


    }

    public static boolean isGameFinish() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHearoesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHearoesDead = false;
                break;
            }
        }
        if (allHearoesDead) {
            System.out.println("Boss won!!!");
        }
        return allHearoesDead;
    }

    public static void bossHits() {
        medicHealth = medicHealth - bossDamage;
        Random r = new Random();
        int l = r.nextInt(2);

        for (int i = 0; i < heroesHealth.length; i++) {
            if (bossHealth > 0) {
                if (heroesHealth[i] < bossDamage) {
                    heroesHealth[i] = 0;
                    //Golem
                } else if (heroesAttackType[i] == "Golem") {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                    heroesHealth[3] += (bossDamage / 5);
                } else if (heroesAttackType[i] == "Lucky" && l == 1) {
                    continue;
                } else if (heroesAttackType[i] == "Berseck") {
                    int n = bossDamage - 20;
                    heroesHealth[5] -= n;
                    berseckHits += 20;
                    System.out.println("Berseck's points " + berseckHits);
                    if (bossDefenceType == "Berseck") {
                        System.out.println("Berseck Hits with point:" + berseckHits);
                        bossHealth -= berseckHits;
                    } else if (bossDefenceType == "Thor") {
                        if (l == 0) {
                            bossHealth -= bossHealth;
                            System.out.println("Boss dead " + bossHealth);
                        }
                    }

                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }

    }

    public static void heroesHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (bossHealth > 0) {
                    if (bossDefenceType == heroesAttackType[i]) {
                        Random r = new Random();
                        int coef = r.nextInt(8) + 2;//2, 3, 4, 5, 6, 7, 8, 9
                        if (bossHealth - heroesDamage[i] * coef < 0) {
                            bossHealth = 0;
                        } else {
                            bossHealth = bossHealth - heroesDamage[i] * coef;
                        }
                        System.out.println("Critical attack: " + heroesDamage[i] * coef);
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void medicTreat() {
        Random r = new Random();
        int randomIndex = r.nextInt(heroesHealth.length);
        medicTreatType = heroesHealth[randomIndex];
        for (int i = 0; i < heroesHealth.length; i++) {
            if (medicHealth > 0 && medicTreatType < 100 && medicTreatType > 0) {
                heroesHealth[randomIndex] += 50;
                System.out.println("Medic treat: " + heroesAttackType[randomIndex] + " " + heroesHealth[randomIndex]);
                break;
            }
        }
    }

    public static void printStatistics() {
        System.out.println("_________________________");

        System.out.println("Boss Health: " + bossHealth);

        System.out.println("medicHealth: " + medicHealth);

        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + ": Health " + heroesHealth[i]);
        }
        System.out.println("_________________________");
    }
}