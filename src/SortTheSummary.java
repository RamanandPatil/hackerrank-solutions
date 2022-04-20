import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/discuss/interview-question/1535419/amazon-sort-the-summary">Sort the summary</a>
 */
public class SortTheSummary {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        System.out.println("test");
    }


    public static List<List<Integer>> groupSort(List<Integer> arr) {
        // Using TreeMap first to keep the integer's natural order
        Map<Integer, Integer> map = new TreeMap<>();
        // Run over the input array and add to the map only if the key isn't their already.
        // Otherwise, increase the value at map[key] by one
        for (Integer currInt : arr) {
            if (map.containsKey(currInt)) {
                int currValue = map.get(currInt);
                map.replace(currInt, currValue + 1);
            } else {
                map.put(currInt, 1);
            }
        }
        // Now sort the map by VALUE
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(SortTheSummary::compare);
        // Now after the map is sorted, create 2-dimesional ArrayList and insert pairs of key and values into it
        List<List<Integer>> ans = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> curr : list) {
            List<Integer> integerList = new ArrayList<>(2);
            integerList.add(curr.getKey());
            integerList.add(curr.getValue());
            ans.add(integerList);
        }
        return ans;
    }

    private static int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
    }

}
