package de.oaristeidou.cleancode.csv_table;

import de.oaristeidou.cleancode.csv_table.CsvTable;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * Created by odyssefs on 22.10.16.
 */
public class TestCsvTable {

    private static final String[] HEADROW = {"Name", "Strasse", "Ort", "Alter"};
    private static final String HEADROW_FORMATTED = "Name         |Strasse         |Ort          |Alter|";
    private static final String SEPARATOR_ROW_FORMATTED = "-------------+----------------+-------------+-----+";
    private static final String[] FORMATTED_TABLE = new String[]{
            "Name         |Strasse         |Ort          |Alter|",
            "-------------+----------------+-------------+-----+",
            "Peter Pan    |Am Hang 5       |12345 Einsam |42   |",
            "Maria Schmitz|Kölner Straße 45|501234 Köln  |43   |",
            "Paul Meier   |Münchnener Weg 1|87654 München|65   |",
            "Lol          |Benjamin        |81476 München|31   |"
    };
    private static final String[] CSV_LINES = new String[]{
            "Name;Strasse;Ort;Alter",
            "Peter Pan;Am Hang 5;12345 Einsam;42",
            "Maria Schmitz;Kölner Straße 45;501234 Köln;43",
            "Paul Meier;Münchnener Weg 1;87654 München;65",
            "Lol;Benjamin;81476 München;31"
    };
    private static final String[][] CVS_SPLITTED_LINES = new String[][]{
            "Name;Vorname;Ort;Alter".split(";"),
            "Peter Pan;Am Hang 5;12345 Einsam;42".split(";"),
            "Maria Schmitz;Kölner Straße 45;501234 Köln;43".split(";"),
            "Paul Meier;Münchnener Weg 1;87654 München;65".split(";"),
            "Lol;Benjamin;81476 München;31".split(";")
    };
    private static final String[] FORMATTED_BODY = new String[]{
            "Peter Pan    |Am Hang 5       |12345 Einsam |42   |",
            "Maria Schmitz|Kölner Straße 45|501234 Köln  |43   |",
            "Paul Meier   |Münchnener Weg 1|87654 München|65   |",
            "Lol          |Benjamin        |81476 München|31   |"
    };

    private static final int[] MAX_COLUMN_LEGTH = new int[]{13, 16, 13, 5};

    @Test(dataProvider = "dataToTable")
    public void testToTable(String[] toCovertTable, String[] expectedTable) {
        assertEquals(CsvTable.toTable(toCovertTable), expectedTable);
    }

    @Test(dataProvider = "dataFormatMatrix")
    public void testFormatMatrix(String array1, String array2, String[] array3, String[] expectedArray) {
        assertEquals(CsvTable.formatMatrix(array1, array2, array3), expectedArray);
    }

    @Test(dataProvider = "dataGetMaxColumnLength")
    public void testGetMaxColumnLength(String[][] csvLines, int[] expectedArray) {
        assertEquals(CsvTable.getMaxColumnLength(csvLines), expectedArray);
    }

    @Test(dataProvider = "dataSplitArray")
    public void testSplitArray(String[] csvLines, String[][] expectedCsvLines) {
        assertEquals(Arrays.toString(CsvTable.splitArray(csvLines)), Arrays.toString(expectedCsvLines));
    }

    @Test(dataProvider = "dataAddTableLine")
    public void testAddTableLine(String[] headerArray, int[] maxColumnLegth, String expectedFormatedHeader) {
        assertEquals(CsvTable.addTableLine(headerArray, maxColumnLegth), expectedFormatedHeader);
    }

    @Test(dataProvider = "dataAddLineSeparator")
    public void testAddLineSeparator(int[] maxColumnLegth, String expectedLineSeparator) {
        assertEquals(CsvTable.addLineSeparator(maxColumnLegth), expectedLineSeparator);
    }

    @Test(dataProvider = "dataAddBody")
    public void testAddTableBody(String[][] sliptedCsvLines, int[] maxColumnLegth, String[] expectedFormatedHeaderArray) {
        assertEquals(CsvTable.addTableBody(sliptedCsvLines, maxColumnLegth), expectedFormatedHeaderArray);
    }

    @DataProvider
    public Object[][] dataAddBody() {
        return new Object[][]{
                {CVS_SPLITTED_LINES, MAX_COLUMN_LEGTH, FORMATTED_BODY}
        };
    }

    @DataProvider
    public Object[][] dataAddLineSeparator() {
        return new Object[][]{
                {MAX_COLUMN_LEGTH, SEPARATOR_ROW_FORMATTED}
        };
    }

    @DataProvider
    public Object[][] dataAddTableLine() {
        return new Object[][]{
                {HEADROW, MAX_COLUMN_LEGTH, HEADROW_FORMATTED}
        };
    }

    @DataProvider
    public Object[][] dataSplitArray() {
        return new Object[][]{
                {CSV_LINES, CVS_SPLITTED_LINES}
        };
    }

    @DataProvider
    public Object[][] dataGetMaxColumnLength() {
        return new Object[][]{
                {CVS_SPLITTED_LINES, MAX_COLUMN_LEGTH}
        };
    }

    @DataProvider
    public Object[][] dataFormatMatrix() {
        return new Object[][]{
                {HEADROW_FORMATTED, SEPARATOR_ROW_FORMATTED, FORMATTED_BODY, FORMATTED_TABLE}
        };
    }


    @DataProvider
    public Object[][] dataToTable() {
        return new Object[][]{
                {CSV_LINES, FORMATTED_TABLE}
        };
    }

}
