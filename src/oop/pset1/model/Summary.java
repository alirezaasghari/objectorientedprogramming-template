package oop.pset1.model;

import java.util.List;

public class Summary {

    private List<String> topRatedMovies;

    private List<String> topAppearingMovieGenres;

    private List<String> topHiredActors;

    private List<String> actorsGenderRatio;

    public List<String> getTopRatedMovies() {
        return topRatedMovies;
    }

    public void setTopRatedMovies(List<String> topRatedMovies) {
        this.topRatedMovies = topRatedMovies;
    }

    public List<String> getTopAppearingMovieGenres() {
        return topAppearingMovieGenres;
    }

    public void setTopAppearingMovieGenres(List<String> topAppearingMovieGenres) {
        this.topAppearingMovieGenres = topAppearingMovieGenres;
    }

    public List<String> getTopHiredActors() {
        return topHiredActors;
    }

    public void setTopHiredActors(List<String> topHiredActors) {
        this.topHiredActors = topHiredActors;
    }

    public List<String> getActorsGenderRatio() {
        return actorsGenderRatio;
    }

    public void setActorsGenderRatio(List<String> actorsGenderRatio) {
        this.actorsGenderRatio = actorsGenderRatio;
    }

}
