package de.oaristeidou.cleancode.csv_table;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by odyssefs on 22.10.16.
 */
public class TestCsvTable {

    @Test (dataProvider = "dataToTable")
    public void testToTable (String[] toCovertTable, String[] expectedTable){
        assertEquals (CsvTable.toTable(toCovertTable), expectedTable);
    }

    @Test (dataProvider = "dataAddArraysToTwoDimentionArray")
    public void testAddArraysToTwoDimentionArray (String[] array1, String[] array2, String[] array3, String[][] expectedArray){
        assertEquals(CsvTable.addArraysToTwoDimentionArray(array1, array2, array3), expectedArray);
    }

    @Test(dataProvider = "dataGetMaxColumnLength")
    public void testGetMaxColumnLength (String[][] csvLines, int[] expectedArray){
        assertEquals(CsvTable.getMaxColumnLength(csvLines), expectedArray);
    }

    @Test(dataProvider = "dataSplitArray")
    public void testSplitArray(String[] csvLines, String[][] expectedCsvLines){
        assertEquals(CsvTable.splitArray(csvLines), expectedCsvLines);
    }

    @DataProvider
    public Object[][] dataSplitArray() {
        return new Object[][]{
                {getTempCvsLines(), getTempCvsLinesArray()}
        };
    }

    @DataProvider
    public Object[][] dataGetMaxColumnLength() {
        int [] expectedArray = new int[]{13, 16, 13, 5};
        return new Object[][]{
                {getTempCvsLinesArray(), expectedArray}
        };
    }

    @DataProvider
    public Object[][] dataAddArraysToTwoDimentionArray (){
        String[] array1 = new String[]{"Name     |", "Strasse  |", "Ort         |", "Alter|"};
        String[] array2 = new String[]{"---------+", "---------+", "------------+", "-----+"};
        String[] array3 = new String[]{"Peter Pan|", "Am Hang 5|", "12345 Einsam|", "42    "};

        String[][] expectedArray = new String[][] {
                {"Name     |", "Strasse  |", "Ort         |", "Alter|"},
                {"---------+", "---------+", "------------+", "-----+"},
                {"Peter Pan|", "Am Hang 5|", "12345 Einsam|", "42   |"}
        };
        return new Object[][] {
                {array1, array2, array3, expectedArray}
        };
    }


    @DataProvider
    public Object[][] dataToTable (){
        return new Object[][]{
                {getTempCvsLines(), getTempCvsLinesArray()}
        };
    }

    private String[] getTempCvsLines() {
        String[] tempCSVLines = new String [] {
                "Name;Vorname;Ort;Alter",
                "Peter Pan;Am Hang 5;12345 Einsam;42",
                "Maria Schmitz;Kölner Straße 45;501234 Köln;43",
                "Paul Meier;Münchnener Weg 1;87654 München;65",
                "Lol;Benjamin;München;31"
        };
        return tempCSVLines;
    }

    private String[][] getTempCvsLinesArray() {
        String[][] tempCSVLines = new String [][] {
                "Name;Vorname;Ort;Alter".split(";"),
                "Peter Pan;Am Hang 5;12345 Einsam;42".split(";"),
                "Maria Schmitz;Kölner Straße 45;501234 Köln;43".split(";"),
                "Paul Meier;Münchnener Weg 1;87654 München;65".split(";"),
                "Lol;Benjamin;München;31".split(";")
        };
        return tempCSVLines;
    }

    private String[][] getFormatCvsTable() {
        String[][] tempCSVLines = new String [][] {
                {"Name         |Vorname         |Ort          |Alter|"},
                {"-------------+----------------+-------------+-----+"},
                {"Peter Pan    |Am Hang 5       |12345 Einsam |42   |"},
                {"Maria Schmitz|Kölner Straße 45|501234 Köln  |43   |"},
                {"Paul Meier   |Münchnener Weg 1|87654 München|65   |"},
                {"Lol          |Benjamin        |81476 München|31   |"}
        };
        return tempCSVLines;
    }
}
