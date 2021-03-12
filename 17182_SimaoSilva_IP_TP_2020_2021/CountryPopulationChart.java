import javafx.scene.shape.Line;
/**
 * Classe that creates a chart of lines where the lines are equal to the population of the given country
 * 
 * @author Simão Silva 17182
 * @version 12-03-2021
 */
public class CountryPopulationChart extends javafx.scene.Group
{
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
