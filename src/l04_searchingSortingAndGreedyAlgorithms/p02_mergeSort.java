package l04_searchingSortingAndGreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_mergeSort {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        merge(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static int[] merge(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int firstHalf = arr.length / 2;
        int secondHalf = arr.length - firstHalf;

        int[] firstPart = new int[firstHalf];
        int[] secondPart = new int[secondHalf];

        for (int i = 0; i < firstHalf; i++) {
            firstPart[i] = arr[i];
        }
        for (int i = firstHalf; i < firstHalf + secondHalf; i++) {
            secondPart[i - firstHalf] = arr[i];
        }
        merge(firstPart);
        merge(secondPart);

        int mainIndex = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstPart.length && secondIndex < secondPart.length) {
            if (firstPart[firstIndex] < secondPart[secondIndex]) {
                arr[mainIndex] = firstPart[firstIndex];

                mainIndex++;
                firstIndex++;
            } else {
                arr[mainIndex] = secondPart[secondIndex];

                mainIndex++;
                secondIndex++;
            }
        }
        while (firstIndex < firstPart.length) {
            arr[mainIndex] = firstPart[firstIndex];
            mainIndex++;
            firstIndex++;
        }

        while (secondIndex < secondPart.length) {
            arr[mainIndex] = secondPart[secondIndex];
            mainIndex++;
            secondIndex++;
        }
        return arr;
    }
}
