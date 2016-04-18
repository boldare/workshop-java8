package pl.xsolve.workshops.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class LambdaExercisesTest {

//    protected LambdaExercises lambdaExercises = new LambdaExercisesOldJavaImpl();
//    protected LambdaExercises lambdaExercises = new LambdaExercisesJava8Impl();
    protected LambdaExercises lambdaExercises = new LambdaExercisesJava8SolutionsImpl();


    // @FunctionalInterface
    // ::
    // https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

    @Test
    public void shouldSortList() {
        List<Integer> actual = Arrays.asList(9, 2, 7, 64, 64, 3);
        List<Integer> expected = Arrays.asList(64, 64, 9, 7, 3, 2);

        lambdaExercises.sortCollection(actual);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultipyBy2InThread() throws ExecutionException, InterruptedException {
        Future<Integer> actual = lambdaExercises.multiply(9, 2);
        Integer expected = 18;

        assertEquals(expected, actual.get());
    }

    @Test
    public void shouldReturnListOfLengths() {
        List<String> input = Arrays.asList("Lorem", "ipsum", "dolor", "sit", "amet");
        List<Integer> expected = Arrays.asList(5, 5, 5, 3, 4);
        List<Integer> actual = lambdaExercises.mapToListOfLengths(input);

        assertEquals(expected, actual);

    }
}
