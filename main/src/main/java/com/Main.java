package main;

public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        Driver driver1 = new Driver("Carlos Sainz", "Spain");
        Driver driver2 = new Driver("Marcus Grönholm", "Finland");
        Driver driver3 = new Driver("Richard Burns", "United Kingdom");
        Driver driver4 = new Driver("Colin McRae", "Scotland");
        
        RallyCar gravelCar1 = new GravelCar("Ford", "Focus RS", 340);
        RallyCar gravelCar2 = new GravelCar("Subaru", "Impreza WRX", 345);
        RallyCar asphaltCar1 = new AsphaltCar("Peugeot", "206 WRC", 355);
        RallyCar asphaltCar2 = new AsphaltCar("Citroën", "Xsara WRC", 365);
        
        System.out.println("Gravel Car 1 Performance: " + gravelCar1.calculatePerformance());
        System.out.println("Gravel Car 2 Performance: " + gravelCar2.calculatePerformance());
        System.out.println("Asphalt Car 1 Performance: " + asphaltCar1.calculatePerformance());
        System.out.println("Asphalt Car 2 Performance: " + asphaltCar2.calculatePerformance());
        System.out.println();
        
        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);
        
        RallyRaceResult race1 = new RallyRaceResult("Rally Sweden");
        race1.recordResult(driver1, 20);
        race1.recordResult(driver3, 18);
        race1.recordResult(driver2, 15);
        race1.recordResult(driver4, 12);
        manager.addRaceResult(race1);
        
        RallyRaceResult race2 = new RallyRaceResult("Acropolis Rally");
        race2.recordResult(driver2, 25);
        race2.recordResult(driver4, 20);
        race2.recordResult(driver1, 15);
        race2.recordResult(driver3, 10);
        manager.addRaceResult(race2);
        
        RallyRaceResult race3 = new RallyRaceResult("Sanremo Rally");
        race3.recordResult(driver4, 25);
        race3.recordResult(driver3, 20);
        race3.recordResult(driver2, 15);
        race3.recordResult(driver1, 10);
        manager.addRaceResult(race3);

        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        for (Driver driver : manager.getChampionshipStandings()) {
            System.out.println(driver.getName() + " (" + driver.getCountry() + "): " + driver.getTotalPoints() + " points");
        }
        System.out.println();

        System.out.println("===== CHAMPIONSHIP LEADER =====");
        Driver leader = manager.getLeadingDriver();
        System.out.println(leader.getName() + " with " + leader.getTotalPoints() + " points");
        System.out.println();

        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + manager.getChampionshipStandings().size());
        System.out.println("Total Races: " + ChampionshipStatistics.countTotalRaces(manager.getRaceResults()));
        System.out.println("Average Points Per Driver: " + String.format("%.2f", ChampionshipStatistics.calculateAveragePoints(manager.getChampionshipStandings())));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getChampionshipStandings()));
        int totalChampionshipPoints = manager.getChampionshipStandings().stream().mapToInt(Driver::getTotalPoints).sum();
        System.out.println("Total Championship Points: " + totalChampionshipPoints);
        System.out.println();

        System.out.println("===== RACE RESULTS =====");
        for (RallyRaceResult race : manager.getRaceResults()) {
            System.out.println("Race: " + race.getRaceName());
            race.getResults().entrySet().stream()
                 .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                 .forEach(entry -> 
                     System.out.println("  " + entry.getKey().getName() + " - " + entry.getValue() + " points")
                 );
            System.out.println();
        }
    }
}
