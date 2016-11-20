package de.oaristeidou.cleancode.more;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by odyssefs on 19.11.16.
 */
public class More {

    public static void more(String filename, int maxLines) throws IOException, URISyntaxException {
        List<String> lineBlocks = MoreFileReader.readFile(filename);
        MoreConsoleHandler.consoleOutput(lineBlocks, maxLines);
    }

}
