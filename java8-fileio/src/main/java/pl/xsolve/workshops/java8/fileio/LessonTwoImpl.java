package pl.xsolve.workshops.java8.fileio;

import pl.xsolve.workshops.java8.fileio.dto.RestaurantDto;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pl.xsolve.workshops.java8.fileio.dto.RestaurantDto.DEFAULT_SEPARATOR;

public class LessonTwoImpl extends LessonOneImpl implements LessonTwo {

    @Override
    public void correctData() {
        Path path = buildDirtyFilePath();
        Path correctedFilePath  = buildCorrectedFilePath();

        try (Stream<String> stream = Files.lines(path);
             BufferedWriter writer = Files.newBufferedWriter(correctedFilePath)) {

            stream
                .filter(this::isRestaurantAlright)
                .distinct()
                .forEach(correctData -> addEntry(writer, correctData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RestaurantDto> mapToOrderedListOfRestaurants(Stream<String> stream) {
        return stream
                .map(restaurant -> new RestaurantDto(restaurant))
                .sorted((a, b) -> a.getCity().compareTo(b.getCity()))
                .collect(Collectors.toList());
    }

    protected Boolean isRestaurantAlright(String restaurant) {
        return restaurant.split(DEFAULT_SEPARATOR).length == 5 && !restaurant.contains(";;");
    }

    protected void addEntry(BufferedWriter writer, String correctData) {
        try {
           writer.write(correctData);
           writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
