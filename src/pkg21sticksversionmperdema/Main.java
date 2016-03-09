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

        int sticks=21;
        
        System.out.println("Go 1st? y/n?");
        Scanner input = new Scanner(System.in);
        String first = input.nextLine();

        while (sticks > 0) {
            if (first.equals("y") || first.equals("Y")) {
                System.out.println("There are " + sticks + " sticks");
                System.out.println("How many do you want to take? 1 or 2?");

                int take = askUserForSticks();
                int toTake = takeCheck(take);
                sticks = sticksCount(toTake, sticks);

                if (evaluateEnd(sticks)) {
                    System.out.println("You Lost!");
                } else {
                    take = cpuEvaluateMove(sticks);
                    sticks = sticksCount(take, sticks);

                    System.out.println("CPU takes " + take + " sticks.");

                    if (evaluateEnd(sticks)) {
                        System.out.println("You win ! ! !");
                    }
                }
            } else {
                int toTake = cpuEvaluateMove(sticks);
                sticks = sticksCount(toTake, sticks);

                System.out.println("CPU takes " + toTake + "sticks");

                if (evaluateEnd(sticks)) {
                    System.out.println("You Win ! ! !");
                } else {
                    System.out.println("there are " + sticks + " sticks");
                    System.out.println("How many do you want to take? 1 or 2?");

                    int take = askUserForSticks();
                    toTake = takeCheck(take);
                    sticks = sticksCount(toTake, sticks);

                    toTake = cpuEvaluateMove(sticks);

                    if (evaluateEnd(sticks)) {
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

    public static int takeCheck(int t) {
        
        if (t > 2) {
            return 2;
        } else if (t
                < 1) {
            return 1;
        }
        return t;
    }

    public static int sticksCount(int t, int s) {
        s = s - t;
        return s;
    }

    public static boolean evaluateEnd(int s) {
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
