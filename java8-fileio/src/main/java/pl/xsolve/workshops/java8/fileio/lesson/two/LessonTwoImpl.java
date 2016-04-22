package pl.xsolve.workshops.java8.fileio.lesson.two;

import pl.xsolve.workshops.java8.fileio.dto.RestaurantDto;
import pl.xsolve.workshops.java8.fileio.lesson.one.LessonOneImpl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static pl.xsolve.workshops.java8.fileio.dto.RestaurantDto.DEFAULT_SEPARATOR;

public class LessonTwoImpl extends LessonOneImpl implements LessonTwo {

    /**
     * Ćwiczenie 4
     *
     * Treść:
     * - Wczytaj wszystkie obiekty z buildDirtyFilePath().
     * - Utwórz
     * - Odfiltruj wszystkie elementy, które spełniają warunki z isRestaurantAlright()
     * - Zapisz spełniające elementy do pliku dla Path z buildCorrectedFilePath()
     * - Zamknij wszystkie streamy
     *
     * Użyj:
     * - Stream
     * - BufferedWriter
     */
    @Override
    public void correctData() {

    }

    /**
     * Ćwiczenie 5
     *
     * Treść:
     * - Wykonaj transformację String'ów na obiekt typu RestaurantDto
     * - Posortuj wszystkie elementy wg. miasta od A-Z
     * - Zapisz całość do Listy
     *
     */
    @Override
    public List<RestaurantDto> mapToOrderedListOfRestaurants(Stream<String> stream) {
        return null;
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
