package pl.xsolve.workshops.java8.fileio;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GenericLesson {

    protected Path getPath(String fileName) {
        try {
            return Paths.get(ClassLoader.getSystemResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
