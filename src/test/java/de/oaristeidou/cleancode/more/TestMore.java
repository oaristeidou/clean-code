package de.oaristeidou.cleancode.more;

import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by odyssefs on 19.11.16.
 */
public class TestMore {
    private File testFile;
    private InputStream testFileStream;

    @Before
    public void setup() throws URISyntaxException, IOException {
        URL resource = TestMore.class.getResource("/erlkoenig.txt");
        this.testFileStream = resource.openStream();
        this.testFile = new File(resource.toURI());
    }


}
