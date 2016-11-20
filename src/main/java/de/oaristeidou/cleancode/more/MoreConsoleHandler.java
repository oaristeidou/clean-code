package de.oaristeidou.cleancode.more;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by odyssefs on 19.11.16.
 */
public class MoreConsoleHandler {
    private static int nextIndex = 0;
    private static String userInput = null;
    private static final String ESC = "esc";
    private static final String USER_CONSOLE_MESSAGE = "--- Weiter mit jeder Taste. Abbruch mit [Esc]. ---";

    public static void consoleOutput(List<String> lineBlocks, int maxLines) throws IOException {
        do {
            printBlocks(lineBlocks, maxLines);
            readUserInput();
        } while (isTextAtTheEndOrUserInputBreak(lineBlocks));
    }

    public static boolean isTextAtTheEndOrUserInputBreak(List<String> lineBlocks) {
        return !ESC.equalsIgnoreCase(userInput) && nextIndex < lineBlocks.size();
    }

    public static void printBlocks(List<String> lineBlocks, int maxLines) {
        int index;
        for (index = 0; index < maxLines; index++) {
            if (nextIndex >= lineBlocks.size())
                break;
            System.out.println(lineBlocks.get(nextIndex));
            nextIndex++;
        }
    }

    public static void readUserInput() throws IOException {
        if (!ESC.equalsIgnoreCase(userInput))
            System.out.println(USER_CONSOLE_MESSAGE);
        userInput = new Scanner(System.in).nextLine();
    }

}
