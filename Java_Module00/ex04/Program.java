package Java_Module00.ex04;

import java.util.Scanner;

public class Program {

    public static int height(int occurence, int coefficient) {
        return occurence * coefficient;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        char[] characters;
        int[] charOccurences = new int[127];
        int[] mostFrequentCharacters = new int[10];
        int[] occurences = new int[10];

        // scan input
        input = sc.nextLine();
        sc.close();

        // convert input to char array
        characters = input.toCharArray();

        // count occurences of each character
        for (int i = 0; i < characters.length; i++) {
            charOccurences[characters[i]]++;
        }
        
        // print occurences of each character
        for (int i = 0; i < charOccurences.length; i++) {
            if (charOccurences[i] > 0) {
                System.out.println((char) i + " " + charOccurences[i]);
            }
        }

        // extract the most 10 frequent characters
        for (int i = 0; i < 10; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < charOccurences.length; j++) { // get the most frequent character
                if (charOccurences[j] > max) {
                    max = charOccurences[j];
                    index = j;
                }
            }
            if (max > 0) { // store and reset the most frequent character to 0.
                mostFrequentCharacters[i] = index;
                occurences[i] = charOccurences[index];
                charOccurences[index] = 0;
            }
        }

        // print the most 10 frequent characters
        for (int i = 0; i < 10; i++) {
            if (mostFrequentCharacters[i] > 0) {
                System.out.println("==>" + (char) mostFrequentCharacters[i] + " " + occurences[i]);
            }
        }
        // calculate coefficient
        float coefficient =  10 / occurences[0];
        int [] tmpOccurences = new int[10];
        for (int i = 0; i < 10; i++) {
            tmpOccurences[i] = occurences[i];
        }
        
        // TODO: print the most 10 frequent characters in histogram format
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                if (tmpOccurences[j] * coefficient == occurences[j]) {
                    System.out.print(occurences[j] + "  ");
                    tmpOccurences[j]--;
                }
                else if (tmpOccurences[j] * coefficient < occurences[j]) {
                    System.out.print("#  ");
                    tmpOccurences[j]--;
                }
                if (i == 11) {
                    System.out.print((char) mostFrequentCharacters[j] + "  ");
                }
                
            }
            System.out.println();
        }
    }
}
