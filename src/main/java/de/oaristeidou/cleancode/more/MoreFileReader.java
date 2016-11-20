package de.oaristeidou.cleancode.more;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by odyssefs on 19.11.16.
 */
public class MoreFileReader {
    private static File filetext;
    private static InputStream filetextStream;
    private static URL resource;

    public static List<String> readFile(String filename) throws IOException, URISyntaxException {
        setupFileStream(filename);
        return reformatToList();
    }

    private static void setupFileStream(String filename) throws IOException, URISyntaxException {
        resource = MoreFileReader.class.getResource(filename);
        filetextStream = resource.openStream();
        filetext = new File(resource.toURI());
    }

    private static List<String> reformatToList() throws IOException {
        return Files.readAllLines(Paths.get(resource.getPath()));
    }
}
