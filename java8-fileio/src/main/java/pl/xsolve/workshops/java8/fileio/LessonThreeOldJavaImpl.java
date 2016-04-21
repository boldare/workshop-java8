package pl.xsolve.workshops.java8.fileio;

import pl.xsolve.workshops.java8.fileio.analizer.RestaurantAnalizer;
import pl.xsolve.workshops.java8.fileio.dto.McDonalds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LessonThreeOldJavaImpl extends RestaurantAnalizer {

    public boolean isAllEntriesFreeWifi(String fileName) {
        String path = ClassLoader.getSystemResource(fileName).getPath();

        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {

            boolean headerLine = true;
            String line;

            while ( (line = br.readLine()) != null ) {
                if (headerLine) {
                    headerLine = false;
                    continue;
                }

                McDonalds restaurant = lineToRestaurant(line);

                if (restaurant != null) {
                    if (!restaurant.getFreeWiFi()) {
                        return false;
                    }
                }
            }

            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
