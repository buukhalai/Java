public class Main {
    public static void main(String[] args) {

        int temperatura = 40;
        boolean isRainy = true;

        if(temperatura>15 && temperatura<35){
            System.out.println("go to walk");
        }
        if(temperatura<15 || isRainy){
            System.out.println("Stay home");
        }
        if(!isRainy){
            System.out.println("Do not take umbrella");
        }
        


    }
}