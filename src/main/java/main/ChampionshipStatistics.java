package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {

    public static double calculateAveragePointPerDriver(List<Driver>drivers){
        return ChampionshipManager.getTotalChampionshipPoints()/ChampionshipManager.getTotalDrivers();
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        Map<String, Integer> countries = new HashMap<>();
        
        for (Driver driver : drivers) {
            countries.put(driver.getCountry(), countries.getOrDefault(driver.getCountry(), 0) + driver.getPoints());
        }
        String mostSuccessfulCountry = null;
        int maxPoints = 0;
        for (Map.Entry<String, Integer> entry : countries.entrySet()) {
            if (entry.getValue() > maxPoints) {
                maxPoints = entry.getValue();
                mostSuccessfulCountry = entry.getKey();
            }
        }

        return mostSuccessfulCountry;
    }

    public static int getTotalRacesHeld(){
        return ChampionshipManager.getTotalRaces();
    }
}
