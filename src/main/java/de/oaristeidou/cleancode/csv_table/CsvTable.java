package de.oaristeidou.cleancode.csv_table;


/**
 * Created by odyssefs on 22.10.16.
 */
public class CsvTable {
    public static String[] toTable (String [] csvLines){
        String [][] sliptedCsvLines = splitArray (csvLines);
        int[] maxColumnLengthArray = getMaxColumnLength (sliptedCsvLines);
        String tableHeader = addTableLine(sliptedCsvLines[0], maxColumnLengthArray);
        String separatorLine = addLineSeparator(maxColumnLengthArray);
        String[] tableBody = addTableBody(sliptedCsvLines, maxColumnLengthArray);

        return formatMatrix(tableHeader, separatorLine, tableBody);
    }

    public static String[][] splitArray(String[] csvLines) {
        String[][] sliptedCsvLines = new String[csvLines.length][];
        for (int i = 0; i < csvLines.length; i++)
            sliptedCsvLines[i]= csvLines[i].split(";");
        return sliptedCsvLines;
    }

    public static String addTableLine(String[] headerArray, final int[] maxColumnLegth){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < headerArray.length; i++){
            builder.append(headerArray[i]);
            builder.append(repeat(" ", maxColumnLegth[i] - headerArray[i].length()));
            builder.append("|");
        }
        return builder.toString();
    }

    public static String[] addTableBody(String [][] sliptedCsvLines, final int[] maxColumnLegth){
        String[] bodyArrayFormatted = new String[sliptedCsvLines.length-1];

        for (int row=0; row < sliptedCsvLines.length-1; row++){
            bodyArrayFormatted[row]= addTableLine(sliptedCsvLines[row+1], maxColumnLegth);
        }

        return bodyArrayFormatted;
    }

    public static String addLineSeparator(final int[] maxColumnLegth){
        StringBuilder headerSeparatorArray = new StringBuilder();

        for (int i = 0; i < maxColumnLegth.length; i++){
            headerSeparatorArray.append(repeat("-", maxColumnLegth[i]));
            headerSeparatorArray.append("+");
        }

        return headerSeparatorArray.toString();
    }

    public static String[] formatMatrix(String header, String separatorLine, String[] bodyArray){
        String[] arrayFormatted = new String[bodyArray.length + 2];
        arrayFormatted[0] = header;
        arrayFormatted[1] = separatorLine;

        for (int i = 2 ; i< bodyArray.length + 2; i++){
            arrayFormatted[i] = bodyArray[i-2];
        }

        return arrayFormatted;
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
