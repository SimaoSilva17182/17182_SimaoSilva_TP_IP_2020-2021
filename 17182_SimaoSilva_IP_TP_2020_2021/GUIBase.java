import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for actions
 * @author Joao Paulo Barros
 * @version 2021-02-01
 */
public class GUIBase extends Application {

    protected Pane pane;
    private TextField fileNameTextField;
    private Map<String, Runnable> actions;
    private String commandLineAction;
    private String commandLineFileName;
    private static String initialFileName = "datafiles/filename.txt";
    private static final String LAST_FILENAME = "lastfilename.txt";

    /**
     * @param args can have an action name
     */
    public GUIBase(String[] args) {
        setInitialFileName();
        this.commandLineFileName = (args.length == 2 ) ? args[0] : initialFileName;
        this.commandLineAction = (args.length == 2 ) ? args[1] : "";
        this.actions = new HashMap<>();
    }

    private void setInitialFileName() {
        String line = FileTools.readFirstLine(LAST_FILENAME);
        if (!line.isEmpty())
            initialFileName = line;
    }

    public String getFileName() {
        return fileNameTextField.getText();
    }

    /**
     * add one action to the map
     * @param name action name
     * @param action method to be run
     */
    protected void addCommand(String name, Runnable action) {
        this.actions.put(name, action);
    }

    protected void launch() {
        // Initialises JavaFX:
        new JFXPanel();
        // Makes sure JavaFX doesn't exit when first window is closed:
        Platform.setImplicitExit(false);
        // Runs initialisation on the JavaFX thread:
        Platform.runLater(() -> start(new Stage()));
    }

    /**
     * set up the stage (window) and its menu
     * @param primaryStage application stage
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setOnCloseRequest(e -> exit());
        MenuBar menuBar = new MenuBar();
        Menu drawMenu = new Menu("Operations");
        addMenuItem(drawMenu, "Delete all", this::clear);
        addMenuItems(drawMenu);
        addMenuItem(drawMenu, "Exit", this::exit);
        menuBar.getMenus().add(drawMenu);
        this.pane = new Pane();
        pane.setPrefSize(900, 600);
        this.fileNameTextField = new TextField(this.commandLineFileName);
        HBox hBox = new HBox(menuBar, fileNameTextField);
        VBox vBox = new VBox(hBox, pane);
        primaryStage.setScene(new Scene(vBox, Color.WHITE));
        primaryStage.show();
        executeCommandLineAction();
    } // END start

    /**
     * action to exit the program
     */
    private void exit() {
        Platform.runLater(() -> {
            FileTools.writeFile(LAST_FILENAME, new String[] {this.getFileName()});
            Platform.exit();
            System.exit(0);
        });
    }

    /**
     * action to delete all drawings in pane
     */
    private void clear() {
        Platform.runLater(() -> {
            pane.getChildren().clear();
        });
    }

    /**
     * Execute the action in the command line
     */
    private void executeCommandLineAction() {
        if (actions.containsKey(commandLineAction)) {
            this.actions.get(commandLineAction).run();
        }
    }

    /**
     * add all menu items in map
     * @param menu parent menu
     */
    private void addMenuItems(Menu menu) {
        for (Map.Entry<String, Runnable> action : this.actions.entrySet()) {
            addMenuItem(menu, action.getKey(), action.getValue());
        }
    }

    /**
     * add a menu item and respetive action
     * @param menu parent menu
     * @param itemName item name
     * @param action method to be executed
     */
    private void addMenuItem(Menu menu, String itemName, Runnable action) {
        MenuItem menuItem1 = new MenuItem(itemName);
        menuItem1.setOnAction(e -> action.run());
        menu.getItems().add(menuItem1);
    }
}
