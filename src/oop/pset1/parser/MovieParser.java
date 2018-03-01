package oop.pset1.parser;

import oop.pset1.model.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieParser {

    public List<Movie> getMovies() {

        String filePath = "src/oop/pset1/data/movies.csv";
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            return lines.skip(1)
                    .map(line -> line.split(";"))
                    .filter(word -> word.length == 24)
                    .map(toMovie())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private Function<String[], Movie> toMovie() {
        return columns -> {
            Movie movie = new Movie();
            movie.setTitle(columns[8]);
            movie.setRating(Double.parseDouble(columns[22]));
            movie.setGenres(toGenres(columns[3]));
            return movie;
        };
    }

    private List<String> toGenres(String column) {
        String objects = column.replaceAll("\\[", "").replaceAll("]", "");

        objects = objects.replaceAll("},", "};");
        objects = objects.replaceAll("\\{", "").replaceAll("}", "");
        objects = objects.replaceAll("'", "");
        String[] words = objects.split(";");

        return Stream.of(words)
                .map(word -> word.split(": "))
                .filter(word -> word.length > 1)
                .map(word -> word[2])
                .collect(Collectors.toList());
    }
}
