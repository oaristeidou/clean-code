package de.oaristeidou.cleancode;

import de.oaristeidou.cleancode.more.MoreFileReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.testng.AssertJUnit.assertNotNull;

/**
 * Created by odyssefs on 19.11.16.
 */
public class TestMoreFileReader {

    @Test
    public void testReadFile() throws IOException, URISyntaxException {
        List<String> stringStream = MoreFileReader.readFile("/erlkoenig.txt");
        stringStream.forEach(System.out::println);
        assertNotNull(stringStream);
    }
}
