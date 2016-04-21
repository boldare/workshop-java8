package pl.xsolve.workshops.java8.fileio;

import pl.xsolve.workshops.java8.fileio.dto.RestaurantDto;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface LessonTwo extends LessonOne {

    void correctData();

    List<RestaurantDto> mapToOrderedListOfRestaurants(Stream<String> stream);
}
