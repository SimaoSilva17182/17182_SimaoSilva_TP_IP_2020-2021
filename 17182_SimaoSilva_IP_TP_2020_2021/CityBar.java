import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
/**
 * Escreva a descrição da classe CityBar aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CityBar extends javafx.scene.Group
{
    /**
     * COnstrutor para objetos da classe CityBar
     */
    public CityBar(City city , int x, int y , int width, int height) 
    {
        Rectangle rect = new Rectangle(x, y, width, height);
        rect.setStrokeWidth(2);
        rect.setStroke(Color.RED);
        rect.setFill(Color.YELLOW);
        this.getChildren().add(rect);

        Text text = new Text( 2 * x, y + x, city.city + "\n" + city.countryName + "\n" + city.region);
        text.setFont(new Font(20));
        text.setStroke(Color.BLACK);
        this.getChildren().add(text);

        Text text1 = new Text(x , height - x, height + "");
        text1.setFont(new Font(20));
        text1.setStroke(Color.BLACK);
        this.getChildren().add(text1);            
    }
}
