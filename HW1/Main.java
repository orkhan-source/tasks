package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int rowIndex = rand.nextInt(0, 2);
        int columnIndex = rand.nextInt(0, 5);

        int[][] numbersForGuessing = {{1896, 1991, 1904, 1865, 1914}, {1895, 1821, 1776, 1961, 1980}};
        String[][] informationForGuessing = {{"First modern Olympic Games held at Athens",
                "Dissolution of USSR", "Russiao-Japan war",
                "Assassination of Abraham Lincoln", "Beginning of World War I"},
                {"Roentgen discovered X-Rays", "Death of Napolean",
                        "Declaration of American Independence", "Yuri Gagarin of USSR becomes the first spaceman",
                        "War starts between Iran and Iraq, Ronald Reagon elected USA President"}};

        String userName;
        String userInputstr = "";
        boolean checker = false;
        int[] userInputs = new int[100];
        int userInput;

        System.out.println("Enter your name for starting: ");
        userName = sc.nextLine();
        System.out.println("Let the game begin!, " + userName + '\n' + "Enter 'q' for exit from game.");


        int loopIndex = 0;
        while (true) {

            System.out.println("\nHint: " + informationForGuessing[rowIndex][columnIndex]);
            System.out.println("Enter number: ");
            userInputstr = sc.nextLine();
            while (userInputstr.equals("q") && Utils.parseStrToInt(userInputstr)) {
                if(userInputstr.equals("q")){
                    checker = true;
                    break;
                }
                System.out.println("Please, enter valid input: ");
                userInputstr = sc.nextLine();
            }

            if(checker){
                break;
            }

            userInput = Integer.parseInt(userInputstr);
            userInputs[loopIndex] = userInput;


            if(userInput == numbersForGuessing[rowIndex][columnIndex]){
                System.out.println("Congratulations, " + userName + "!");
                break;
            }
            else{
                if(userInput > numbersForGuessing[rowIndex][columnIndex]){
                    System.out.println("Your number is too big. Please, try again.");
                }
                else{
                    System.out.println("Your number is too small. Please, try again.");
                }
            }

            loopIndex++;
        }

        if(!checker){
            Utils.sortAndPrint(userInputs, loopIndex);
        }else
            System.out.println("Bye, see  you soon!");
    }
}