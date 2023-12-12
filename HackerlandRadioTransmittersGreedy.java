import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HackerlandRadioTransmitters {

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        Collections.sort(x);
        int numTransmitters = 0;
        int i = 0;
        int n = x.size();

        while (i < n) {
            numTransmitters++;
            int loc = x.get(i) + k;

            while (i < n && x.get(i) <= loc) {
                i++;
            }

            i--;
            loc = x.get(i) + k;

            while (i < n && x.get(i) <= loc) {
                i++;
            }
        }

        return numTransmitters;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int maxHouseNumber = 100000;
        int stepSize = 1000;
        int maxRange = 100;

        for (int n = stepSize; n <= maxHouseNumber; n += stepSize) {
            List<Integer> houses = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                houses.add(random.nextInt(maxHouseNumber));
            }

            long startTime = System.nanoTime();
            hackerlandRadioTransmitters(houses, maxRange);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);
            System.out.println(n + "," + duration);
        }
    }
}
