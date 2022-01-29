package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {


    @Test
    void test() {
        Path path = Path.of("src/test/resources/streets.txt");
        City city = new City();
        city.makeStreet(path);
        System.out.println(city.getStreets());
    }

}