import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import java.util.*;
/**
 * Class for actions. Can use a "pane", made available by the GUIBase class
 * @author NOME e NÚMERO DE ALUNO
 * @version 2021-02-???????
 */
public class Operations extends GUIBase {

    public static void main(String[] args) {
        new Operations(args);
    }

    private Operations(String[] args) {
        super(args);
        addCommand("Line", this::drawLine);
        addCommand("Rectangle", this::drawRectangle);
        addCommand("Text", this::drawText);
        addCommand("Chart", this::drawChart);
        addCommand("e1BiggestPopulationCity", this::E1BiggestPopulationCity);
        addCommand("e2PopulationTotalInYear", this::E2PopulationTotalInYear);
        addCommand("e3AllCitiesInYear", this::E3AllCitiesInYear);
        addCommand("e4CountryPopulation", this::E4ChartCountryPopulation);
        // TODO adicionar mais linhas com entradas de menu e
        //  nomes de métodos void sem parâmetros

        launch();
    }
    // TODO  adicionar métodos void sem parâmetros
        private void E1BiggestPopulationCity() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Biggest populated City");
        alert.setHeaderText("The biggest populated City is?");
        alert.setContentText(MyFileTools.e1BiggestPopulationCity("datafiles/cities.txt", ","));
        alert.showAndWait();
    }

    private void E2PopulationTotalInYear() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Insert Year");
        dialog.setHeaderText("Insert Year");
        dialog.setContentText("Please enter a year between 1500 and 2018:");
        int resultYear = 0; 
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            resultYear = Integer.parseInt(result.get());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Population Year");
            alert.setHeaderText("The population in " + resultYear + " was?");
            alert.setContentText("" + MyFileTools.e2PopulationTotalInYear(resultYear));
            alert.showAndWait();
        }
    }
    // TODO  adicionar métodos void sem parâmetros
    private void E3AllCitiesInYear(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Insert Year");
        dialog.setHeaderText("Insert Year");
        dialog.setContentText("Please enter a year between 1500 and 2018:");
        int resultYear = 0; 
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            resultYear = Integer.parseInt(result.get());
            String content = "";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("City in a Year");
            alert.setHeaderText("The cities in " + resultYear + " are?");
            String[] cities = MyFileTools.e3AllCitiesInYear(resultYear);
            for(int i = 0; i < cities.length;i++){
                if(i < cities.length-1){
                    content += cities[i] + ", ";
                }
                else {
                    content += cities[i];
                }
            }
            alert.setContentText(content);
            alert.showAndWait();
        }
    }

    private void E4ChartCountryPopulation(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Insert Country");
        dialog.setHeaderText("Insert Country");
        dialog.setContentText("Please enter a country:");
        String countryName = ""; 
        Optional<String> result = dialog.showAndWait();     
        countryName = (result.get());                      
        int[] countryPopulation = MyFileTools.e4CountryPopulation(countryName);    
        CountryPopulationChart countryPopulationChart = new CountryPopulationChart(countryPopulation);
        pane.getChildren().add(countryPopulationChart);       
    }

    private void E5AllCitiesData(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Insert Year");
        dialog.setHeaderText("Insert Year");
        dialog.setContentText("Please enter a year between 1500 and 2018:");
        int resultYear = 0; 
        Optional<String> result = dialog.showAndWait();
        resultYear = Integer.parseInt(result.get());
        City[] city = MyFileTools.e5AllCitiesDataInYear(resultYear);
        //CityBar cityBar = new CityBar(city);
        
    }


    private void drawLine() {
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Line.html
        Line line = new Line(60, 20, 100, 200);
        line.setStrokeWidth(5);
        line.setStroke(Color.GREEN);
        pane.getChildren().add(line);
    }

    private void drawRectangle() {
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html
        Rectangle rect = new Rectangle(100, 50, 300, 200);
        rect.setStrokeWidth(2);
        rect.setStroke(Color.RED);
        rect.setFill(Color.YELLOW);
        pane.getChildren().add(rect);
    }

    private void drawText() {
        Text text = new Text(300, 400, "This is a text!\nWith two lines.");
        text.setFont(new Font(20));
        text.setStroke(Color.BLACK);
        //text.setFill(Color.CHARTREUSE);
        pane.getChildren().add(text);
    }

    private void drawChart() {
        int[] cityPopulation = MyFileTools.getCityPopulation(getFileName(), ",", "Beijing");
        int x = 10;
        int y = 500;
        for(int i = 0; i < cityPopulation.length; i++) {
            int height = cityPopulation[i] / 50;
            Line line = new Line(x, y, x, y - height);
            pane.getChildren().add(line);
            x += 1;
        }
    }
} // END class Operations
