package main;

public class Driver {
    private String name;
    private String country;
    private int totalPoints;

    public Driver(String name, String country) {
        this.name = name;
        this.country = country;
        this.totalPoints = 0;
    }

    public String getName() { 
        return name; 
    }
    
    public String getCountry() { 
        return country; 
    }
    
    public int getTotalPoints() { 
        return totalPoints; 
    }
    
    public void addPoints(int points) {
        this.totalPoints += points;
    }
}
