import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.*;
/**
 * Classe that creates a bar and text with (city, countryName, region) below the bar and with the population above the bar
 * 
 * @author Simão Silva 17182
 * @version 12-03-2021
 */
public class CityBar extends javafx.scene.Group
{
    public CityBar(City city , int x, int y , int width, int height) 
    {
        Rectangle rect = new Rectangle(x, y - height, width, height);
        rect.setStrokeWidth(2);
        rect.setStroke(Color.RED);
        rect.setFill(Color.YELLOW);

        Text text = new Text( x, y + 10, city.getCity() + "\n" + city.getCountryName() + "\n" + city.getRegion());
        text.setFont(new Font(10));
        text.setStroke(Color.BLACK);       

        Text text1 = new Text(x , y - height , height + "");
        text1.setFont(new Font(20));
        text1.setStroke(Color.BLACK);        
        
        this.getChildren().addAll(rect, text, text1);
    }
}
