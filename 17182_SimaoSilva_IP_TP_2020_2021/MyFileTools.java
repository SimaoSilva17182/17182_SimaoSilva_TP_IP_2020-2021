import java.util.Arrays;

/**
 * Examples using the utility methods in FileUtils class
 * This file has its own main method, so it can be used for autonomous testing
 * @author João Paulo barros
 * @version 2021-02-01
 */
public class MyFileTools {

    /**
     * mian method for testing
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //testReadFileToStringArray("datafiles/cities.txt");
        //testReadFileToStringArray2D("datafiles/cities.txt", ",");
        //writeCityPopulation("datafiles/cities.txt", ",", "Beijing");
        //int[] cityPopulation = getCityPopulation("datafiles/cities.txt", ",", "Beijing");
        //System.out.println(Arrays.toString(cityPopulation));
        //System.out.println(e1BiggestPopulationCity("datafiles/cities.txt", ","));
        //System.out.println(e2PopulationTotalInYear(1500));
        //System.out.println(e3AllCitiesInYear(1502).length);
        //System.out.print(e4CountryPopulation("Portugal")[0]);
        //System.out.println(e5AllCitiesDataInYear(1500)[0]);

    }
    public static String filename = "datafiles/cities.txt";
    public static String separator = ",";
    public static String filename2 = "datafiles/countries.txt";
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
    
        public static String e1BiggestPopulationCity(String filename, String separator) {
        String[][] cities = FileTools.readFileToStringArray2D(filename, separator);
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

    public static long e2PopulationTotalInYear(int year) {
        String[][] cities = FileTools.readFileToStringArray2D(filename, separator);
        long cityPopulation = 0;
        for(int line = 0; line < cities.length; line++){
            if (cities[line].length > 2 && Integer.parseInt(cities[line][0]) == year){
                cityPopulation += Integer.parseInt(cities[line][3]);                                          
            }
        }
        return cityPopulation;
    }

    public static String[] e3AllCitiesInYear(int year) {
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

    public static int[] e4CountryPopulation(String countryName) {
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

    public static City[] e5AllCitiesDataInYear(int year) {
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
}
