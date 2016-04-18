package pl.xsolve.workshops.java8.lambda;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LambdaExercisesJava8SolutionsImpl implements LambdaExercises {

    @Override
    public void sortCollection(final List<Integer> toSort) {
        Collections.sort(toSort, (o1, o2) -> o2.compareTo(o1));
    }

    @Override
    public Future<Integer> multiply(final Integer value, final Integer multiplier) {
        ExecutorService threadpool = Executors.newFixedThreadPool(1);
        return threadpool.submit(() -> value * multiplier);
    }

    @Override
    public List<Integer> mapToListOfLengths(final List<String> input) {
        return mapList(input, String::length);
    }
}
