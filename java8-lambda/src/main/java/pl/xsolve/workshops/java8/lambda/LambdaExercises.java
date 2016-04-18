package pl.xsolve.workshops.java8.lambda;

import java.util.List;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface LambdaExercises {

    void sortAscending(List<Integer> toSort);

    void sortDescending(List<Integer> toSort);

    void sortStringsAscending(List<String> toSort);

    Future<Integer> multiply(Integer value, Integer multiplier);

    List<String> evenOdd(List<String> input);

    List<Integer> mapToListOfLengths(List<String> input);

    List<String> applyPredicates(List<String> input);

    List<String> transformList(List<String> input);

    default <T, R> List<R> map(List<T> input, Function<T, R> function) {
        return input.stream().map(function).collect(Collectors.toList());
    }
}
