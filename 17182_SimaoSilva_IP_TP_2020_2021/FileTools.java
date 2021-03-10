import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Just utility methods to read a csv file to an array or array of arrays
 * @author João Paulo barros
 * @version 2021-02-01
 */
public class FileTools {
    public static final String EOL = System.getProperty("line.separator");

    /**
     * read all lines to one array of Strings
     *
     * @param filename file to read
     * @return array with one line in each position
     *         or empty array if error reading file
     */
    public static String[] readFileToStringArray(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename)).toArray(new String[0]);
        } catch (IOException e) {
            String errorMessage = "Error reading file " + filename;
            showError(errorMessage);
            System.out.println(errorMessage + " - Exception " + e.toString());
            return new String[0];
        }
    }

    /**
     * read all lines to one array of arrays of Strings
     *
     * @param filename  file to read
     * @param separator separator for tokens in each line
     * @return array with one array of tokens in each position
     *         or empty array if error reading file
     */
    public static String[][] readFileToStringArray2D(String filename, String separator) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            String[][] allData = new String[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                allData[i] = lines.get(i).split(separator);
            }
            return allData;
        } catch (IOException e) {
            String errorMessage = "Error reading file " + filename;
            showError(errorMessage);
            System.out.println(errorMessage + " - Exception " + e.toString())  ;
            return new String[0][];
        }
    }

    /**
     * write array contents to given text file
     * @param filename file where array content will be written
     * @param lines line to be written
     */
    public static void writeFile(String filename, String[] lines) {
        try {
            Files.write(Paths.get(filename), Arrays.asList(lines)); // escreve a lista para ficheiro
        } catch (IOException e) {
            String errorMessage = "Error writing file " + filename;
            showError(errorMessage + " - Exception " + e.toString());
            System.out.println(errorMessage);
        }
    }

    /**
     * read first line of given file
     * @param filename file to read
     */
    public static String readFirstLine(String filename) {
        try {
            return new BufferedReader(new FileReader(filename)).readLine();
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * show simple error message in a modal dialog
     * @param message message to be presented to the user
     */
    private static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
