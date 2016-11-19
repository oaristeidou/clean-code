package de.oaristeidou.cleancode.more;

import java.util.List;

/**
 * Created by odyssefs on 19.11.16.
 */
public class More {

    public void more (String filename){
        List<String> lineBlocks = readFile (filename);
        consoleOutput(lineBlocks);
    }

    public List<String> readFile (String filename){
        return null;
    }

    public void consoleOutput (List<String> lineBlocks){

    }
}
