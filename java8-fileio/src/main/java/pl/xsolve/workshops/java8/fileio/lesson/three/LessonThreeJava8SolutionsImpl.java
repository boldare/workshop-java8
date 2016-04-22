package pl.xsolve.workshops.java8.fileio.lesson.three;

import pl.xsolve.workshops.java8.fileio.analizer.RestaurantAnalizer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class LessonThreeJava8SolutionsImpl extends RestaurantAnalizer {

    public boolean isAllEntriesFreeWifi(String fileName) {
        Path path = getPath(fileName);

        try (Stream<String> stream = Files.lines(path).skip(NUMBER_OF_HEADER_LINES)) {
            return stream
                    .map(line -> toMcDonalds(line))
                    .filter(it -> it != null)
                    .allMatch(it -> it.getFreeWiFi());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
