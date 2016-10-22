package de.oaristeidou.cleancode.csv_table;

import java.util.Arrays;

/**
 * Created by odyssefs on 22.10.16.
 */
public class CsvTable {
    public static String[][] toTable (String [][] csvLines){
        return addArraysToTwoDimentionArray (addHeader(3), addHeaderSeparator(3), addBody (3));
    }

    public static String[] addHeader(int maxColumnLegth){
        return null;
    }

    public static String[] addBody(int maxColumnLegth){
        return null;
    }

    public static String[] addHeaderSeparator(int maxColumnLegth){
        return null;
    }

    public static String[][] addArraysToTwoDimentionArray(String[]... arrays){
        String[][] twoDimentionArray = new String[arrays.length][];
        for (int i = 0 ; i< arrays.length ; i++){
            twoDimentionArray[i] = arrays[i];
        }
        return twoDimentionArray;
    }

}
