package de.oaristeidou.cleancode.christmas_tree;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by odyssefs on 01.10.16.
 */
public class Main {
    public static void main (String []args){

        Scanner reader = new Scanner(System.in);
        System.out.println("******** Creation of a Christmas tree ********");
        System.out.println("Enter a depth value: ");
        int treeDepth = reader.nextInt();

        System.out.println("Enter a character value: ");
        char a = reader.next().charAt(0);

        Map<Integer, Map<String, Integer>> tempTreeMap = ChristmasTree.calculateTreeLines(treeDepth, a);
        ChristmasTree.printTreeMap(tempTreeMap);
    }

}
