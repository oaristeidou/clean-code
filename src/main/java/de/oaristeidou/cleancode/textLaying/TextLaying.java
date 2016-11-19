package de.oaristeidou.cleancode.textLaying;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by odyssefs on 06.11.16.
 */
public class TextLaying {

    public String textLaying(String text, int maxParagraphLegth) {
        String cleanText = cleanText(text);
        String[] words = splitTextToWords(cleanText);
        return applytextLayout(words, maxParagraphLegth);
    }

    public static String cleanText(String text) {
        return text.replaceAll("\\s+", " ").replace(System.lineSeparator(), "");
    }

    public static String[] splitTextToWords(String cleanText) {
        return cleanText.split(" ");
    }

    public static String applytextLayout(String[] words, int maxParagraphLegth) {
        return "";
    }

    public static List<String> applyLineLayout(String words[], int maxParagraphLegth) {
        List textLines = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            int newLineIndex = 0;
            if (words[i].length() + 1 < maxParagraphLegth && builder.length() < maxParagraphLegth){
                builder.append(words[i]);
                builder.append(" ");
            }
            else{
                builder.append(words[i].substring(maxParagraphLegth));
            }

            if (builder.length() >= maxParagraphLegth){
                textLines.add(builder.toString().trim() + "\n");
                builder = new StringBuilder();
            }

        }

        return textLines;
    }

    public static List<String> applyJustifyLayout(List<String> lines) {
        return null;
    }

    public static String appendLinesToText(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines)
            builder.append(line);
        return builder.toString();
    }


}
