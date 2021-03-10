import javafx.scene.shape.Line;
/**
 * Escreva a descrição da classe CountryPopulationChart aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CountryPopulationChart extends javafx.scene.Group
{
    /**
     * COnstrutor para objetos da classe CountryPopulationChart
     */
    public CountryPopulationChart(int[] countryPopulation)
    {
        int x = 10;
        int y = 800;
        for(int i = 0; i < countryPopulation.length; i++) {
            int height = countryPopulation[i] / 70;
            Line line = new Line(x, y, x, y - height);
            this.getChildren().add(line);
            x += 1;
        }
    }
}
