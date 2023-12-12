import java.util.Arrays;
import java.util.Random;

public class HackerlandRadioTransmittersDP {

    public static int minCostToCoverHouses(int[] houses, int[] cost, int k) {
        int n = houses.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = cost[0];

        for (int i = 1; i < n; i++) {
            // Case 1: Place a transmitter at the current house
            dp[i] = cost[i];
            for (int j = i - 1; j >= 0 && houses[i] - houses[j] <= k; j--) {
                dp[i] = Math.min(dp[i], (j > 0 ? dp[j - 1] : 0) + cost[i]);
            }

            // Case 2: Do not place a transmitter at the current house
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Random random = new Random();
        int maxInputSize = 500; // Adjust this based on how large your test cases should be
        int stepSize = 50; // Increase in input size for each test

        for (int inputSize = stepSize; inputSize <= maxInputSize; inputSize += stepSize) {
            int[] houses = new int[inputSize];
            int[] cost = new int[inputSize];

            // Generate random input
            for (int i = 0; i < inputSize; i++) {
                houses[i] = i; // Assuming houses are in a line
                cost[i] = random.nextInt(100) + 1; // Random cost between 1 and 100
            }

            // Measure execution time
            long startTime = System.nanoTime();
            HackerlandRadioTransmittersDP.minCostToCoverHouses(houses, cost, random.nextInt(10) + 1);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            System.out.println(inputSize + "," + duration);
        }
    }
}