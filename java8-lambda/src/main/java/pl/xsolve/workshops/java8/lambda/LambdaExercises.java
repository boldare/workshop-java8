package pl.xsolve.workshops.java8.lambda;

import java.util.List;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface LambdaExercises {
    void sortCollection(List<Integer> toSort);
    Future<Integer> multiply(final Integer value, final Integer multiplier);

    default <T> List<T> mapList(List<String> input, Function<String, T> function) {
        return input.stream().map(function).collect(Collectors.toList());
    }

    List<Integer> mapToListOfLengths(List<String> input);
}
