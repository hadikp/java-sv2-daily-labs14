package day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairFinder {

    private Map<Integer, Integer> result = new HashMap<>();

    public int findPairs(List<Integer> find) {
        for (int i = 0; i < find.size(); i++) {
            int first = find.get(i);
            outerFor(find, first);
        }
        int sum = getMapResult();
        return sum;
    }


    private void outerFor(List<Integer> find, int first) {
        int count = 0;
        for (int j = 0; j < find.size(); j++) {
            if (first == find.get(j)) {
                count++;
            }
        }
        if (!result.containsKey(first)) {
            result.put(first, (count / 2));
        }
    }

    private int getMapResult() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> r: result.entrySet()) {
            sum += r.getValue();
        }
        return sum;
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }
}
