import static java.lang.Math.random;

public class Stats5 {
    public static void main(String[] args) {
        Double[] arr = new Double[5];
        for (int i=0; i<5; i++) {
            arr[i] = random();
        }
        for (int i=0; i<5; i++) {
            System.out.println(arr[i]);
        }
        double Max = -1;
        double Min = 2;
        double Sum = 0;
        for (int i=0; i<5; i++) {
            Sum += arr[i];
            if (arr[i] > Max) {
                Max = arr[i];
            }
            if (arr[i] < Min) {
                Min = arr[i];
            }
        }
        double average = Sum/5;
        System.out.println("Average = " + average);
        System.out.println("Max     = " + Max);
        System.out.println("Min     = " + Min);
    }
}