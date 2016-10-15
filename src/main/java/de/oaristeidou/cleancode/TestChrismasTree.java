package de.oaristeidou.cleancode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;


/**
 * Created by odyssefs on 01.10.16.
 */
public class TestChrismasTree {

    @Test(dataProvider = "dataPrinTreeLine")
    public void testPrintLineTree(int emptyDigits, int charDigits, char character, String expected) {
        // Create a PrintStream for testing
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        // Call testing method
        ChristmasTree.printTreeLine(emptyDigits, charDigits);

        // Compare the output
        assertEquals(os.toString(), expected);
    }

    @Test(dataProvider = "dataPrintTreeMap")
    public void testPrintTreeMap(Map<Integer, Map<String, Integer>> treeMap, String expected) {
        // Create a PrintStream for testing
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        // Call testing method
        ChristmasTree.printTreeMap (treeMap);

        // Compare the output
        assertEquals(os.toString(), expected);
    }

    @Test(dataProvider = "dataCalculateTreeLines")
    public void testCalculateTreeLines(int treeDepth, Map expected) {
        assertEquals(ChristmasTree.calculateTreeLines(treeDepth, 'X'), expected);
        assertEquals(ChristmasTree.calculateTreeLines(), expected);
    }

    @DataProvider
    public static Object[][] dataPrintTreeMap() {
        StringBuilder expected = new StringBuilder();
        expected.append("     X");
        expected.append(System.lineSeparator());
        expected.append("    XXX");
        expected.append(System.lineSeparator());
        expected.append("   XXXXX");
        expected.append(System.lineSeparator());
        expected.append("  XXXXXXX");
        expected.append(System.lineSeparator());
        expected.append(" XXXXXXXXX");
        expected.append(System.lineSeparator());
        expected.append("XXXXXXXXXXX");
        expected.append(System.lineSeparator());
        expected.append("     I");

        return new Object[][]{
                {getTreeMap(), expected.toString()}
        };
    }

    @DataProvider
    public static Object[][] dataPrinTreeLine() {
        return new Object[][]{
                {5, 1, 'X', "     X"},
                {4, 3, 'X', "    XXX"},
                {3, 5, 'X', "   XXXXX"},
                {2, 7, 'X', "  XXXXXXX"},
                {1, 9, 'X', " XXXXXXXXX"},
                {0, 11, 'X', "XXXXXXXXXXX"},
                {5, 1, 'X', "     X"},
        };
    }

    @DataProvider
    public static Object[][] dataCalculateTreeLines() {
        Map<Integer, Map<String, Integer>> map = getTreeMap();

        return new Object[][]{
                {6, map}
        };
    }

    private static Map<Integer, Map<String, Integer>> getTreeMap() {
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> innerMap = new HashMap<>();
        innerMap.put("empty", 5);
        innerMap.put("char", 1);
        map.put(1, innerMap);

        innerMap = new HashMap<>();
        innerMap.put("empty", 4);
        innerMap.put("char", 3);
        map.put(2, innerMap);

        innerMap = new HashMap<>();
        innerMap.put("empty", 3);
        innerMap.put("char", 5);
        map.put(3, innerMap);

        innerMap = new HashMap<>();
        innerMap.put("empty", 2);
        innerMap.put("char", 7);
        map.put(4, innerMap);

        innerMap = new HashMap<>();
        innerMap.put("empty", 1);
        innerMap.put("char", 9);
        map.put(5, innerMap);

        innerMap = new HashMap<>();
        innerMap.put("empty", 0);
        innerMap.put("char", 11);
        map.put(6, innerMap);

        innerMap = new HashMap<>();
        innerMap.put("baseEmpty", 5);
        innerMap.put("baseChar", 1);
        map.put(7, innerMap);

        return map;
    }
}
