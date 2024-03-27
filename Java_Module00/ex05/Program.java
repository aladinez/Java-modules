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
                return i;
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

    public static int[] getDaysInMonthFromDayOfWeek(int dayIndex) {
        int[] daysInMonth = new int[5];
        // September 1, 2020 was a Tuesday (dayIndex = 1)
        if (dayIndex == 0) {
            dayIndex += 7;
        }
        for (int i = 0; i < 5 && dayIndex <= 30; i++) {
            daysInMonth[i] = dayIndex;
            dayIndex += 7;
        }

        return daysInMonth;
    }

    public static void printSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    public static void printPopulationTable(String[] studentsNames, int[][][] attendance) {
        String[] clockTimes = {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00"};
        String[] weekDays = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
        int i = 0;
        printSpaces(10);
        for (int j = 0; j < 30; j++) {
            for (int k = 0; k < 6; k++) {
                if (attendance[i][j][k] == 1) {
                    String buffer = clockTimes[k] + " " + weekDays[(j + 1) % 7] + " " + (j + 1) + "|";
                    printSpaces(11 - buffer.length());
                    System.out.print(buffer);
                }
            }
        }
        System.out.println();

        for(i = 1; i < 10 && studentsNames[i - 1] != null; i++) {

            System.out.print(studentsNames[i - 1]);
            printSpaces(10 - studentsNames[i - 1].length());
            for (int j = 0; j < 30; j++) {
                for (int k = 0; k < 6; k++) {
                    if (attendance[0][j][k] == 1 && attendance[i][j][k] == 1) {
                        printSpaces(11 - "1|".length());
                        System.out.print("1|");
                    }
                    else if (attendance[0][j][k] == 1 && attendance[i][j][k] == 2) {
                        printSpaces(11 - "-1|".length());
                        System.out.print("-1|");
                    }
                    else if (attendance[0][j][k] == 1){
                        printSpaces(11 - "|".length());
                        System.out.print("|");
                    }
                }
            }
            System.out.println();
        }
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
            int[] allDaysOfMonthfromDayOfWeek = getDaysInMonthFromDayOfWeek(dayIndex);

            // fill the attendance array
            for (int j = 0; j < 5; j++) {
                if (allDaysOfMonthfromDayOfWeek[j] != 0)
                    attendance[0][allDaysOfMonthfromDayOfWeek[j] - 1][timeIndex] = 1;
            }
        }

        // scan attendances of the students in the 3d array, input will be the name of student, then time, then day of month, then here or not here like "Mike 2 28 NOT_HERE", "John 4 9 HERE"
        for (; ; ) {
            String studentName = scanner.next();
            if (studentName.equals(".")) {
                break;
            }
            int studentIndex = getStudentIndex(studentName, studentsNames);
            //print student index and name
            // System.out.println(studentIndex + " " + studentName);
            int timeIndex = scanner.nextInt();
            int dayIndex = scanner.nextInt();
            String hereOrNotHere = scanner.next();
            if (hereOrNotHere.equals("HERE")) {
                attendance[studentIndex + 1][dayIndex - 1][timeIndex - 1] = 1;
            } else {
                attendance[studentIndex + 1][dayIndex - 1][timeIndex - 1] = 2;
            }
        }
        // print population table 
        printPopulationTable(studentsNames, attendance);
        

        scanner.close();
    }
}
