/**
 * Class that creates a chart of cities. This class calls the class CityBar class to create various bars of cities making them the city chart
 * 
 * @author Simão Silva 17182
 * @version 12-03-2021
 */
public class CitiesChart extends javafx.scene.Group
{
    public CitiesChart(City[] city)
    {
        int x = 10;
        int y = 800;
        int width = 50;        
        for(int i = 0; i < city.length; i++){
            int height = city[i].getPopulation();
            
            CityBar cityBar = new CityBar(city[i], x, y, width, height);
            
            x = x + 2 * width;
            this.getChildren().add(cityBar);
        }
    }
}
