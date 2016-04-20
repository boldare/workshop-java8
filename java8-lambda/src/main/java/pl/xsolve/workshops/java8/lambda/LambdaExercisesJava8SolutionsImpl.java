package pl.xsolve.workshops.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.UnaryOperator;

public class LambdaExercisesJava8SolutionsImpl extends AbstractLambdaExercises {

    @Override
    public void sortAscending(final List<Integer> toSort) {
        toSort.sort(Integer::compareTo);
    }

    @Override
    public void sortDescending(final List<Integer> toSort) {
        toSort.sort((o1, o2) -> o2.compareTo(o1));
    }

    @Override
    public void sortStringsAscending(final List<String> toSort) {
        toSort.sort((o1, o2) -> o1.length() - o2.length());
    }

    @Override
    public Future<Integer> multiply(final Integer value, final Integer multiplier) {
        ExecutorService threadpool = Executors.newFixedThreadPool(1);
        return threadpool.submit(() -> value * multiplier);
    }

    @Override
    public List<String> evenOdd(final List<String> input) {
        return map(input, s -> {
            if (0 == s.length()) {
                return "empty";
            } else if (0 == (s.length() % 2)) {
                return "even";
            } else {
                return "odd";
            }
        });
    }

    @Override
    public List<Integer> mapToListOfLengths(final List<String> input) {
        return map(input, String::length);
    }

    @Override
    public List<String> applyPredicates(final List<String> input) {
        return filter(input,
                s -> s.contains("i"),
                s -> s.length() < 3,
                s -> !s.isEmpty());
    }

    @Override
    public List<String> transformList(final List<String> input) {
        return transform(input, s -> s.toUpperCase() + "!");
    }

    protected <T> List<T> transform(final List<T> expected, final UnaryOperator<T> transofrmation) {
        List<T> result = new ArrayList<>();
        for (T s : expected) {
            result.add(transofrmation.apply(s));
        }

        return result;
    }
}
