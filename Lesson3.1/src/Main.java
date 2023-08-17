public class Main {
    public static void main(String[] args) {

        int[] arr = {8, 0, -3, 4, 11};

        System.out.println(arr[2]);

        String s = "a";
        while(s.length()<10){
            s+= "a";
            System.out.println(s);
        }
        for(int i = 0; i<5;i++){
            System.out.println("drausennnn "+i );
            if(i==1){
                continue;
            }
            for(int j = 0; j<3;j++){
                System.out.println("inner " + j);
                if(j>2){
                    break;
                }
            }
        }
    }
    public static void test(int age){

    }
}