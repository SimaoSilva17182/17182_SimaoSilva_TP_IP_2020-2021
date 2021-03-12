import java.util.*;

/** 
 * Classe that operates has a city object
 * 
 * @author Simão Silva 17182
 * @version 12-03-2021
 */
public class City{
    private String city;
    private String countryName;
    private int population;
    private String region;    
    public City( String city, String countryName, int population, String region)
    {
        this.city = city;
        this.countryName = countryName;
        this.population = population;
        this.region = region;
    }

    public String getCity(){
        return city;
    }

    public String getCountryName(){ 
        return countryName;
    }

    public int getPopulation(){
        return population;
    }

    public String getRegion(){
        return region;
    }
}
