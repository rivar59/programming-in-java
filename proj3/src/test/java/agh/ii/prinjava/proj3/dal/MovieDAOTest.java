package agh.ii.prinjava.proj3.dal;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MovieDAOTest {

    private static final String dbURL = "jdbc:sqlite:datasources/imdb_top250.db";
    MovieDAO movieDAO = new MovieDAO(dbURL);

    /**
     *Exo 1
     */
    @Test
    void moviesDirectedBy() {
        assertThat(movieDAO.moviesDirectedBy("Christopher Nolan").orElseThrow())
                .containsExactlyInAnyOrder("The Dark Knight", "Inception", "Interstellar",
                        "The Prestige", "Memento", "The Dark Knight Rises", "Batman Begins");

        assertThat(movieDAO.moviesDirectedBy("Guy Ritchie").orElseThrow())
                .containsExactlyInAnyOrder("Snatch", "Lock, Stock and Two Smoking Barrels");

        assertThat(movieDAO.moviesDirectedBy("Quentin Tarantino").orElseThrow())
                .containsExactlyInAnyOrder("Pulp Fiction", "Django Unchained", "Reservoir Dogs",
                        "Inglourious Basterds", "Kill Bill: Vol. 1", "Sin City");
    }

    /**
     *Exo 2
     */
    @Test
    void moviesTheActorPlayedIn() {
        assertThat(movieDAO.moviesTheActorPlayedIn("Al Pacino").orElseThrow())
                .containsExactlyInAnyOrder("The Godfather", "The Godfather: Part II", "Scarface",
                        "Heat");

        assertThat(movieDAO.moviesTheActorPlayedIn("Cary Grant").orElseThrow())
                .containsExactlyInAnyOrder("North by Northwest", "Arsenic and Old Lace", "Notorious",
                        "The Philadelphia Story", "His Girl Friday");

        assertThat(movieDAO.moviesTheActorPlayedIn("Tom Hanks").orElseThrow())
                .containsExactlyInAnyOrder("Forrest Gump", "Saving Private Ryan", "The Green Mile",
                        "Toy Story 3", "Toy Story", "Catch Me If You Can");

    }

    /**
     *Exo 3
     */
    @Test
    void numberOfMoviesPerDirector() {
        Optional<Map<String, Long>> numOfMoviesPerDirector = movieDAO.numberOfMoviesPerDirector();
        assertThat(numOfMoviesPerDirector.orElseThrow().size()).isEqualTo(167);
        assertThat(numOfMoviesPerDirector.orElseThrow()).containsAllEntriesOf(Map.of(
                "Bob Clark", 1L,
                "Otto Preminger", 2L,
                "Peter Jackson", 3L,
                "Jim Sheridan",1L,
                "Milos Forman", 2L,
                "Alan Parker", 1L));
    }

    /**
     *Exo 4
     */
    @Test
    void numberOfMoviesPerTop10Director() {
        assertThat(movieDAO.numberOfMoviesPerTop10Director().orElseThrow()).containsAllEntriesOf(Map.of(
                "Christopher Nolan", 7L,
                "Alfred Hitchcock", 9L,
                "Frank Capra", 4L,
                "Charles Chaplin", 5L,
                "Ridley Scott", 4L,
                "Martin Scorsese", 7L,
                "Steven Spielberg", 7L,
                "Quentin Tarantino", 6L,
                "Stanley Kubrick", 8L,
                "Billy Wilder", 7L
        ));
    }

    /**
     *Exo 5
     * Better solution
     */
    @Test
    void moviesPerTop10Director() {
        final Map<String, Set<String>> moviesPerDirector = movieDAO.moviesPerTop10Director().orElseThrow();

        assertThat(moviesPerDirector.keySet()).containsExactlyInAnyOrder(
                "Alfred Hitchcock", "Stanley Kubrick", "Martin Scorsese", "Steven Spielberg",
                "Christopher Nolan", "Billy Wilder", "Quentin Tarantino", "Charles Chaplin",
                "Ridley Scott", "Frank Capra");

        assertThat(moviesPerDirector.get("Christopher Nolan")).containsExactlyInAnyOrder(
                "The Dark Knight", "Inception", "Interstellar", "The Prestige", "Memento",
                "The Dark Knight Rises", "Batman Begins"
        );

        assertThat(moviesPerDirector.get("Billy Wilder")).containsExactlyInAnyOrder(
                "Some Like It Hot", "Stalag 17", "The Apartment", "Sunset Boulevard",
                "Witness for the Prosecution", "Double Indemnity", "The Lost Weekend"
        );
    }

    /**
     *Exo 6
     */
    @Test
    void numberOfMoviesPerActor() {
        Optional<Map<String, Long>> numberOfmoviesPerActor = movieDAO.numberOfMoviesPerActor();

        assertThat(numberOfmoviesPerActor.orElseThrow().size()).isEqualTo(773);
        assertThat(numberOfmoviesPerActor.orElseThrow()).containsAllEntriesOf(Map.of(
                "Christopher Carley", 1L,
                "Paul Newman", 5L,
                "Ethan Hawke", 3L));
    }


    /**
     *Exo 7
     */
    @Test
    void numberOfMoviesPerTop9Actor() {
        Optional<Map<String, Long>> tenMostFreqActors = movieDAO.numberOfMoviesPerTop9Actor();
        assertThat(tenMostFreqActors.orElseThrow()).containsAllEntriesOf(Map.of(
                "Leonardo DiCaprio", 8L,
                "Robert De Niro", 7L,
                "Harrison Ford", 7L,
                "Tom Hanks", 6L,
                "Cary Grant", 5L,
                "Paul Newman", 5L,
                "Tom Hardy", 5L,
                "James Stewart", 7L,
                "William Holden", 5L
                ));
    }

    /**
     *Exo 8
     */
    @Test
    void moviesPerTop9Actor() {
        Optional<Map<String, Set<String>>> top9Actor = movieDAO.moviesPerTop9Actor();

        assertThat(top9Actor.orElseThrow().keySet()).containsExactlyInAnyOrder(
                "Leonardo DiCaprio",
                "Robert De Niro",
                "Harrison Ford",
                "Tom Hanks",
                "Cary Grant",
                "Paul Newman",
                "Tom Hardy",
                "James Stewart",
                "William Holden"
        );

        assertThat(top9Actor.orElseThrow().get("Leonardo DiCaprio")).containsExactlyInAnyOrder(
                "Django Unchained", "The Wolf of Wall Street", "Blood Diamond", "The Departed",
                "Shutter Island", "Inception", "Catch Me If You Can", "The Revenant"
        );

        assertThat(top9Actor.orElseThrow().get("Harrison Ford")).containsExactlyInAnyOrder(
                "Star Wars: Episode VI - Return of the Jedi", "Indiana Jones and the Last Crusade",
                "Star Wars: Episode IV - A New Hope", "Star Wars: Episode V - The Empire Strikes Back",
                "Raiders of the Lost Ark", "Blade Runner", "Star Wars: The Force Awakens"
        );
    }

    /**
     *Exo9
     */
    @Test
    void top5FrequentActorPartnerships() {
        Optional<Map<String, Long>> fiveMostFreqActorDuos = movieDAO.top5FrequentActorPartnerships();

        assertThat(fiveMostFreqActorDuos.orElse(Collections.emptyMap())).containsAllEntriesOf(Map.of(
                "Carrie Fisher, Harrison Ford", 4L,
                "Harrison Ford, Mark Hamill", 4L,
                "Christian Bale, Michael Caine", 3L,
                "Carrie Fisher, Mark Hamill", 4L,
                "Joe Pesci, Robert De Niro", 4L
                ));
    }

    /**
     *Exo 10
     */
    @Test
    void moviesPerTop5ActorPartnerships() {
        Optional<Map<String, Set<String>>> top9Actor = movieDAO.moviesPerTop5ActorPartnerships();

        assertThat(top9Actor.orElseThrow().keySet()).containsExactlyInAnyOrder(
                "Carrie Fisher, Harrison Ford",
                "Harrison Ford, Mark Hamill",
                "Christian Bale, Michael Caine",
                "Carrie Fisher, Mark Hamill",
                "Joe Pesci, Robert De Niro"
        );

        assertThat(top9Actor.orElseThrow().get("Carrie Fisher, Harrison Ford")).containsExactlyInAnyOrder(
                "Star Wars: Episode VI - Return of the Jedi", "Star Wars: Episode IV - A New Hope",
                "Star Wars: Episode V - The Empire Strikes Back", "Star Wars: The Force Awakens"
        );

        assertThat(top9Actor.orElseThrow().get("Christian Bale, Michael Caine")).containsExactlyInAnyOrder(
                "The Prestige", "The Dark Knight", "Batman Begins"
        );
    }
}