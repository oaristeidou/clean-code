package de.oaristeidou.cleancode.csv_table;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by odyssefs on 22.10.16.
 */
public class TestCsvTable {

    @Test (dataProvider = "dataToTable")
    public void testToTable (String[][] toCovertTable, String[][] expectedTable){
        assertEquals (CsvTable.toTable(toCovertTable), expectedTable);
    }

    @DataProvider
    public Object[][] dataToTable (){
        return new Object[][]{
                {getTempCvsLines(), }
        };
    }

    private String[][] getTempCvsLines() {
        String[][] tempCSVLines = new String [][] {
                {"Name;Vorname;Ort;Alter"},
                {"Peter Pan;Am Hang 5;12345 Einsam;42"},
                {"Maria Schmitz;Kölner Straße 45;501234 Köln;43"},
                {"Paul Meier;Münchnener Weg 1;87654 München;65"},
                {"Lol;Benjamin;München;31"}
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
