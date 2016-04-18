package pl.xsolve.workshops.java8.lambda;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LambdaExercisesJava8Impl extends AbstractLambdaExercises {

    /**
     * Ćwiczenie 1
     *
     * Treść:
     * Posortuj rosnąco listę obiektów typu Integer.
     *
     * Założenia:
     * - nie używaj jednoargumentowej metody Collection.sort(toSort)
     * - nie używaj null w metodzie list.sort(null)
     *
     * Użyj:
     * - dwuargumentowej metody Collection.sort(toSort, comparator) lub toSort.sort(comparator)
     * - przekazania referencji do metody (podpowiedź: chodzi o ::)
     *
     * Przykładowy input/output:
     * input: 17, 2, 29, 5, 11, 13, 31, 19, 23, 3, 7
     * output: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31
     */
    @Override
    public void sortAscending(final List<Integer> toSort) {
        // TODO
    }

    /**
     * Ćwiczenie 2
     *
     * Treść:
     * Posortuj malejąco listę obiektów typu Integer.
     *
     * Użyj:
     * - dwuargumentowej metody Collection.sort(toSort, comparator) lub list.sort(comparator)
     * - wyrażenia lambda
     *
     * Przykładowy input/output:
     * input: 47, 37, 59, 41, 53, 67, 43, 71, 61
     * output: 71, 67, 61, 59, 53, 47, 43, 41, 37
     */
    @Override
    public void sortDescending(final List<Integer> toSort) {
        // TODO
    }

    /**
     * Ćwiczenie 3
     *
     * Treść:
     * Posortuj listę napisów rosnąco (od najkrótszego do najdłuższego)
     *
     * Użyj:
     * - metody Collection.sort(toSort, comparator) lub toSort.sort(comparator)
     * - wyrażenia lambda
     *
     * Przykładowy input/output:
     * input: Java, Scala, R, GO, Clojure, Groovy, Haskell, Erlang, Lisp
     * output: R, GO, Java, Lisp, Scala, Groovy, Erlang, Clojure, Haskell
     */
    @Override
    public void sortStringsAscending(final List<String> toSort) {
        // TODO
    }

    /**
     * Ćwiczenie 4
     *
     * Treść:
     * Oblicz iloczyn argumentów w osobnym wątku.
     *
     * Użyj:
     * - wyrażenia lambda
     *
     * Przykładowy input/output:
     * input: 65536, 42
     * output: Future(w którym po wyliczeniu pojawi się 2752512)
     */
    @Override
    public Future<Integer> multiply(final Integer value, final Integer multiplier) {
        ExecutorService threadpool = Executors.newFixedThreadPool(1);
//        return threadpool.submit( /*TODO*/ );
        return null;
    }

    /**
     * Ćwiczenie 5
     *
     * Treść:
     * Metoda map zwraca przekształconą przy pomocy podanej funkcji listę. Przyjmuje 2 argumenty:
     *  1. listę obiektów
     *  2. funkcję/wyrażenie lambda przekształcające dany obiekt na inny obiekt
     * Przy użyciu metody map przekształć listę dowolnych napisów na listę napisów zgodny z zasadami:
     * - Jeżeli napis jest pusty zwróć: empty
     * - Jeżeli liczba znaków napisu jest podzielna przez 2 zwróć: even
     * - Jeżeli liczba znaków napisu NIE jest podzielna przez 2 zwróć: odd
     *
     * Użyj:
     * - wyrażenia lambda
     * - metody map(list, function)
     *
     * Przykładowy input/output:
     * input: Anna, Kamil, Grzegorz, , Dawid, Mateusz
     * output: even, odd, even, empty, odd, odd
     */
    @Override
    public List<String> evenOdd(final List<String> input) {
        // return map(input, /*TODO*/ );
        return null;
    }

    /**
     * Ćwiczenie 6
     *
     * Treść:
     * Zamień listę napisów na listę odpowiadającą długościom tych napisów
     *
     * Użyj:
     * - przekazania referencji do metody (podpowiedź: chodzi o ::)
     * - metody map(list, function)
     *
     * Przykładowy input/output:
     * input: Spring, Akka, JSF, Play, EJB
     * output: 6, 4, 3, 4, 3
     */
    @Override
    public List<Integer> mapToListOfLengths(final List<String> input) {
        return null; // TODO
    }

    /**
     * Ćwiczenie 7
     *
     * Treść:
     * Metoda filter zwraca nową listę z obiektami, które spełniają podane wymagania. Przyjmuje dwa argumenty:
     * 1. lista obiektów do przefiltrowania
     * 2. lista warunków do spełniania (predicate varargs)
     * Zwróć przefiltrowaną listę, na której znajdą się jedynie elementy spełniające następujące warunki:
     * - napisy zawierające literę i
     * - napisy krótsze niż 3 znaki
     * - napisy niepuste
     *
     * Użyj:
     * - wyrażenia lambda
     * - metody filter(list, predicate....)
     *
     * Przykładowy input/output:
     * input: grep, awk, vi, , vim, nano, emacs, tar, bash, cat, tail, head, dd
     * output: vi
     */
    @Override
    public List<String> applyPredicates(final List<String> input) {
        //return filter(input, /*TODO*/ );
        return null;
    }

    /**
     * Ćwiczenie 8
     *
     * Treść:
     * Napisz brakującą metodę transform, która przekształca napisy z listy używając podanej funkcji
     * Przyjmuje:
     * 1. listę napisów do przekształcenia
     * 2. wyrażenie lambda przekształcające napis na inny napis (funkcja przyjmująca String oraz zwracająca String)
     * Zwraca:
     * Listę zawierającą przekształcone napisy
     *
     * Użyj:
     * - UnaryOperator z java.util.function lub napisz swój własny interface
     *
     * Przykładowy input/output:
     * input: C, C++, Java, Scala, Python, Ruby, PHP, JavaScript
     * output: C!, C++!, JAVA!, SCALA!, PYTHON!, RUBY!, PHP!, JAVASCRIPT!
     */
    @Override
    public List<String> transformList(final List<String> input) {
//        return transform(input, s -> s.toUpperCase() + "!");  // nie modyfikować poza odkomentowaniem
        return null;
    }
}
