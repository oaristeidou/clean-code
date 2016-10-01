package de.oaristeidou.cleancode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by odyssefs on 01.10.16.
 */
public class ChristmasTree {
    public static int TREE_DEPTH = 6;
    public static char CHARACTER = 'X';
    protected static char BASE_CHAR = 'I';

    public static void printTreeLine(int emptyDigits, int charDigits) {
        printTreeLine (emptyDigits, charDigits, false);
    }

    public static void printTreeLine(int emptyDigits, int charDigits, boolean isBase) {
        printDigits(emptyDigits, ' ');
        if (isBase)
            printDigits(charDigits, BASE_CHAR);
        else
            printDigits(charDigits, CHARACTER);
    }

    public static void newLine() {
        System.out.print(System.lineSeparator());
    }

    private static void printDigits(int charDigits, char character) {
        for (int i = 1; i <= charDigits; i++)
            System.out.print(character);
    }


    public static Map<Integer, Map<String, Integer>> calculateTreeLines() {
        return calculateTreeLines (0, ' ');
    }

    public static Map<Integer, Map<String, Integer>> calculateTreeLines(int treeDepth, char character) {
        if (treeDepth > 0 ){
            TREE_DEPTH = treeDepth;
            CHARACTER = character;
        }

        Map<Integer, Map<String, Integer>> tempMap = new HashMap<>();

        for (int i = 1; i <= TREE_DEPTH; i++) {
            Map<String, Integer> innerMap = new HashMap<>();
            innerMap.put("empty", TREE_DEPTH - i);
            innerMap.put("char", i + (i - 1));
            tempMap.put(i, innerMap);
            if (TREE_DEPTH == i){
                innerMap = new HashMap<>();
                innerMap.put("baseEmpty", tempMap.get(1).get("empty"));
                innerMap.put("baseChar", tempMap.get(1).get("char"));
                tempMap.put(i+1, innerMap);
            }
        }
        return tempMap;
    }

    public static void printTreeMap (Map<Integer, Map<String, Integer>> treeMap){

        for (int i = 1 ; i <= TREE_DEPTH ; i++){
            Map<String, Integer> leafMap = treeMap.get(i);
            printTreeLine(leafMap.get("empty"), leafMap.get("char"));
            newLine();
            if (TREE_DEPTH == i)
                printTreeLine(treeMap.get(i+1).get("baseEmpty"), treeMap.get(i+1).get("baseChar"), true);
        }
    }
}
