package de.oaristeidou.cleancode.more;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by odyssefs on 19.11.16.
 */
public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        More.more(args[0], Integer.parseInt(args[1]));
    }
}
