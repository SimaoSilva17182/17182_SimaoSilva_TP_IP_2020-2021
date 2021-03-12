import javafx.scene.shape.*;
import javafx.scene.paint.*;
/**
 * Class that creates a pie chart. which slice of the pie has a given color and angle that is equal to the corresponding piece of the pie
 * 
 * @author Simão Silva 17182
 * @version 12-03-2021
 */
public class PieChart extends javafx.scene.Group
{
    public PieChart(double[] length)
    {
        double centerX = 200.0;
        double centerY = 200.0;
        double radius = 100.0;
        double beginSlice = 0.0;
        Color color[] = {Color.RED , Color.YELLOW, Color.GREEN, Color.BLUE, Color.BLACK, Color.PURPLE, Color.GRAY};

        for(int i = 0; i < length.length; i++){
            Arc arc1 = new Arc ( centerX , centerY , radius , radius , beginSlice, length[i]);
            arc1.setFill(color[i]) ;
            arc1.setType(ArcType.ROUND) ;
            beginSlice = beginSlice + length[i];

            this.getChildren().add(arc1);
        }
    }
}
