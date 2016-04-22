package pl.xsolve.workshops.java8.fileio.lesson.one;

import pl.xsolve.workshops.java8.fileio.GenericLesson;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class LessonOneImpl extends GenericLesson implements LessonOne {

    @Override
    public Path buildDirtyFilePath() {
        return getPath(FILE_WITH_DIRTY_DATA);
    }

    @Override
    public Path buildCorrectedFilePath() {
        return getPath(FILE_WITH_CORRECTED_DATA);
    }

    /**
     * Ćwiczenie 1
     *
     * Treść:
     * Zwróć Stream<String>. Wykorzystaj Path zwrócony przez buildDirtyFilePath(),
     *
     * Użyj:
     * - Files
     */
    @Override
    public Stream<String> loadFile(Path path) throws IOException {
        return null;
    }

    /**
     * Ćwiczenie 2
     *
     * Treść:
     * Utwórz stream i zamknij go.
     *
     * Użyj:
     * - try/catch
     */
    @Override
    public Stream<String> openAndCloseStream() {
        return null;
    }

    /**
     * Ćwiczenie 3
     *
     * Treść:
     * Bazując na doświadczeniu z lekcji 1 i 2. Otwórz stream, zlicz ilość elementów w stramie, a następnie go zamknij.
     *
     */
    @Override
    public long countElements() {
        return 0L;
    }
}
