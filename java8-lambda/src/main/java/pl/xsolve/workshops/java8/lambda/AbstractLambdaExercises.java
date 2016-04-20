package pl.xsolve.workshops.java8.lambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractLambdaExercises implements LambdaExercises {

    @SafeVarargs
    protected static <T> List<T> filter(List<T> input, Predicate<T>... predicates) {
        Predicate<T> predicate = Stream.of(predicates).reduce(p -> true, Predicate::and);
        return input.stream().filter(predicate).collect(Collectors.toList());
    }
}
