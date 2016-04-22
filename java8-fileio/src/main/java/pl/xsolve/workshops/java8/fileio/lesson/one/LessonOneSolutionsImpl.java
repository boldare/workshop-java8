package pl.xsolve.workshops.java8.fileio.lesson.one;

import pl.xsolve.workshops.java8.fileio.GenericLesson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class LessonOneSolutionsImpl extends GenericLesson implements LessonOne {

    @Override
    public Path buildDirtyFilePath() {
        return getPath(FILE_WITH_DIRTY_DATA);
    }

    @Override
    public Path buildCorrectedFilePath() {
        return getPath(FILE_WITH_CORRECTED_DATA);
    }

    @Override
    public Stream<String> loadFile(Path path) throws IOException {
        return Files.lines(buildDirtyFilePath());
    }

    @Override
    public Stream<String> openAndCloseStream() {
        Path filePath = buildDirtyFilePath();

        try (Stream<String> stream = Files.lines(filePath)) {

            return stream;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long countElements() {
        Path filePath = buildDirtyFilePath();

        try (Stream<String> stream = Files.lines(filePath)) {
            return stream.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
