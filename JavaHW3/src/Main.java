public class Main {
    public static void main(String[] args) {

        boolean negativeNum = false;
        double summa = 0;
        int count = 0;

        double arr[] = {1.5, 4.5, -4.6, 2.3, 3.3, -2.2, 4.4, 5.3, 9.5, -9.6, 8.5, 7.5, 0.5, -10.5, 5.5};

       for (double v : arr) {
            if (negativeNum && v > 0) {
                summa += v;
                count++;
                //System.out.println(v);
            }

            if (v < 0) {
                negativeNum = true;
            }
        }
        if (count > 0) {
            System.out.println(summa / count);
        } else {
            System.out.println("There is no positive number");
        }
        System.out.println("/%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        int arr2[] = {2, 5, 4, 3, 1, 6};
        System.out.print("Before sorting: ");
        printArray(arr2);

        for(int i = 0; i<arr2.length; i++){
            for(int j = i; j<arr2.length; j++){
                if(arr2[j]<arr2[i]){
                    int a = arr2[j];
                    arr2[j] = arr2[i];
                    arr2[i] = a;
                }
            }
            System.out.print("After sorting " + (i + 1) + ": ");
            printArray(arr2);
        }
    }
    public static void printArray(int [] arr2){
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}