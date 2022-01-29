package day04;

import java.util.ArrayList;
import java.util.List;

public class PairFinder {

    public List<Integer> findPairs(List<Integer> find) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < find.size(); i++) {
            for (int j = 1; j < find.size(); j++) {
                int first = find.get(i);
                if (first == find.get(j)) {
                    //1 pár
                }
            }
        }
        return result;
    }
}
