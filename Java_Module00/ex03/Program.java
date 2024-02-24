package Java_Module00.ex03;

import java.util.Scanner;

public class Program {

    public static long extractDigit(long gradesArray, int i)
    {
        long digit = (gradesArray >> (i * 4)) & 0b1111;
        System.out.println("Digit : " + digit);
        printBinary((gradesArray >> (i * 4)));
        return  digit;
    }
    
    public static  long storeDigit(long gradesArray,int grade, int i)
    {
        gradesArray = (gradesArray << 4) | grade;
        printBinary(gradesArray);
        return gradesArray;
    }

    public static void printBinary(long gradesArray)
    {
        String binaryString = Long.toBinaryString(gradesArray);

        // print leading zeros
        System.out.print("In binary :" + Long.numberOfLeadingZeros((long)gradesArray) );
        for(int i = 0; i < Long.numberOfLeadingZeros(gradesArray); i++) {
            System.out.print('0');
        }
        System.out.println(binaryString);
        // while(temp.length() < 32) {
        //     temp = "0" + temp;
        // }
        // System.out.println("Binary representation of " + gradesArray + ": " + temp);
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
            for (int j = 0; j < 9; j++) {
                int tmpGrade = sc.nextInt(); // read grades
                if (tmpGrade < grade)
                    grade = tmpGrade;

                System.out.println("Grade : " + tmpGrade + "iteration : " + j);
                gradesArray = storeDigit(gradesArray, tmpGrade, i);
            }
            // extract digits stored in gradesArray
            for (int j = 8; j >= 0; j--) {
                long digit = extractDigit(gradesArray, j);
            }
            break;
            // System.out.println("Grade : " + grade);
            // gradesArray = storeDigit(gradesArray, grade, i);
            // sc.nextLine(); // ignore new line in buffer.
        }
        sc.close();
        // for (int a = 0; a < grade; a++) {
        //     System.out.print("=");
        // }
        // System.out.println(">");
    }
}
