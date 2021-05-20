package l07_dynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p02_longestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] sequence = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] length = new int[sequence.length];
        int[] prev = new int[sequence.length];

        Arrays.fill(prev, -1);

        int maxLength = 0, maxIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            int current = sequence[i];
            int bestLength = 1;
            int bestIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[j] < current && length[j] + 1 >= bestLength) {
                    bestLength = length[j] + 1;
                    bestIndex = j;
                }
            }
            prev[i] = bestIndex;
            length[i] = bestLength;
            if (maxLength < bestLength) {
                maxLength = bestLength;
                maxIndex = i;
            }
        }
        List<Integer> LIS = new ArrayList<>();

        int index = maxIndex;
        while (index != -1) {
            LIS.add(sequence[index]);
            index = prev[index];
        }
        for (int i = LIS.size()-1; i >=0 ; i--) {
            System.out.print(LIS.get(i)+" ");
        }
    }
}
