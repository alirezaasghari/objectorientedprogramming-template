package oop.pset1.view;

public class SummaryDisplayer {

    public void display(Summary summary) {

        // Display 5 Most rated films
        System.out.println("Most rated films:");
        summary.getTopRatedMovies()
                .forEach(System.out::println);

        System.out.println(" ------ ");

        // Display 5 Most hired actors:
        System.out.println("Most hired actors:");
        summary.getTopHiredActors()
                .forEach(System.out::println);

        System.out.println(" ------ ");

        // Display the most appearing movie genres
        System.out.println("Most appearing movie genres:");
        summary.getTopAppearingMovieGenres()
                .forEach(System.out::println);

        System.out.println(" ------ ");

        // Display Actors male-female ratio
        System.out.println("Actors male-female ratio:");
        summary.getActorsGenderRatio()
                .forEach(System.out::println);

    }

    public void display() {
        System.out.println("Empty");
    }
}
