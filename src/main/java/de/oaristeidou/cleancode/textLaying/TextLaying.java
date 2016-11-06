package de.oaristeidou.cleancode.textLaying;

import java.util.List;

/**
 * Created by odyssefs on 06.11.16.
 */
public class TextLaying {

    public String textLaying (String text, int maxParagraphLegth){
        String cleanText = cleanText(text);
        String[] words = splitTextToWords(cleanText);
        return applytextLayout(words, maxParagraphLegth);
    }

    public static String cleanText (String text){
        return text.replaceAll("\\s+"," ").replace(System.lineSeparator(), "");
    }

    public static String [] splitTextToWords (String cleanText){
        return cleanText.split(" ");
    }

    public String applytextLayout (String [] words, int maxParagraphLegth){
        return "";
    }

    public List<String> applyLineLayout (String word[]){
        return null;
    }


}
