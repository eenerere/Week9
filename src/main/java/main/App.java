package main;

import java.util.List;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
                
        RallyCar car1= new AsphaltCar("Car", "100a", 100, 2);
        RallyCar car2= new GravelCar("Car", "200a", 200, 3);

        Driver d1= new Driver( "Sébastien Ogier", "France", car1);
        Driver d2= new Driver( "Kalle Rovanperä", "Finland", car2);
        Driver d3= new Driver( "Ott Tänak", "Estonia", car1);
        Driver d4= new Driver( "Thierry Neuville", "Belgium", car2);

        ChampionshipManager manager= ChampionshipManager.getInstance();
        manager.registerDriver(d1);
        manager.registerDriver(d2);
        manager.registerDriver(d3);
        manager.registerDriver(d4);
        
        RallyRaceResult race1= new RallyRaceResult("Rally Finland", "Jyväskylä");
        manager.addRaceResults(race1);
        race1.recordResult(d1, 1,25);
        race1.recordResult(d3, 2,18);
        race1.recordResult(d2, 3,15);
        race1.recordResult(d4, 4,12);

        RallyRaceResult race2= new RallyRaceResult("Monte Carlo Rally", "Monaco");
        manager.addRaceResults(race2);
        race2.recordResult(d2, 1,25);
        race2.recordResult(d4, 2,18);
        race2.recordResult(d1, 3,15);
        race2.recordResult(d3, 4,12);

        System.out.println("===== RALLY CHAMPIONSHIP =====");
        List<Driver> drivers= manager.getDriverStandings();
        int i=1;
        for (Driver driver : drivers) {
            System.out.printf("%d. %s (%s) - %d points%n", i++, driver.getName(), driver.getCountry(), driver.getPoints());
        }

        System.out.println();

        System.out.println("===== CHAMPIONSHIP LEADER =====");
        Driver leadingDriver= manager.getLeadingDriver();
        System.out.println(leadingDriver.getName() + " with " + leadingDriver.getPoints() + " points");
        System.out.println();

        System.out.println("===== CHAMPIONSHIP STATISTICS =====");

        System.out.println("Total Drivers: "+ ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: "+ ChampionshipManager.getTotalRaces());

        System.out.println("Average Points Per Driver: "+ ChampionshipStatistics.calculateAveragePointPerDriver(drivers));
        System.out.println("Most successful country: "+ ChampionshipStatistics.findMostSuccessfulCountry(drivers));
        System.out.println("Total Championship points: "+ ChampionshipManager.getTotalChampionshipPoints());
        System.out.println();

        System.out.println("===== RACE RESULTS =====");

        System.out.println("Race: "+ race1.getRaceName()+ " ("+ race1.getLocation()+ ")");
        int position=1;
        for (Map.Entry<Driver, Integer> participant : race1.getResults().entrySet()) {
            System.out.printf("Position %d: %s - %d points%n", position++, participant.getKey().getName(), participant.getValue());
        }
        System.out.println();

        System.out.println("Race: "+ race2.getRaceName()+ " ("+ race2.getLocation()+ ")");
        int j=1;
        for (Map.Entry<Driver, Integer> participant : race2.getResults().entrySet()) {
            System.out.printf("Position %d: %s - %d points%n", j++, participant.getKey().getName(), participant.getValue());
        }
        System.out.println();

        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: "+ car2.calculatePerformance());
        System.out.println("Gravel Car Performance: "+ car1.calculatePerformance());
        
        
    }
}
