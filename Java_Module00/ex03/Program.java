package Java_Module00.ex03;

import java.util.Scanner;

public class Program {
    
    public static  long storeDigit(long gradesArray,int grade, int i)
    {
        String binaryString = Long.toBinaryString(gradesArray);
        System.out.println("Before : Binary representation of " + gradesArray + ": " + binaryString);
        gradesArray = (gradesArray << 4) | grade;
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String week;
        int grade;
        long gradesArray = 0;

        for (int i = 0; i < 18; i++) {
            grade = 9; // initialize grade with max value
            week = sc.nextLine(); //read weeks
            // System.out.println("Week : " + week);
            if (week.equals("42")){
                break;
            }
            // check the order of data entered
            if (!week.equals("Week " + (i + 1)))
            {
                System.err.println("IllegalArgument");
                return;
            }
            for (int j = 0; j < 5; j++) {
                int tmpGrade = sc.nextInt(); // read grades
                // System.out.println("tmp grade : " + tmpGrade);
                if (tmpGrade < grade)
                    grade = tmpGrade;
                // TDOD : save grade for the current week
            }
            gradesArray = storeDigit(gradesArray, grade, i);
            sc.nextLine(); // ignore new line in buffer.
            // System.out.println("Week | ");
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
