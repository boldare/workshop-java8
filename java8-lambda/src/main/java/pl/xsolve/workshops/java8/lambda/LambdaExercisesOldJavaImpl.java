package pl.xsolve.workshops.java8.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

public class LambdaExercisesOldJavaImpl implements LambdaExercises {

    @Override
    public void sortCollection(final List<Integer> toSort) {
        Collections.sort(toSort, new Comparator<Integer>() {
            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    @Override
    public Future<Integer> multiply(final Integer value, final Integer multiplier) {
        ExecutorService threadpool = Executors.newFixedThreadPool(1);

        return threadpool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return value * multiplier;
            }
        });
    }

    @Override
    public List<Integer> mapToListOfLengths(final List<String> input) {
        return mapList(input, new Function<String, Integer>() {
            @Override
            public Integer apply(final String s) {
                return s.length();
            }
        });
    }
}
