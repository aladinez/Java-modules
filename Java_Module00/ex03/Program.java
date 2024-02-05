package Java_Module00.ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String week = sc.nextLine();
        boolean delimiter = true;
        int grade = 9;

        for (int i = 0; delimiter || i < 18; i++) {
            week = sc.nextLine();
            if (week.equals("42")){
                break;
            }
            sc.useDelimiter(" ");
            for (int j = 0; j < 5; j++) {
                int tmpGrade = sc.nextInt();
                if (tmpGrade < grade)
                grade = tmpGrade;
            }
            System.out.print("Week | ");
            for (int a = 0; a < grade; a++) {
                System.out.print("=");
            }
            System.out.print(">");
            sc.close();
            sc = new Scanner(System.in);

        }
        sc.close();
    }
}
