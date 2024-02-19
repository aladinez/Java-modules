package Java_Module00.ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String week;
        boolean delimiter = true;
        int grade = 9;

        for (int i = 0; sc.hasNextLine() && i < 18; i++) {
            week = sc.nextLine();
            System.out.println("Week : " + week);
            if (week.equals("42")){
                break;
            }
            // sc.useDelimiter(" ");
            for (int j = 0; j < 5; j++) {
                int tmpGrade = sc.nextInt();
                System.out.println("tmp grade : " + tmpGrade);
                if (tmpGrade < grade)
                grade = tmpGrade;
            }
            
            System.out.println("Week | ");
            for (int a = 0; a < grade; a++) {
                System.out.print("=");
            }
            System.out.println(">");
            // sc.close();
            // sc = new Scanner(System.in);
            
            

        }
        sc.close();
    }
}
