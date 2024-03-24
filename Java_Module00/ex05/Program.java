package Java_Module00.ex05;

import java.util.Scanner;

public class Program {

    public static int getDayIndex(String timeAndDay) {
        String[] weekDays = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
        char[] timeAndDayChars = timeAndDay.toCharArray();
        if (timeAndDay.length() < 3) {
            return -1;
        }
        for (int i = 0; i < weekDays.length; i++) {
            char[] day = weekDays[i].toCharArray();
            if (day[0] == timeAndDayChars[2] && day[1] == timeAndDayChars[3]) {
                return i;
            }
        }
        return -1;
    }

    public static int getTimeIndex(String timeAndDay) {
        char[] times = {'1', '2', '3', '4', '5', '6'};
        char[] timeAndDayChars = timeAndDay.toCharArray();
        if (timeAndDay.length() < 3) {
            return -1;
        }
        for (int i = 0; i < times.length; i++) {
            if (times[i] == timeAndDayChars[0]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int getStudentIndex(String studentName, String[] studentsNames) {
        for (int i = 0; i < studentsNames.length; i++) {
            if (studentsNames[i] != null && studentsNames[i].equals(studentName)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String studentsNames[] = new String[10];
        // 3d array for attendance 10 students, 30 days, 6 classes
        int[][][] attendance = new int[11][30][6]; // 11 because the first index is for the population of the classes.

        // scan students names
        for (int i = 0; i < 10; i++) {
            String name = scanner.nextLine();
            if (name.equals(".")) {
                break;
            }
            studentsNames[i] = name; // the index of the student name is the same in the attendance array
        }

        // scan time and day of the week
        for (int i = 0; i < 10; i++) {
            String timeAndDay = scanner.nextLine();
            if (timeAndDay.equals(".")) {
                break;
            }
            // time and day is in the format "2 MO", "4 WE"
            int timeIndex = getTimeIndex(timeAndDay);
            int dayIndex = getDayIndex(timeAndDay);
            // fill the attendance array
            attendance[0][dayIndex][timeIndex] = 1;
        }

        // scan attendances of the students in the 3d array, input will be the name of student, then time, then day of month, then here or not here like "Mike 2 28 NOT_HERE", "John 4 9 HERE"
        for (; ; ) {
            String studentName = scanner.next();
            if (studentName.equals(".")) {
                break;
            }
            int studentIndex = getStudentIndex(studentName, studentsNames);
            int timeIndex = scanner.nextInt();
            int dayIndex = scanner.nextInt();
            String hereOrNotHere = scanner.next();
            if (hereOrNotHere.equals("HERE")) {
                attendance[studentIndex + 1][dayIndex][timeIndex] = 1;
            } else {
                attendance[studentIndex + 1][dayIndex][timeIndex] = 2;
            }
        }

        // pretty print the attendance of all students 
        for (int i = 0; i < 10; i++) {
            System.out.println(studentsNames[i]);
            for (int j = 0; j < 30; j++) {
                System.out.print(j + 1 + " ");
                for (int k = 0; k < 6; k++) {
                    if (attendance[i + 1][j][k] == 1) {
                        System.out.print("X ");
                    } else if (attendance[i + 1][j][k] == 2) {
                        System.out.print("0 ");
                    }
                    else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }
        }
    }
}
