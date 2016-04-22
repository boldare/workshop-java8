package pl.xsolve.workshops.java8.fileio.lesson.two;

import pl.xsolve.workshops.java8.fileio.dto.RestaurantDto;
import pl.xsolve.workshops.java8.fileio.lesson.one.LessonOne;

import java.util.List;
import java.util.stream.Stream;

public interface LessonTwo extends LessonOne {

    void correctData();

    List<RestaurantDto> mapToOrderedListOfRestaurants(Stream<String> stream);
}
