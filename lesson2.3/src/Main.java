public class Main {

    public static int multiplication(int num1, int num2){
        System.out.println(num1*num2);
        return num1*num2;
    }
    public static void main(String[] args) {

        printPhrases();
        printPhrases();
        printPhrases();
        addition(2, 5, " hi");
        addition(5,6," gmerg");
        int result;
        result = multiplication(2, 3)-multiplication(4,5);
       // result = 6-20;
        System.out.println(result);
        System.out.println(concat("A", "B", 12.4));
        System.out.println("Obem karobki: " +calculateVolume( 2.2, 4.5, 6.5));
    }
    public static void printPhrases(){
        System.out.println("Hello world!");
        System.out.println("aaaa");
        System.out.println("bbbb");
    }
    public static void addition (int num1, int num2, String text){
        System.out.print(num1+num2);
        System.out.println(text);
    }
    public static String concat(String t1, String t2, double number){
        return t1 + " "+t2+ " "+number;
    }

    public  static double calculateVolume( double height, double wight, double length){

        return height*wight*length;
    }

}