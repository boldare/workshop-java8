package pl.xsolve.workshops.java8.stream.part2LazyEvaluation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RestaurantAnalizerJava8Impl extends RestaurantAnalizer {

    public boolean isAllEntriesFreeWifi(String fileName) throws URISyntaxException, IOException {
        Path path = Paths.get(ClassLoader.getSystemResource(fileName).toURI());
        try ( Stream<String> stream = Files.lines(path).skip(NUMBER_OF_HEADER_LINES)) {

            return stream.map(line -> lineToRestaurant(line))
                .filter(it -> it != null)
                .allMatch(it -> it.getFreeWiFi());

        } catch (Exception e){
           throw e;
        }
    }

}
