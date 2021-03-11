import java.util.*;

/** Este template foi criado na 
 * Escola Superior de Tecnologia e Gestão do
 * Instituto PolitÈcnico de Beja
 * em 2016/09/29
 * -----------------------------------------------------
 * Adicione aqui uma descrição da classe, o seu nome e a data
 * @author (o seu nome) 
 * @version (número de versão ou data)
 * 
 * O programa deve ser escrito em inglês.
 */
public class City
{
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
