/**
 * Escreva a descrição da classe CitiesChart aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CitiesChart extends javafx.scene.Group
{
    /**
     * COnstrutor para objetos da classe CitiesChart
     */
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
