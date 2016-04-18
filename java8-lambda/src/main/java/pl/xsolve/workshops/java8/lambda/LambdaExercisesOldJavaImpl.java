package pl.xsolve.workshops.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExercisesOldJavaImpl extends AbstractLambdaExercises {

    @Override
    public void sortAscending(final List<Integer> toSort) {
        Collections.sort(toSort, new Comparator<Integer>() {
            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    @Override
    public void sortDescending(final List<Integer> toSort) {
        Collections.sort(toSort, new Comparator<Integer>() {
            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    @Override
    public void sortStringsAscending(final List<String> toSort) {
        Collections.sort(toSort, new Comparator<String>() {
            @Override
            public int compare(final String s1, final String s2) {
                return s1.length() - s2.length();
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
    public List<String> evenOdd(final List<String> input) {
        return map(input, new Function<String, String>() {
            @Override
            public String apply(final String s) {
                if (0 == s.length()) {
                    return "empty";
                } else if (0 == (s.length() % 2)) {
                    return "even";
                } else {
                    return "odd";
                }
            }
        });
    }

    @Override
    public List<Integer> mapToListOfLengths(final List<String> input) {
        return map(input, new Function<String, Integer>() {
            @Override
            public Integer apply(final String s) {
                return s.length();
            }
        });
    }

    @Override
    public List<String> applyPredicates(final List<String> input) {
        return filter(input,
                new Predicate<String>() {
                    @Override
                    public boolean test(final String s) {
                        return s.contains("i");
                    }
                },
                new Predicate<String>() {
                    @Override
                    public boolean test(final String s) {
                        return s.length() < 3;
                    }
                },
                new Predicate<String>() {
                    @Override
                    public boolean test(final String s) {
                        return !s.isEmpty();
                    }
                }
        );
    }

    @Override
    public List<String> transformList(final List<String> input) {
        return transform(input, new MyOperation<String>() {
            @Override
            public String apply(final String s) {
                return s.toUpperCase() + "!";
            }
        });
    }

    protected interface MyOperation <T> {
        T apply(T s);
    }

    protected <T> List<T> transform(final List<T> expected, final MyOperation<T> foo) {
        List<T> result = new ArrayList<>();
        for (T s : expected) {
            result.add(foo.apply(s));
        }

        return result;
    }
}
