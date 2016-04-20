package pl.xsolve.workshops.java8.stream.part2LazyEvaluation;


import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * To właściwie może być zadanie do części 4. - FileIO + Streams + Lambdas
 */
public class LazyEvaluationTest {

    public static final String MC_DONALDS_FILE_NAME = "mcdonalds_03-09-15.csv";
    public static final int HALF_OF_FILE = 14000;

    @Test
    public void java8ShouldStopAfterFindingFistNonMatching() throws IOException, URISyntaxException {
        RestaurantAnalizer analizer = new RestaurantAnalizerJava8Impl();

        Assert.assertFalse(analizer.isAllEntriesFreeWifi(MC_DONALDS_FILE_NAME));
        Assert.assertTrue("was: " + analizer.getProcessedLinesCounter(), HALF_OF_FILE > analizer.getProcessedLinesCounter());
    }


    @Test
    public void oldJavaShouldStopAfterFindingFistNonMatching() throws IOException, URISyntaxException {
        RestaurantAnalizer analizer = new RestaurantAnalizerOldJavaImpl();

        Assert.assertFalse(analizer.isAllEntriesFreeWifi(MC_DONALDS_FILE_NAME));
        Assert.assertTrue("was: " + analizer.getProcessedLinesCounter(), HALF_OF_FILE > analizer.getProcessedLinesCounter());
    }
}
