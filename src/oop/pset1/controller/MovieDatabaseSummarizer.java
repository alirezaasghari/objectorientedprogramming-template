package oop.pset1.controller;

import oop.pset1.model.Actor;
import oop.pset1.model.Movie;
import oop.pset1.parser.ActorParser;
import oop.pset1.parser.MovieParser;
import oop.pset1.parser.Summary;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieDatabaseSummarizer {

    public Optional<Summary> summarize() {
        List<Movie> movies = new MovieParser().getMovies();

        // The 5 most rated Movies
        List<String> topRatedMovies = movies.stream()
                .sorted((e1, e2) -> e2.getRating().compareTo(e1.getRating()))
                .limit(5)
                .map(e -> e.getTitle() + " (" + e.getRating() + ")")
                .collect(Collectors.toList());

        // 2 Movie genres that were appeared the most
        Map<String, Long> appearances = movies.stream()
                .map(Movie::getGenres)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<String> topAppearingMovieGenres = appearances.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(2)
                .map(e -> e.getKey() + " (" + e.getValue() + ")")
                .collect(Collectors.toList());

        // The 5 most hired Actors
        List<Actor> actors = new ActorParser().getActors();

        Map<String, Long> hired = actors.stream()
                .map(Actor::getName)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<String> topHiredActors = hired.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .map(e -> e.getKey() + " (" + e.getValue() + ")")
                .collect(Collectors.toList());

        // Actors male-female ratio
        Map<String, Long> gender = actors.stream()
                .map(Actor::getGender)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<String> actorsGenderRatio = gender.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(e -> e.getKey() + " (" + ((double) e.getValue()) / actors.size() * 100 + "%)")
                .collect(Collectors.toList());

        Summary summary = new Summary();
        summary.setTopRatedMovies(topRatedMovies);
        summary.setTopAppearingMovieGenres(topAppearingMovieGenres);
        summary.setTopHiredActors(topHiredActors);
        summary.setActorsGenderRatio(actorsGenderRatio);
        return Optional.of(summary);
    }
}
