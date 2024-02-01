package Java_Module00.ex02;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int query = sc.nextInt();
        int coffees = 0;

        for (; query != 42; query = sc.nextInt()){
            // sum of digits
            int sumOfDigits = 0;
            for (; query > 10; query /= 10){
                sumOfDigits += query % 10;
            }
            sumOfDigits += query;
            System.out.println("sum of digits : " + sumOfDigits);

            // is Prime
            if (sumOfDigits % 2 == 0){
                sc.close();
                continue;
            }
            for (int i = 3; i * i <= sumOfDigits; i += 2){
                if (sumOfDigits % i == 0){
                    sc.close();
                    continue;
                }
            }
            coffees++;
        }
        sc.close();
        System.out.println("Count of coffee-request : " + coffees);
    }
}
