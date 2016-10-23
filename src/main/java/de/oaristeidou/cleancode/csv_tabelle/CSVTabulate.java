package de.oaristeidou.cleancode.csv_tabelle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by odyssefs on 22.10.16.
 */
public class CSVTabulate {

    public static List<String> formatMatrix (List<List<String>> matrix, List<Integer> collengths, int start, int end)
    {
        final List<String> rval = new ArrayList<>();
        for (int ii=start;ii<end;++ii)
        {
            rval.add (formatLine (matrix.get (ii), collengths));
        }
        return rval;
    }

    public static String formatLine (final List<String> cols, final List<Integer> widths)
    {
        final StringBuilder rval = new StringBuilder();
        for (int ii=0;ii<cols.size();++ii)
        {
            rval.append(cols.get(ii));
            for (int jj=0;jj<widths.get(ii) - cols.get(ii).length();++jj)
            {
                rval.append (" ");
            }
            rval.append('|');
        }
        return rval.toString();
    }

    public static String formatHeader (List<List<String>> matrix, List<Integer> collengths)
    {
        return formatMatrix (matrix, collengths, 0, 1).get (0);
    }

    public static List<String> formatBody (List<List<String>> matrix, List<Integer> collengths)
    {
        return formatMatrix (matrix, collengths, 0, matrix.size ());
    }

    public static String formatSeparator (List<Integer> collengths)
    {
        return null;
    }

    public static List<List<String>> splitInput (List<String> cvslines)
    {
        List<List<String>> ret = new ArrayList<> ();

        for (String line : cvslines)
        {
            ret.add(Arrays.asList  (line.split (";")));
        }
        return ret;
    }

    public static  List<Integer> getMaxColumnLength (List<List<String>> matrix){
        int[] maxLengthByColumn = new int[matrix.get(0).size()];

        for (List<String> listItem : matrix){
            int index = 0;
            for (String item : listItem){
                if (maxLengthByColumn[index] < item.length())
                    maxLengthByColumn[index] = item.length();
                index++;
            }
        }

        return IntStream.of(maxLengthByColumn).boxed().collect(Collectors.toList());
    }

    public static List<String> Tabulate (List<String> CSVLines){
        List<List<String>> matrix = splitInput (CSVLines);
        List<Integer> colLengths = getMaxColumnLength (matrix);

        List<String> tabbedLines = new ArrayList<> ();
        tabbedLines.add (formatHeader (matrix, colLengths));
        tabbedLines.add (formatSeparator (colLengths));
        tabbedLines.addAll (formatBody (matrix, colLengths));

        return tabbedLines;
    }
}
