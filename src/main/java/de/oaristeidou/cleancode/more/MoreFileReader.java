package de.oaristeidou.cleancode.more;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by odyssefs on 19.11.16.
 */
public class MoreFileReader {

    private File filetext;
    private InputStream filetextStream;
    private URL resource;

    public Stream<String> readFile (String filename) throws IOException, URISyntaxException {
        setupFileStream (filename);
        return reformatToList ();
    }

    private void setupFileStream (String filename) throws IOException, URISyntaxException {
        this.resource = MoreFileReader.class.getResource(filename);
        this.filetextStream = this.resource.openStream();
        this.filetext = new File(this.resource.toURI());

    }

    private Stream<String> reformatToList () throws IOException {
        return Files.lines(Paths.get(resource.getPath()));
    }
}
