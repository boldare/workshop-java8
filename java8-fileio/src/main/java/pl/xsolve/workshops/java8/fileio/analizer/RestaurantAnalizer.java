package pl.xsolve.workshops.java8.fileio.analizer;

import pl.xsolve.workshops.java8.fileio.GenericLesson;
import pl.xsolve.workshops.java8.fileio.dto.McDonalds;

public abstract class RestaurantAnalizer extends GenericLesson {

    protected static final int VALID_COLUMN_COUNT = 13;
    protected static final String SEPARATOR = ",";
    protected static final int COLUMN_WIFI = 10;
    protected static final int COLUMN_DRIVE_THROUGH = 8;
    protected static final int COLUMN_PLAY_PLACE = 7;
    protected static final int COLUMN_STATE = 4;
    protected static final int COLUMN_CITY = 3;
    protected static final int COLUMN_ADDRESS = 2;
    protected static final int COLUMN_STORE_TYPE = 1;
    protected static final int COLUMN_STORE_NUMBER = 0;
    protected static final int NUMBER_OF_HEADER_LINES = 1;

    protected int processedLinesCounter = 0;

    public int getProcessedLinesCounter() {
        return processedLinesCounter;
    }

    public abstract boolean isAllEntriesFreeWifi(String fileName);

    protected McDonalds lineToRestaurant(String line) {
        if (line != null && !line.isEmpty()) {
            processedLinesCounter++;
            String[] columns = line.split(SEPARATOR);
            if (columns.length == VALID_COLUMN_COUNT) {
                return new McDonalds.Builder()
                        .setStoreNumber(Integer.parseInt(columns[COLUMN_STORE_NUMBER]))
                        .setStoreType(columns[COLUMN_STORE_TYPE])
                        .setAddress(columns[COLUMN_ADDRESS])
                        .setCity(columns[COLUMN_CITY])
                        .setState(columns[COLUMN_STATE])
                        .setPlayPlace("Y".equals(columns[COLUMN_PLAY_PLACE]))
                        .setDriveThrough("Y".equals(columns[COLUMN_DRIVE_THROUGH]))
                        .setFreeWiFi("Y".equals(columns[COLUMN_WIFI]))
                        .build();
            } else return null;
        } else return null;
    }
}
