package main;

import java.util.Map;

public interface RaceResult {
    void recordResult(Driver driver, int position, int points);
    int getDriverPoints(Driver driver);
    Map<Driver,Integer> getResults();
}
