package main;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;

    private static List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();
    private static int totalDrivers=0;
    private static int totalRaces=0 ;

    private ChampionshipManager() {}
    public static ChampionshipManager getInstance() {
        if (instance == null) instance = new ChampionshipManager();
        return instance;
    }
    public void registerDriver(Driver driver){
        drivers. add(driver);
        totalDrivers++;
    }
    public void addRaceResults(RallyRaceResult result){
        races.add(result);
        totalRaces++;
    }
    public static int getTotalDrivers() {
        return totalDrivers;
    }
    public static int getTotalRaces() {
        return totalRaces;
    }

    public List<Driver> getDriverStandings() {
        drivers.sort((driver1, driver2) -> Integer.compare(driver2.getPoints(), driver1.getPoints()));
        return drivers;
    }

    public Driver getLeadingDriver() {
        drivers= getDriverStandings();
        return drivers.get(0);
    }
    
    public static int getTotalChampionshipPoints() {
        int totalPoints = 0; 
        for (Driver driver : drivers) { 
            totalPoints += driver.getPoints();
        }
        return totalPoints;
    }
    



}
