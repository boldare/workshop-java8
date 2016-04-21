package pl.xsolve.workshops.java8.fileio;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface LessonOne {

    String FILE_WITH_DIRTY_DATA = "data.csv";
    String FILE_WITH_CORRECTED_DATA = "corrected_data.csv";

    Path buildDirtyFilePath();

    Path buildCorrectedFilePath();

    Stream<String> loadFile(Path path) throws IOException;

    Stream<String> openAndCloseStream();

    long countElements();
}
