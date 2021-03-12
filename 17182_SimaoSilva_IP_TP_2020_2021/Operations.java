import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import java.util.*;
/**
 * Class for actions. Can use a "pane", made available by the GUIBase class
 * @author Simão Silva 17182
 * @version 12-03-2021
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
        addCommand("e5AllCitiesDataInYear", this::E5AllCitiesData);
        addCommand("ne1DeathsPerContinent", this::NE1DeathsPerContinent);

        // TODO adicionar mais linhas com entradas de menu e
        //  nomes de métodos void sem parâmetros

        launch();
    }
    // TODO  adicionar métodos void sem parâmetros
    /** This method shows the City with the biggest population and also shows that same population 
     * 
     */
    private void E1BiggestPopulationCity() {
        MyFileTools myFileTools = new MyFileTools(getFileName(), ",", getFileName(),getFileName());
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Biggest populated City");
        alert.setHeaderText("The biggest populated City is?");
        alert.setContentText(myFileTools.e1BiggestPopulationCity());
        alert.showAndWait();
    }

    /** This method ask the user for a year and then shows the total population of that given year 
     * 
     */
    private void E2PopulationTotalInYear() {
        MyFileTools myFileTools = new MyFileTools(getFileName(), ",", getFileName(),getFileName());
        
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
            alert.setContentText("" + myFileTools.e2PopulationTotalInYear(resultYear));
            alert.showAndWait();
        }
    }
    // TODO  adicionar métodos void sem parâmetros
    /** This method ask the user for a year and then shows all the cities in that given year
     * 
     */
    private void E3AllCitiesInYear(){
        MyFileTools myFileTools = new MyFileTools(getFileName(), ",", getFileName(),getFileName());
        
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
            String[] cities = myFileTools.e3AllCitiesInYear(resultYear);
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

    /** This method ask the user for a country and then shows the chart of lines of that given country
     * 
     */
    private void E4ChartCountryPopulation(){
        MyFileTools myFileTools = new MyFileTools(getFileName(), ",", getFileName(),getFileName());
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Insert Country");
        dialog.setHeaderText("Insert Country");
        dialog.setContentText("Please enter a country:");
        String countryName = ""; 
        Optional<String> result = dialog.showAndWait();     
        countryName = (result.get());                      
        int[] countryPopulation = myFileTools.e4CountryPopulation(countryName);    
        CountryPopulationChart countryPopulationChart = new CountryPopulationChart(countryPopulation);
        pane.getChildren().add(countryPopulationChart);       
    }

    /** This method ask the user for a year and then shows a chart of cities of that given year
     * 
     */
    private void E5AllCitiesData(){
        MyFileTools myFileTools = new MyFileTools(getFileName(), ",", getFileName(),getFileName());
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Insert Year");
        dialog.setHeaderText("Insert Year");
        dialog.setContentText("Please enter a year between 1500 and 2018:");
        int resultYear = 0; 
        Optional<String> result = dialog.showAndWait();
        resultYear = Integer.parseInt(result.get());
        City[] city = myFileTools.e5AllCitiesDataInYear(resultYear);
        CitiesChart citiesChart = new CitiesChart(city);
        pane.getChildren().add(citiesChart);         
    }

    /** This method ask the user for a date with the format(AAAA-MM-DD) and then shows a pie chart with colors in percentage of all the deaths of that date in which country 
     * 
     */
    private void NE1DeathsPerContinent(){
        MyFileTools myFileTools = new MyFileTools(getFileName(), ",", getFileName(),getFileName());
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Insert Date");
        dialog.setHeaderText("Insert Date");
        dialog.setContentText("Please enter a date in the following format AAAA-MM-DD:");
        String date = ""; 
        Optional<String> result = dialog.showAndWait();
        date = (result.get());
        double[] deaths = myFileTools.ne1DeathsPerContinent(date);
        double totalDeaths = 0.0;
        double[] percentage = new double[deaths.length];
        for(int i = 0; i < deaths.length; i++){
            totalDeaths += deaths[i]; 
        }

        for(int j = 0; j < percentage.length; j++){
            percentage[j] = ((deaths[j] * 360) / totalDeaths);            
        }
        
        PieChart pieChart = new PieChart(percentage);
        pane.getChildren().add(pieChart);        
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
        MyFileTools myFileTools = new MyFileTools(getFileName(), ",", getFileName(),getFileName());
        
        int[] cityPopulation = myFileTools.getCityPopulation(getFileName(), ",", "Beijing");
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
