package l07_dynamicPrograming;

import java.util.Arrays;
import java.util.Scanner;

public class p04_rodCutting {
    public static int[] bestPrices;
    public static int[] prevIndex;
    public static int[] prices;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        prices = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int length = Integer.parseInt(scan.nextLine());

        bestPrices = new int[length + 1];
        prevIndex = new int[length + 1];

        int maxProfit = cutRope(length);

        System.out.println(maxProfit);
        reconstructionSolution(length);
    }

    private static int cutRope(int length) {
        if (length == 0) {
            return 0;
        }
        if (bestPrices[length] != 0) {
            return bestPrices[length];
        }
        int currentBest = bestPrices[length];

        for (int i = 1; i <= length; i++) {
            currentBest = Math.max(currentBest, prices[i] + cutRope(length - i));
            if (currentBest > bestPrices[length]) {
                bestPrices[length] = currentBest;
                prevIndex[length] = i;
            }
        }
        return bestPrices[length];
    }

    private static void reconstructionSolution(int n) {
        while (n - prevIndex[n] != 0) {
            System.out.print(prevIndex[n] + " ");
            n = n - prevIndex[n];
        }
        System.out.println(prevIndex[n]);
    }
}
