package de.oaristeidou.cleancode.csv_table;

import java.util.Arrays;

/**
 * Created by odyssefs on 22.10.16.
 */
public class CsvTable {
    public static String[][] toTable (String [][] csvLines){
        int[] maxColumnLengthArray = getMaxColumnLength (csvLines);
        return addArraysToTwoDimentionArray (addHeader(maxColumnLengthArray), addHeaderSeparator(maxColumnLengthArray), addBody (maxColumnLengthArray));
    }

    public static String[] addHeader(final int[] maxColumnLegth){
        return null;
    }

    public static String[] addBody(final int[] maxColumnLegth){
        return null;
    }

    public static String[] addHeaderSeparator(final int[] maxColumnLegth){
        return null;
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
}
