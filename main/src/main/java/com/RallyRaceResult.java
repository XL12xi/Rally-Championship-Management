package main;

import java.util.HashMap;
import java.util.Map;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private Map<Driver, Integer> results = new HashMap<>();

    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
    }

    @Override
    public void recordResult(Driver driver, int points) {
        results.put(driver, points);
    }

    @Override
    public Map<Driver, Integer> getResults() {
        return results;
    }

    public String getRaceName() {
        return raceName;
    }
}
