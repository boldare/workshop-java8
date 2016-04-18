package pl.xsolve.workshops.java8.fileio;

import org.junit.Assert;
import org.junit.Test;
import pl.xsolve.workshops.java8.fileio.lesson.one.LessonOne;
import pl.xsolve.workshops.java8.fileio.lesson.one.LessonOneImpl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class LessonOneTest {

    protected LessonOne filesExercises = new LessonOneImpl();

    @Test
    public void testLoadFile() throws IOException {
        Path pathToFile = filesExercises.buildDirtyFilePath();

        Assert.assertEquals("27.77371109;-97.41978157;Corpus Christi;78405;2424 Baldwin Blvd",
                filesExercises.loadFile(pathToFile)
                .findFirst()
                .get());
    }

    @Test
    public void testOpenAndCloseStream() throws IOException {
        Stream<String> closedStream = filesExercises.openAndCloseStream();

        try {
            closedStream.findFirst();

            Assert.assertFalse(true);
        } catch (Exception e) {
            Assert.assertEquals("stream has already been operated upon or closed", e.getMessage());
        }
    }

    @Test
    public void testCountElements() throws IOException {
        long expectedResult = 184538L;
        long countedRecords = filesExercises.countElements();

        Assert.assertEquals(expectedResult, countedRecords);
    }
}
