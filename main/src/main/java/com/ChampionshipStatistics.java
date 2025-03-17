package main;

import java.util.Comparator;
import java.util.List;

public class ChampionshipStatistics {
    public static double calculateAveragePoints(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getTotalPoints).average().orElse(0.0);
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        return drivers.stream()
                      .max(Comparator.comparingInt(Driver::getTotalPoints))
                      .map(Driver::getCountry)
                      .orElse("N/A");
    }

    public static int countTotalRaces(List<RallyRaceResult> results) {
        return results.size();
    }
}
