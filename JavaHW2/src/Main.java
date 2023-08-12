import java.util.Random;
public class Main {
    public static void main(String[] args) {



        System.out.println(metod1(15,5));
        System.out.println(metod1(35,15));
        System.out.println(metod1(46,20));
        System.out.println(metod1(55,50));

        System.out.println(generateRandomAge());
        System.out.println(metod1(generateRandomAge(), 26));

    }
    public static String metod1(int age, double temperature){
        if(age > 20 && age < 40 && temperature>-20 && temperature<30)
            return "Можно идти гулять";

        else if(age < 20 && temperature>0 && temperature<28)
            return "Можно идти гулять";

        else if(age > 45 && temperature>-10 && temperature<25)
            return "Можно идти гулять";
        else
        return "Оставайтесь дома";
    }
    public static int generateRandomAge(){
        Random random = new Random();
        return random.nextInt(100);
    }
}