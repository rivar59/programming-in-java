package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;
import agh.ii.prinjava.proj2.utils.Utils;

/*
add by me
 */
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {
        Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies
                .orElseThrow()
                .stream()
                .filter(m -> m.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }


    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {
        Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies
                .orElseThrow()
                .stream()
                .filter(m -> m.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }


    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        Optional<List<Movie>> movies = ImdbTop250.movies();
        /*return movies
                .orElseThrow()
                .stream()
                .flatMap(m -> m.directors().stream())
                .distinct()//get all directors on time
                .collect(Collectors.toMap(d -> (String) d, d -> (long) ex01_aux(d).size()));*/
        return movies
                .orElseThrow()
                .stream()
                .flatMap(m -> m.directors().stream())
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

    }


    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {
        return ex03()
                .entrySet()
                .stream()
                .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))// Allow reverse order
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        return ex04()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, b -> ex01(b.getKey())));
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies
                .orElseThrow()
                .stream()
                .flatMap(m -> m.actors().stream())
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
    }


    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {
        return ex06()
                .entrySet()
                .stream()
                .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))// Allow reverse order
                .limit(9)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {
        return ex07()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, b -> ex02(b.getKey())));
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies
                .orElseThrow()
                .stream()
                .flatMap(m -> Utils.orderedPairsFrom(m.actors()).stream())
                .collect(Collectors.groupingBy(d -> d, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))// Allow reverse order
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }



    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {//Not good
        return ex09()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, b -> ex10_aux(b.getKey())));
    }

    static Set<String> ex10_aux(String director) {//Got actor partenship like "Carrie Fisher,  "
        Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies
                .orElseThrow()
                .stream()
                .filter(m -> m.actors().contains(director.split(", ")[0]) &&
                             m.actors().contains(director.split(", ")[1]))
                .map(Movie::title)
                .collect(Collectors.toSet());

    }


}

