/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21sticksversionmperdema;

import java.util.Scanner;

/**
 *
 * @author N1CO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Go 1st? y/n?");
        Scanner input = new Scanner(System.in);
        String first = input.nextLine();

        int toTake = 0;
        int sticksCount = 21;
        boolean evaluateEnd = false;

        while (sticksCount > 0) {
            if (first.equals("y") || first.equals("Y")) {
                System.out.println("there are " + sticksCount + " sticks");
                System.out.println("How many do you want to take? 1 or 2?");

                int toTake = askUserForSticks(sticksCount);
                sticksCount(toTake);

                if (evaluateEnd) {
                    System.out.println("You Lost!");
                } else {
                    cpuEvaluateMove(toTake);
                    sticksCount(toTake);

                    System.out.println("CPU takes " + toTake + " sticks. Your turn");

                    if (evaluateEnd) {
                        System.out.println("You win ! ! !");
                    }
                }
            } else {
                cpuEvaluateMove(sticksCount);
                sticksCount(toTake);

                System.out.println("CPU took " + toTake + "sticks");

                if (evaluateEnd) {
                    System.out.println("You Win ! ! !");
                } else {
                    System.out.println("there are " + sticksCount + " sticks");
                    System.out.println("How many you want to take? 1 or 2?");
                    askUserForSticks(sticksCount);
                    sticksCount(toTake);
                    int cpuEvaluateMove = cpuEvaluateMove(toTake);

                    if (evaluateEnd) {
                        System.out.println("You lost!");
                    }
                }
            }

        }

    }

    public int askUserForSticks(sticksCount) {

        int toTake;
        Scanner take = new Scanner(System.in);

        toTake = take.nextInt();
        return toTake;
    }

    public int sticksCount(toTake) {
        int sticksCount;
        int toTake;
        if (toTake > 2) {
            toTake = 2;
        } else if (toTake < 1) {
            toTake = 1;
        }
        sticksCount = sticksCount - toTake;
        return sticksCount;
    }

    boolean evaluateEnd(sticksCount
        
            ) {
        int sticksCount;
        return sticksCount <= 0;
    }

    public int cpuEvaluateMove(sticksCount
        
            ) {
        int sticksCount;
        int toTake = 1;
        if ((sticksCount - 2) % 3 == 0 || sticksCount - 2 == 0) {
            toTake = 1;
        } else {
            toTake = 2;
        }
        return toTake;
    }

}
