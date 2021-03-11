import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.*;
/**
 * Escreva a descrição da classe CityBar aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CityBar extends Group
{
    /**
     * COnstrutor para objetos da classe CityBar
     */
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
