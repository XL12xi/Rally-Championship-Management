package main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> raceResults = new ArrayList<>();

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRaceResult(RallyRaceResult result) {
        raceResults.add(result);
        for (Map.Entry<Driver, Integer> entry : result.getResults().entrySet()) {
            entry.getKey().addPoints(entry.getValue());
        }
    }

    public List<Driver> getChampionshipStandings() {
        drivers.sort(Comparator.comparingInt(Driver::getTotalPoints).reversed());
        return drivers;
    }

    public Driver getLeadingDriver() {
        return getChampionshipStandings().get(0);
    }

    public List<RallyRaceResult> getRaceResults() {
        return raceResults;
    }
}
