package day05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class City {

    private Map<String, List<Integer>> streets = new HashMap<>();
    private static final String STREET_PICTURE = "2,4,1,3,5,6,7,9,8,11";


    public void makeStreet (Path path) {
        List<String> streetFile = readFile(path);
        for (String st: streetFile) {
            String[] streetFileSplit = st.split(" ");
            String streetName = streetFileSplit[0];
            int street0Or1 = Integer.parseInt(streetFileSplit[1]);
            if (!initMap(streetName, street0Or1)) {
                List<Integer> value = streets.get(streetName);
                int max = value.stream().mapToInt(i -> i).filter(i -> i % 2 == street0Or1).max().orElse(-street0Or1);
                value.add(max + 2);
            }
        }
    }

    private boolean initMap(String streetName, int street0Or1) {
        if (!streets.containsKey(streetName)) {
            streets.put(streetName, new ArrayList<>());
            if (street0Or1 % 2 == 0) {
                streets.get(streetName).add(2);
            } else {
                streets.get(streetName).add(1);
            }
            return true;
        }
        return false;
    }

    private List<String> readFile (Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read file!", ioe);
        }
    }

    public Map<String, List<Integer>> getStreets() {
        return streets;
    }
}
