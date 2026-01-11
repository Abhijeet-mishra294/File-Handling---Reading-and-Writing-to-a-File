
import java.io.*;

public class FileProcessor {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        int lineCount = 0;
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (!line.trim().isEmpty()) {
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
            return;
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Line count: " + lineCount);
            writer.newLine();
            writer.write("Word count: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
