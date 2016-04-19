package pl.xsolve.workshops.java8.stream.part2LazyEvaluation;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RestaurantAnalizerOldJavaImpl extends RestaurantAnalizer {

    public boolean isAllEntriesFreeWifi(String fileName) throws URISyntaxException, IOException {
        BufferedReader reader =
                Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(fileName).toURI()),
                        Charset.defaultCharset() );

        String line = null;


        boolean headerLine = true;

        while ( (line = reader.readLine()) != null ) {
            if (headerLine){
                headerLine = false;
                continue;
            }

            Restaurant restaurant = lineToRestaurant(line);
            if (restaurant != null) {
                if (!restaurant.getFreeWiFi()) {
                    return false;
                }
            }
        }

        return true;
    }


}
