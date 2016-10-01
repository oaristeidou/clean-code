package de.oaristeidou.cleancode;

import java.util.Map;

/**
 * Created by odyssefs on 01.10.16.
 */
public class Main {
    public static void main (String []args){

        int treeDepth = 20;
        char a = 'X';
        Map<Integer, Map<String, Integer>> tempTreeMap = ChristmasTree.calculateTreeLines(treeDepth, a);
        ChristmasTree.printTreeMap(tempTreeMap);
    }

}
