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
            for (; query != 0; query /= 10){
                sumOfDigits += query % 10;
            }

            // is Prime
            int is_prime = 1;
            if (sumOfDigits % 2 == 0){
                continue;
            }
            for (int i = 3; i * i <= sumOfDigits; i += 2){
                if (sumOfDigits % i == 0){
                    is_prime = 0;
                    break;
                }
            }
            if (is_prime == 1)
                coffees++;
        }
        sc.close();
        System.out.println("Count of coffee-request : " + coffees);
    }
}
