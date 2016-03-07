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
        int sticks = 21;
        boolean evaluateEnd = false;

        while (sticks > 0) {
            if (first.equals("y") || first.equals("Y")) {
                System.out.println("there are " + sticks + " sticks");
                System.out.println("How many do you want to take? 1 or 2?");

                int Take = askUserForSticks();
                sticks = sticksCount(Take);

                if (evaluateEnd) {
                    System.out.println("You Lost!");
                } else {
                    cpuEvaluateMove(Take);
                    sticks = sticksCount(Take);

                    System.out.println("CPU takes " + toTake + " sticks.");

                    if (evaluateEnd) {
                        System.out.println("You win ! ! !");
                    }
                }
            } else {
                cpuEvaluateMove(sticks);
                sticks = sticksCount(toTake);

                System.out.println("CPU took " + toTake + "sticks");

                if (evaluateEnd) {
                    System.out.println("You Win ! ! !");
                } else {
                    System.out.println("there are " + sticks + " sticks");
                    System.out.println("How many do you want to take? 1 or 2?");

                    askUserForSticks();
                    sticks = sticksCount(toTake);

                    cpuEvaluateMove(sticks);

                    if (evaluateEnd) {
                        System.out.println("You lost!");
                    }
                }
            }

        }

    }

    public static int askUserForSticks() {

        Scanner take = new Scanner(System.in);
        int toTake = take.nextInt();
        return toTake;
    }

    public static int sticksCount(int t) {
        int sticksCount;
        int toTake=0;
        if (t > 2) {
            toTake = 2;
        } else if (t
                < 1) {
            toTake = 1;
        }
        sticksCount = sticks - toTake;
        return sticksCount;
    }

    boolean evaluateEnd(int s) {
        return s <= 0;
    }

    public static int cpuEvaluateMove(int a
    ) {
        int toTake;
        if ((a - 2) % 3 == 0 || a - 2 == 0) {
            toTake = 1;
        } else {
            toTake = 2;
        }

        return toTake;
    }

}
