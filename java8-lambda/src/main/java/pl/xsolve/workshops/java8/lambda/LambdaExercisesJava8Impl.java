package pl.xsolve.workshops.java8.lambda;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LambdaExercisesJava8Impl implements LambdaExercises {

    @Override
    public void sortCollection(final List<Integer> toSort) {
        // TODO
    }

    @Override
    public Future<Integer> multiply(final Integer value, final Integer multiplier) {
        ExecutorService threadpool = Executors.newFixedThreadPool(1);
        return null; // TODO
    }

    @Override
    public List<Integer> mapToListOfLengths(final List<String> input) {
        return null; // TODO
    }
}
