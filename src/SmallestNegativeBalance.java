import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <a href="https://leetcode.com/discuss/interview-question/960222/negative-balancing">Negative Balancing</a>
 */
public class SmallestNegativeBalance {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int debtsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int debtsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> debts = new ArrayList<>();

        IntStream.range(0, debtsRows).forEach(i -> {
            try {
                debts.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<String> result = SmallestNegativeBalance.smallestNegativeBalance(debts);

        bufferedWriter.write(String.join("\n", result) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        Map<String, int[]> map = new HashMap<>();
        for (List<String> list : debts) {
            // Get the borrower, lender and amount
            String borrower = list.get(0);
            String lender = list.get(1);
            int amount = Integer.parseInt(list.get(2));

            int[] borrowerBal = map.getOrDefault(borrower, new int[]{0, 0, 0});
            borrowerBal[0] += amount;
            map.put(borrower, borrowerBal);
            int[] lenderBal = map.getOrDefault(lender, new int[]{0, 0, 0});
            lenderBal[1] += amount;
            map.put(lender, lenderBal);
        }
        map.forEach((key, value) -> {
            value[2] = value[1] - value[0];
            map.put(key, value);
        });

        // Print the map after calculating the balances:
        map.forEach((key, value) -> {
            System.out.print("key: " + key + ", ");
            System.out.println("value: " + Arrays.toString(value));
        });


        Comparator<String> stringComparator = (a, b) -> map.get(a)[2] == map.get(b)[2]
                                                        ? a.compareTo(b)
                                                        : map.get(a)[2] - map.get(b)[2];

        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>(stringComparator);

        stringPriorityQueue.addAll(map.keySet());

        // Print the stringPriorityQueue
        stringPriorityQueue.forEach(System.out::println);


        // Now find the result from the stringPriorityQueue
        List<String> result = new ArrayList<>();
        int min = 0;

        while (!stringPriorityQueue.isEmpty()) {
            String person = stringPriorityQueue.poll();
            int[] balance = map.get(person);

            if (balance[2] >= 0) {
                continue;
            }

            if (min >= balance[2]) {
                min = balance[2];
                result.add(person);
                System.out.println("Result: " + result);
            }
        }

        System.out.println("Result: " + result);

        if (result.size() >= 1) {
            return result;
        } else {
            result.add("Nobody has a negative balance");
        }

        return result;
    }

}
