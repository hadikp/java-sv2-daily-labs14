package day02;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String title;
    private int length;
    private List<String> players = new ArrayList<>();

    public Movie(String title, int length, List<String> players) {
        this.title = title;
        this.length = length;
        this.players = players;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public List<String> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return title +", " + length +": " + players;
    }
}
