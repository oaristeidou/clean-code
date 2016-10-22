package de.oaristeidou.cleancode.csv_table;


import com.beust.jcommander.Strings;

import java.util.Arrays;

/**
 * Created by odyssefs on 22.10.16.
 */
public class CsvTable {
    public static String[][] toTable (String [] csvLines){
        String [][] sliptedCsvLines = splitArray (csvLines);
        int[] maxColumnLengthArray = getMaxColumnLength (sliptedCsvLines);
        return addArraysToTwoDimentionArray (addHeader(sliptedCsvLines[0], maxColumnLengthArray), addHeaderSeparator(maxColumnLengthArray), addBody (maxColumnLengthArray));
    }

    public static String[][] splitArray(String[] csvLines) {
        String[][] sliptedCsvLines = new String[csvLines.length][];
        for (int i = 0; i < csvLines.length; i++)
            sliptedCsvLines[i]= csvLines[i].split(";");
        return sliptedCsvLines;
    }

    public static String[] addHeader(String[] headerArray, final int[] maxColumnLegth){
        for (int i = 0; i < headerArray.length; i++)
            headerArray[i] += repeat(" ", maxColumnLegth[i] - headerArray[i].length()) + "|";
        return headerArray;
    }

    public static String[] addBody(final int[] maxColumnLegth){
        return null;
    }

    public static String[] addHeaderSeparator(final int[] maxColumnLegth){
        String[] headerSeparatorArray = new String[maxColumnLegth.length];
        for (int i = 0; i < maxColumnLegth.length; i++)
            headerSeparatorArray[i] = repeat("-", maxColumnLegth[i]) + "+";
        return headerSeparatorArray;
    }

    public static String[][] addArraysToTwoDimentionArray(String[]... arrays){
        String[][] twoDimentionArray = new String[arrays.length][];

        for (int i = 0 ; i< arrays.length ; i++){
            twoDimentionArray[i] = arrays[i];
        }

        return twoDimentionArray;
    }

    public static int[] getMaxColumnLength (String[][] csvLines){
        int[] maxColumnLengthArray = new int[csvLines[0].length];

        for (int column = 0 ; column < csvLines[0].length ; column++){
            int maxColumnLength = 0;
            for (int row = 0 ; row < csvLines[column].length  ; row++){
                if (maxColumnLength < csvLines[row][column].length())
                    maxColumnLength = csvLines[row][column].length();
            }
            maxColumnLengthArray[column] = maxColumnLength;
        }

        return maxColumnLengthArray;
    }

    public static String repeat(String s, int times) {
        if (times <= 0)
            return "";
        else
            return s + repeat(s, times - 1);
    }
}
