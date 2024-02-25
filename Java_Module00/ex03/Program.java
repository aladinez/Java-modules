package Java_Module00.ex03;

import java.util.Scanner;

public class Program {

    public static long extractDigit(long firstGradesArray, int i)
    {
        long digit = (firstGradesArray >> (i * 4)) & 0b1111;
        return  digit;
    }
    
    public static  long storeDigit(long firstGradesArray, long grade)
    {
        firstGradesArray = (firstGradesArray << 4) | grade;
        return firstGradesArray;
    }

    public static void printWeeksGrades(int numOfWeeks, long firstGradesArray, long secondGradesArray) {
        long grade = 0;
        for (int i = 0; i < numOfWeeks; i++) {
            int index = 0;
            if (i < 9)
            {
                if (numOfWeeks < 9)
                    index = numOfWeeks - i - 1;
                else
                    index = numOfWeeks - i - (numOfWeeks - 9) - 1;
                grade = extractDigit(firstGradesArray, index);
            }
            else {
                index = numOfWeeks - i - 1;
                grade = extractDigit(secondGradesArray, index);
            }
            System.out.print("Week " + (i + 1) + " ");
            for (int j = 0; j < grade; j++) {
                System.out.print("=");
            }
            System.out.println(">");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String week;
        long grade = 9;
        int numOfWeeks = 18;
        
        long firstGradesArray = 0; // grades array to store the first 9 weeks grades
        long secondGradesArray = 0; // grades array to store the second 9 weeks grades

        for (int i = 0; i < 18; i++) {
            grade = 9; // initialize grade with max value
            week = sc.nextLine(); //read weeks

            if (week.equals("42")) {
                numOfWeeks = i;
                break;
            }
            // check the order of data entered
            if (!week.equals("Week " + (i + 1))) {
                sc.close();
                System.err.println("IllegalArgument");
                return;
            }
            // iterate over 5 grades and store the lowest.
            for (int j = 0; j < 5; j++) {
                int tmpGrade = sc.nextInt(); // read grades
                if (tmpGrade < grade)
                    grade = tmpGrade;

            }
            // store the grade in the array
            if (i < 9)
                firstGradesArray = storeDigit(firstGradesArray, grade);
            else
                secondGradesArray = storeDigit(secondGradesArray, grade);

            sc.nextLine(); // ignore new line in buffer.
        }
        sc.close();
        // print the grades
        printWeeksGrades(numOfWeeks, firstGradesArray, secondGradesArray);
    }
}
