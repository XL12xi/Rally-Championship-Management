package main;

import java.util.Map;

public interface RaceResult {
    void recordResult(Driver driver, int points);
    Map<Driver, Integer> getResults();
}
