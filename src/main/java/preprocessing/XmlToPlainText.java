package preprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
a java class that transforms an xml file into a plain text file
It takes two arguments:
-a filename of an xml file
-a filename of where to store the resulting plain text file
 */

public class XmlToPlainText {

    public static String readFileAsString(String fileName) {
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }


    public static String cleanXmlTags(String xmlText) {
        // remove REDIRECT
        xmlText = xmlText.replaceAll("REDIRECT", " ");

        // removes whole matched foreign characters.
        xmlText = xmlText.replaceAll("([^\\x20-\\x7E]+)", " ");

        // remove ????: from ????:xxxx
        xmlText = xmlText.replaceAll("[a-zA-Z-]+:(\\w*)", "$1 "); // TODO

        xmlText = xmlText.replaceAll("&lt;.+&gt;", " ");

        // remove tags
        xmlText = xmlText.replaceAll("</?.*?>", " ");

        // replace &???;???;... to space
        xmlText = xmlText.replaceAll("&[a-zA-Z;]+;", " ");

        // remove 's
        xmlText = xmlText.replaceAll("'s", " ");

        // remove non-alphanumeric characters and underscore
        xmlText = xmlText.replaceAll("[\\W_]", " ");

        // remove 5+ digits numbers
        xmlText = xmlText.replaceAll("\\d{5,}", " ");

        // remove 1~2 digits numbers
        xmlText = xmlText.replaceAll("\\s\\d{1,2}\\s", " ");

        // remove excessive whitespaces
        xmlText = xmlText.replaceAll("\\s+", " ").trim();

        return xmlText;
    }

    public static void saveStringToFile(String content, String fileName) {
        try {


            Files.writeString(Paths.get(fileName), content);

            // encoding
            // Files.writeString(Paths.get(fileName), content, StandardCharsets.US_ASCII);

            // extra options
            // Files.writeString(Paths.get(fileName), content,
            // StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String fileName = args[0];
        String inputXml = readFileAsString(fileName);
        String cleanedText = cleanXmlTags(inputXml);
        saveStringToFile(cleanedText, args[1]);

    }
}
