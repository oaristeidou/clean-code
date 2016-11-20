package de.oaristeidou.cleancode.csv_tabelle;

import de.oaristeidou.cleancode.csv_tabelle.CSVTabulate;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by odyssefs on 22.10.16.
 */
public class TestCSVTabulate {

    private static final String[] HEADROW = {"Name", "Strasse", "Ort", "Alter"};
    private static final String[] ROW1 = {"Peter Pan", "Am Hang 5", "12345 Einsam", "42"};
    private static final String[] ROW2 = {"Maria Schmitz", "Kölner Straße 45", "50123 Köln", "43"};
    private static final String[] ROW3 = {"Paul Meier", "Münchener Weg 1", "87654 München", "65"};
    private static final Integer[] WIDTHS = {13, 16, 13, 5};
    private static final String[] FORMATTED_ROWS = {
            "Name         |Strasse         |Ort          |Alter|",
            "Peter Pan    |Am Hang 5       |12345 Einsam |42   |",
            "Maria Schmitz|Kölner Straße 45|50123 Köln   |43   |",
            "Paul Meier   |Münchener Weg 1 |87654 München|65   |"
    };

    @Test
    public void testFormatMatrix () {
        final List<List<String>> matrix = new ArrayList<>();
        matrix.add (Arrays.asList (HEADROW));
        matrix.add (Arrays.asList (ROW1));
        matrix.add (Arrays.asList (ROW2));
        matrix.add (Arrays.asList (ROW3));
        final List<String> result = CSVTabulate.formatMatrix (matrix, Arrays.asList (WIDTHS), 0, 4);
        for (int ii=0;ii<FORMATTED_ROWS.length;++ii)
        {
            assertTrue (FORMATTED_ROWS[ii].equals (result.get (ii)));
        }
    }

    @Test
    public void testFormatHeader () {
        List<List<String>> inputContentList = new ArrayList<>();
        inputContentList.add(Arrays.asList(new String[] {"Name", "Vorname", "Ort", "Alter"}));
        inputContentList.add(Arrays.asList(new String[] {"Mustermann", "Max", "Zöllighoven", "42"}));
        inputContentList.add(Arrays.asList(new String[] {"Lol", "Benjamin", "München", "31"}));

        List<Integer> columnLengthList = new ArrayList<>();
        columnLengthList.add(Integer.valueOf(10));
        columnLengthList.add(Integer.valueOf(8));
        columnLengthList.add(Integer.valueOf(11));
        columnLengthList.add(Integer.valueOf(5));

        assertTrue("Name      |Vorname |Ort        |Alter|".equals(CSVTabulate.formatHeader(inputContentList, columnLengthList)));
    }

    @Test
    public void formatBody (List<List<String>> matrix, List<Integer> collengths)
    {
        return;
    }

    @Test
    public void formatSeparator (List<Integer> collengths)
    {
        return;
    }

    @Test
    public void splitInput (List<String> cvslines)
    {
        return;
    }

    @Test(dataProvider = "dataGetMaxColumnLength")
    public void testGetMaxColumnLength (List<List<String>> matrix, List<Integer> exceptedListOutput) //matrix = List<Zeile>
    {
        assertEquals(CSVTabulate.getMaxColumnLength(matrix), exceptedListOutput);
    }

    @DataProvider
    public Object[][] dataGetMaxColumnLength() {
        List<Integer> exceptedListOutput = new ArrayList<>();
        exceptedListOutput.add(Integer.valueOf(13));
        exceptedListOutput.add(Integer.valueOf(16));
        exceptedListOutput.add(Integer.valueOf(13));
        exceptedListOutput.add(Integer.valueOf(5));
        return new Object[][]{
                {initTempMatrix(), exceptedListOutput}
        };
    }

    private List<List<String>> initTempMatrix() {
        List<List<String>> inputContentList = new ArrayList<>();
        inputContentList.add(Arrays.asList(new String[] {"Name", "Vorname", "Ort", "Alter"}));
        inputContentList.add(Arrays.asList(new String[] {"Peter Pan", "Am Hang 5", "12345 Einsam", "42"}));
        inputContentList.add(Arrays.asList(new String[] {"Maria Schmitz", "Kölner Straße 45", "501234 Köln", "43"}));
        inputContentList.add(Arrays.asList(new String[] {"Paul Meier", "Münchnener Weg 1", "87654 München", "65"}));
        inputContentList.add(Arrays.asList(new String[] {"Lol", "Benjamin", "München", "31"}));
        return inputContentList;
    }


    @Test (dataProvider = "dataTabulate")
    public void Tabulate (List<String> CSVLines, List<String> exceptedList){
        assertEquals(CSVTabulate.Tabulate(CSVLines), exceptedList);
    }

    @DataProvider
    public Object[][] dataTabulate (){
//        List<String> exceptedList = new ArrayList<>();
//        exceptedList.add(Arrays.to)
//
//        return new Object[][]{
//                {getTempCvsLines(), }
//
//        };
        return null;
    }

    private List<String> getTempCvsLines() {
        List<String> tempCSVLines = new ArrayList<>();
        tempCSVLines.add("Name;Vorname;Ort;Alter");
        tempCSVLines.add("Peter Pan;Am Hang 5;12345 Einsam;42");
        tempCSVLines.add("Maria Schmitz;Kölner Straße 45;501234 Köln;43");
        tempCSVLines.add("Paul Meier;Münchnener Weg 1;87654 München;65");
        tempCSVLines.add("Lol;Benjamin;München;31");
        return tempCSVLines;
    }
}
