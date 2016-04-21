package pl.xsolve.workshops.java8.fileio;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pl.xsolve.workshops.java8.fileio.analizer.RestaurantAnalizer;

public class LessonThreeTest {

    public static final String MC_DONALDS_FILE_NAME = "mcdonalds.csv";
    public static final int HALF_OF_FILE = 14000;

    @Test
    @Ignore
    public void testJava8ShouldStopAfterFindingFistNonMatching() {
        RestaurantAnalizer analizer = new LessonThreeJava8Impl();

        Assert.assertFalse(analizer.isAllEntriesFreeWifi(MC_DONALDS_FILE_NAME));
        Assert.assertTrue(HALF_OF_FILE > analizer.getProcessedLinesCounter());
    }

    @Test
    public void testOldJavaShouldStopAfterFindingFistNonMatching() {
        RestaurantAnalizer analizer = new LessonThreeOldJavaImpl();

        Assert.assertFalse(analizer.isAllEntriesFreeWifi(MC_DONALDS_FILE_NAME));
        Assert.assertTrue(HALF_OF_FILE > analizer.getProcessedLinesCounter());
    }
}
