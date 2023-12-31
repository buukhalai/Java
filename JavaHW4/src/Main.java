import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static String medicTreatType = "";
    public static int[] heroesHealth = {250, 260, 270};
    public static int[] heroesDamage = {20, 15, 25};

    public static int medicHealth = 500;
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic"x};
    public static int roundNumber = 0;

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
        treatmentFromMedic();
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
        for (int i = 0; i < heroesHealth.length; i++) {
            if (bossHealth > 0) {
                if (heroesHealth[i] < bossDamage) {
                    heroesHealth[i] = 0;
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
        int randomIndex = r.nextInt(heroesAttackType.length);
        medicTreatType = heroesAttackType[randomIndex];
        for (int i = 0; i < heroesHealth.length; i++) {
            if (medicHealth > 0 && heroesHealth[i] < 100 && heroesHealth[i] > 0) {
                heroesHealth[i] += 50;
                System.out.println("Medic treat: " + medicTreatType + " " + heroesHealth[i]);
                break;
            }
        }
    }

    public static void treatmentFromMedic() {

        for (int i = 0; i < heroesHealth.length; i++) {

            int treatmentAmount = 50;

            int randomLuck = (int) (Math.random() * heroesHealth.length);

            if (heroesHealth[randomLuck] != heroesHealth[3] && heroesHealth[randomLuck] > 0 && heroesHealth[randomLuck] < 100) {
                heroesHealth[randomLuck] += treatmentAmount;

                heroesHealth[3] -= treatmentAmount;
                System.out.println("___");
                System.out.println(heroesAttackType[randomLuck] + " gets treatment from Medic + " + treatmentAmount);
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