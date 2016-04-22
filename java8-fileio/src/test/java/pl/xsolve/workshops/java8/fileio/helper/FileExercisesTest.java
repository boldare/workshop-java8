package pl.xsolve.workshops.java8.fileio.helper;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import pl.xsolve.workshops.java8.fileio.lesson.two.LessonTwo;
import pl.xsolve.workshops.java8.fileio.lesson.two.LessonTwoSolutionsImpl;
import pl.xsolve.workshops.java8.fileio.dto.RestaurantDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileExercisesTest {

    protected LessonTwo filesExercises = new LessonTwoSolutionsImpl();

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

    @Test
    public void testMapToUnorderedSetOfRestaurants() throws IOException {
        Path path = filesExercises.buildCorrectedFilePath();

        try (Stream<String> stream = Files.lines(path)) {

            List<RestaurantDto> orderedList = stream
                    .parallel()
                    .map(line -> new RestaurantDto(line))
                    .sorted((a, b) -> a.getCity().compareTo(b.getCity()))
                    .collect(Collectors.toList());

            List<RestaurantDto> unorderedList = new LinkedList<>(filesExercises.mapToOrderedListOfRestaurants(stream));

            Assert.assertTrue(CollectionUtils.isEqualCollection(orderedList, unorderedList));

        } catch (IOException e) {
            e.printStackTrace();
            Assert.assertFalse(true);
        }
    }
}
