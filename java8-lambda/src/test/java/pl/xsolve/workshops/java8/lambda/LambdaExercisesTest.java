package pl.xsolve.workshops.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public abstract class LambdaExercisesTest {

    protected LambdaExercises lambdaExercises;

    protected LambdaExercisesTest(final LambdaExercises lambdaExercises) {
        this.lambdaExercises = lambdaExercises;
    }

    @Test
    public void shouldSortAscending() {
        List<Integer> actual = Arrays.asList(17, 2, 29, 5, 11, 13, 31, 19, 23, 3, 7);
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);

        lambdaExercises.sortAscending(actual);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortDescending() {
        List<Integer> actual = Arrays.asList(47, 37, 59, 41, 53, 67, 43, 71, 61);
        List<Integer> expected = Arrays.asList(71, 67, 61, 59, 53, 47, 43, 41, 37);

        lambdaExercises.sortDescending(actual);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortStringsAscending() {
        List<String> actual = Arrays.asList("Java", "Scala", "R", "GO", "Clojure", "Groovy", "Haskell", "Erlang", "Lisp");
        List<String> expected = Arrays.asList("R", "GO", "Java", "Lisp", "Scala", "Groovy", "Erlang", "Clojure", "Haskell");

        lambdaExercises.sortStringsAscending(actual);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultipyInThread() throws ExecutionException, InterruptedException {
        Future<Integer> actual = lambdaExercises.multiply(65536, 42);
        Integer expected = 2752512;

        assertEquals(expected, actual.get());
    }

    @Test
    public void shouldDefineEvenOdd() {
        List<String> input = Arrays.asList("Anna", "Kamil", "Grzegorz", "", "Dawid", "Mateusz");
        List<String> expected = Arrays.asList("even", "odd", "even", "empty", "odd", "odd");
        List<String> actual = lambdaExercises.evenOdd(input);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnListOfLengths() {
        List<String> input = Arrays.asList("Spring", "Akka", "JSF", "Play", "EJB");
        List<Integer> expected = Arrays.asList(6, 4, 3, 4, 3);
        List<Integer> actual = lambdaExercises.mapToListOfLengths(input);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldApplyConcretePredicated() {
        List<String> input = Arrays.asList("grep", "awk", "vi", "", "vim", "nano", "emacs", "tar", "bash", "cat", "tail", "head", "dd");
        List<String> expected = Collections.singletonList("vi");
        List<String> actual = lambdaExercises.applyPredicates(input);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTransformListOfStrings() {
        List<String> input = Arrays.asList("C", "C++", "Java", "Scala", "Python", "Ruby", "PHP", "JavaScript");
        List<String> expected = Arrays.asList("C!", "C++!", "JAVA!", "SCALA!", "PYTHON!", "RUBY!", "PHP!", "JAVASCRIPT!");
        List<String> actual = lambdaExercises.transformList(input);

        assertEquals(expected, actual);
    }
}
