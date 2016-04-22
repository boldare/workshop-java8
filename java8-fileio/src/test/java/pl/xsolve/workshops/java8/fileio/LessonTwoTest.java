package pl.xsolve.workshops.java8.fileio;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import pl.xsolve.workshops.java8.fileio.dto.RestaurantDto;
import pl.xsolve.workshops.java8.fileio.lesson.two.LessonTwo;
import pl.xsolve.workshops.java8.fileio.lesson.two.LessonTwoImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LessonTwoTest {

    protected LessonTwo filesExercises = new LessonTwoImpl();

    @Test
    public void testCorrectData() throws IOException {
        filesExercises.correctData();

        validateFileElementsCount(filesExercises.buildDirtyFilePath(), 184538);
        validateFileElementsCount(filesExercises.buildCorrectedFilePath(), 180557);
    }

    @Test
    public void testMapToOrderedListOfRestaurants() throws IOException {
        Path path = filesExercises.buildCorrectedFilePath();
        List<RestaurantDto> expectedOrderedList = null;
        List<RestaurantDto> receivedOrderedList = null;

        try (Stream<String> stream = Files.lines(path)) {
            expectedOrderedList = stream
                    .parallel()
                    .map(line -> new RestaurantDto(line))
                    .sorted((a, b) -> a.getCity().compareTo(b.getCity()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            Assert.assertFalse(true);
        }

        try (Stream<String> stream = Files.lines(path)) {
            receivedOrderedList = filesExercises.mapToOrderedListOfRestaurants(stream);
        } catch (IOException e) {
            Assert.assertFalse(true);
        }

        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedOrderedList, receivedOrderedList));
    }

    protected void validateFileElementsCount(Path file, int expectedCount) {
        try (Stream<String> stream = Files.lines(file)) {
            long numOfElements = stream.count();

            Assert.assertEquals(expectedCount, numOfElements);
        } catch (IOException e) {
            Assert.assertFalse(true);
        }
    }
}
