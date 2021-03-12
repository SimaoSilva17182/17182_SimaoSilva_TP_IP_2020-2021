import java.util.Arrays;

/**
 * Examples using the utility methods in FileUtils class
 * This file has its own main method, so it can be used for autonomous testing
 * @author Simão Silva 17182
 * @version 12-03-2021
 */
public class MyFileTools {
    private String filename = "datafiles/cities.txt";
    private String separator = ",";
    private String filename2 = "datafiles/countries.txt";
    private String filename3 = "datafiles/owid-covid-data.txt";
    /**
     * mian method for testing
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //testReadFileToStringArray("datafiles/cities.txt");
        testReadFileToStringArray2D("datafiles/cities.txt", ",");
        writeCityPopulation("datafiles/cities.txt", ",", "Beijing");
        int[] cityPopulation = getCityPopulation("datafiles/cities.txt", ",", "Beijing");       
    }

    public MyFileTools(String filename, String separator, String filename2, String filename3)
    {
        this.filename = filename;
        this.separator = separator;
        this.filename2 = filename2;
        this.filename3 = filename3;
    }

    /**
     * test for method readFileToStringArray
     * @param filename csv file to read
     */
    public static void testReadFileToStringArray(String filename) {
        String[] cities = FileTools.readFileToStringArray(filename);
        for (int line = 0; line < cities.length; line++) {
            System.out.printf("%05d - %s" + FileTools.EOL, line, cities[line]);
        }
    }

    /**
     * test for method readFileToStringArray2D
     * @param filename csv file to read
     * @param separator separator for tokens in each line
     */
    public static void testReadFileToStringArray2D(String filename, String separator) {
        String[][] cities = FileTools.readFileToStringArray2D(filename, separator);
        for (int line = 0; line < cities.length; line++) {
            System.out.printf("%05d - ", line);
            for (int col = 0; col < cities[line].length; col++) {
                System.out.print(cities[line][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     * writes all lines with population for the given city name
     * @param filename csv file to read
     * @param separator separator for tokens in each line
     * @param cityName city to print name and population
     */
    public static void writeCityPopulation(String filename, String separator, String cityName) {
        String[][] cities = FileTools.readFileToStringArray2D(filename, separator);
        for (int line = 0; line < cities.length; line++) {
            if (cities[line].length > 2 && cities[line][1].equals(cityName)) {
                System.out.println(cityName + ": " + cities[line][3]);
            }
        }
    }

    /**
     * get all population for the given city name
     * @param filename csv file to read
     * @param separator separator for tokens in each line
     * @param cityName city to print name and population
     * @return array with population for the given city name
     */
    public static int[] getCityPopulation(String filename, String separator, String cityName) {
        String[][] cities = FileTools.readFileToStringArray2D(filename, separator);
        int nCityOccurences = nCityOccurrences(cities, cityName);
        int[] cityPopulation = new int[nCityOccurences];
        int n = 0;
        for (int line = 0; line < cities.length; line++) {
            if (cities[line].length > 2 && cities[line][1].equals(cityName)) {
                cityPopulation[n] = Integer.parseInt(cities[line][3]);
                n++;
            }
        }
        return cityPopulation;
    }

    /**
     * get number of occurrences for the given city name
     * @param cities 2D array with all tokesn in each line
     * @param cityName city to print name and population
     * @return number of city names occurrecnes in 2D array
     */
    public static int nCityOccurrences(String[][] cities, String cityName) {
        int total = 0;
        for (int line = 0; line < cities.length; line++) {
            if (cities[line].length > 2 && cities[line][1].equals(cityName)) {
                total++;
            }
        }
        return total;
    }

    /** get the city with the biggest population
     * @return a string with the name of the city with the biggets population and that same population
     */
    public String e1BiggestPopulationCity() {
        String[][] cities = FileTools.readFileToStringArray2D(this.filename, this.separator);
        int getCityPopulation = 0;
        String cityName = "";       
        int[] cityPopulation = new int[getCityPopulation];
        for(int line = 0; line < cities.length; line++){
            if (cities[line].length > 2){
                cityPopulation = getCityPopulation(filename, separator, cities[line][1]);
                if (getCityPopulation < cityPopulation[cityPopulation.length-1]){                    
                    getCityPopulation = cityPopulation[cityPopulation.length-1];
                    cityName = cities[line][1];
                }                            
            }
        }
        return cityName + " " + getCityPopulation;
    }

    /** get the total population for the given year
     *  @param year that is given by the user
     *  @return the total population
     */
    public long e2PopulationTotalInYear(int year) {
        String[][] cities = FileTools.readFileToStringArray2D(filename, separator);
        long cityPopulation = 0;
        for(int line = 0; line < cities.length; line++){
            if (cities[line].length > 2 && Integer.parseInt(cities[line][0]) == year){
                cityPopulation += Integer.parseInt(cities[line][3]);                                          
            }
        }
        return cityPopulation;
    }

    /** get all the cities in the given year 
     *  @param year that is given by the user
     *  @return string array with all the cities
     */
    public String[] e3AllCitiesInYear(int year) {
        String[][] cities = FileTools.readFileToStringArray2D(filename, separator);
        String cityName = "";
        int city = 0;
        String[] citiesInYear = new String[city];
        for(int line = 0; line < cities.length; line++){
            if (cities[line].length > 2 && Integer.parseInt(cities[line][0]) == year){
                cityName += cities[line][1] + ",";              
            }
        }
        citiesInYear = cityName.split(",");// this will return the array splitted by the ","
        return citiesInYear;
    }

    /** get every instance of the population for the given countryName 
     *  @param countryName that is given by the user
     *  @return a array with every instance of the population
     */
    public int[] e4CountryPopulation(String countryName) {
        String[][] cities = FileTools.readFileToStringArray2D(filename2, separator);                   
        String country = "";
        for(int line = 0; line < cities.length; line++){
            if (cities[line].length > 2 && cities[line][1].equals(countryName)){
                country += (cities[line][3]) + ",";                             
            }
        }
        int[] countryPopulation = new int[country.split(",").length];
        int i = 0;
        for(String s : country.split(",")){// for which string "s" inside the string countryPopulation
            countryPopulation[i++] = Integer.parseInt(s);
        }
        return countryPopulation;
    }

    /** get a city array with the city, the country, the population and the region for the given year
     *  @param year that is given by the user
     *  @return a array with the city, the country, the population and the region
     */
    public City[] e5AllCitiesDataInYear(int year) {
        String[][] cities = FileTools.readFileToStringArray2D(filename, separator);        
        String country = "";
        for(int line = 0; line < cities.length; line++){
            if (cities[line].length > 2 && Integer.parseInt(cities[line][0]) == year){
                country += cities[line][1] + "," + cities[line][2] + "," + cities[line][3] + "," + cities[line][4] + "/";                                
            }
        }
        City[] citiesInYear = new City[country.split("/").length];
        String [] countries = country.split("/");
        for(int i = 0; i <countries.length; i++){
            String[] cityDetails = countries[i].split(","); 
            City city = new City(cityDetails[0], cityDetails[1], Integer.parseInt(cityDetails[2]), cityDetails[3]);
            citiesInYear[i] = city; 
        }
        return citiesInYear;
    }

    /** get a array with the sum of all the deaths of a continent for the given date
     *  @param date that is given by the user
     *  @return a array with all the deaths of a continent
     */
    public double[] ne1DeathsPerContinent(String date){
        String[][] cities = FileTools.readFileToStringArray2D(filename3, separator); 
        String[] continent =  {"Europe", "Asia", "Oceania", "North America", "South America", "Africa", ""};
        double[] deaths = new double[continent.length];
        for(int i = 0; i < continent.length; i++){            
            for(int line = 0; line <cities.length; line++){            
                if(cities[line].length > 2 && cities[line][3].equals(date) && continent[i].equals(cities[line][1])){
                    double totalDeaths = 0.0;
                    if(!cities[line][7].isEmpty()){
                        totalDeaths = Double.parseDouble(cities[line][7]);
                    }                   
                    deaths[i] = deaths[i] + totalDeaths;
                }
            }
        }        
        return deaths;
    }
}

