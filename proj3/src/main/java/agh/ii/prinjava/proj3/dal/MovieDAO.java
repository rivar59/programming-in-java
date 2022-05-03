package agh.ii.prinjava.proj3.dal;

import java.sql.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Movie Data Access Object
 *
 * @see <a href="https://www.oracle.com/java/technologies/dataaccessobject.html">Data Access Object</a>
 */
public class MovieDAO {
    private final String dbURL;

    public MovieDAO(String dbURL) {
        this.dbURL = dbURL;
    }

    /**
     * ex01 - the movies (only titles) directed (or co-directed) by a given director
     */
    public Optional<Set<String>> moviesDirectedBy(String directorName) {
        try (Connection con = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = con.prepareStatement(MovieSQLs.moviesOfDirectorSQL)) {
            stmt.setString(1, directorName);

            return Util.getSetWithOneData(stmt.executeQuery(), "title");
            /*
            Set<String> ret = new LinkedHashSet<>();
            while (actor.next())
                ret.add(directname.getString("title"));

            return Optional.of(ret);
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * ex02 - the movies (only titles) in which an actor played
     */
    public Optional<Set<String>> moviesTheActorPlayedIn(String actorName) {
        try (Connection con = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = con.prepareStatement(MovieSQLs.moviesOfActorSQL)) {
            stmt.setString(1, actorName);

            return Util.getSetWithOneData(stmt.executeQuery(), "title");
            /*
            Set<String> ret = new LinkedHashSet<>();
            while (actor.next())
                ret.add(actor.getString("title"));

            return Optional.of(ret);
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * ex03 - the number of movies per director (as a map)
     */
    public Optional<Map<String, Long>> numberOfMoviesPerDirector() {
        try (Connection con = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = con.prepareStatement(MovieSQLs.numberOfMoviesPerDirectorSQL)) {
            return Util.mapFromRequest(stmt.executeQuery(), "director", "numOfMovies");
            /*
            Map<String, Long> map = new HashMap<>();
            while (inforequet.next())
                map.put(inforequet.getString("director"),
                        inforequet.getLong("numOfMovies"));

            return Optional.of(map);
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * ex04 - the 10 directors with the most films on the list
     */
    public Optional<Map<String, Long>> numberOfMoviesPerTop10Director() {
        try (Connection con = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = con.prepareStatement(MovieSQLs.numOfMoviesPerTop10DirectorSQL)) {

            return Util.mapFromRequest(stmt.executeQuery(), "director", "numOfMovies");
            /*
            Map<String, Long> map = new HashMap<>();
            while (inforequet.next())
                map.put(inforequet.getString("director"),
                        inforequet.getLong("numOfMovies"));

            return Optional.of(map);
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * ex05 - the movies (only titles) made by each of the 10 directors
     */
    public Optional<Map<String, Set<String>>> moviesPerTop10Director() {
        try (Connection con = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = con.prepareStatement(MovieSQLs.moviesOfTop10DirectorsSQL)) {
            return Util.BuildListOfMoviesByPeople(stmt.executeQuery(), "director");
            /*
            Map<String, Set<String>> ret = new HashMap<>();
            while (inforequet.next()){
                Set<String> map_set = new HashSet();
                int NumberOfMovieByADirector = inforequet.getInt("numOfMovies");
                for (int i = 0;  i <  NumberOfMovieByADirector; i++){
                    map_set.add(inforequet.getString("title"));
                    if (i != NumberOfMovieByADirector - 1)
                        inforequet.next();
                }
                ret.put(inforequet.getString("director"), map_set);
            }

            return Optional.of(ret);

             */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * ex06 - the number of movies per actor (as a map)
     */
    public Optional<Map<String, Long>> numberOfMoviesPerActor() {
        try (Connection con = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = con.prepareStatement(MovieSQLs.numberOfMoviesPerActorSQL)) {
            return Util.mapFromRequest(stmt.executeQuery(), "actor", "numOfMovies");
            /*
            Map<String, Long> map = new HashMap<>();
            while (inforequet.next())
                map.put(inforequet.getString("actor"), inforequet.getLong("numOfMovies"));

            return Optional.of(map);
             */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * ex07 - the 9 actors with the most films on the list
     */
    public Optional<Map<String, Long>> numberOfMoviesPerTop9Actor() {
        try (Connection con = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = con.prepareStatement(MovieSQLs.numOfMoviesPerTop9ActorSQL)) {
            return Util.mapFromRequest(stmt.executeQuery(), "actor", "numOfMovies");
            /*
            Map<String, Long> map = new HashMap<>();
            while (inforequet.next())
                map.put(inforequet.getString("actor"), inforequet.getLong("numOfMovies"));

            return Optional.of(map);
             */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * ex08 - the movies (only titles) of each of the 9 actors
     */
    public Optional<Map<String, Set<String>>> moviesPerTop9Actor() {

        try (Connection con = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = con.prepareStatement(MovieSQLs.moviesOfTop9ActorSQL)) {
            return Util.BuildListOfMoviesByPeople(stmt.executeQuery(), "actor");

            /*
            Map<String, Set<String>> ret = new HashMap<>();
            while (inforequet.next()){
                Set<String> map_set = new HashSet();
                int NumberOfMovieByActor = inforequet.getInt("numOfMovies");
                for (int i = 0;  i <  NumberOfMovieByActor; i++){
                    map_set.add(inforequet.getString("title"));
                    if (i != NumberOfMovieByActor - 1)
                        inforequet.next();
                }
                ret.put(inforequet.getString("actor"), map_set);
            }

            return Optional.of(ret);

             */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * ex09 - the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    public Optional<Map<String, Long>> top5FrequentActorPartnerships() {
        try (Connection con = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = con.prepareStatement(MovieSQLs.top5ActorPartnershipsSQL)) {
            ResultSet inforequet = stmt.executeQuery();
            Map<String, Long> map = new HashMap<>();
            while (inforequet.next())
                map.put(inforequet.getString("actor1")  + ", " + inforequet.getString("actor2"), inforequet.getLong("cnt"));

            return Optional.of(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * ex10 - the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    public Optional<Map<String, Set<String>>> moviesPerTop5ActorPartnerships() {
        try (Connection con = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = con.prepareStatement(MovieSQLs.moviesOfTop5ActorPartnershipsSQL)) {
            ResultSet inforequet = stmt.executeQuery();
            Map<String, Set<String>> ret = new HashMap<>();
            while (inforequet.next()){
                Set<String> setFromPartership = new HashSet();
                int numberOfMovieByDuoActor = inforequet.getInt("cnt");
                for (int i = 0;  i <  numberOfMovieByDuoActor; i++){
                    setFromPartership.add(inforequet.getString("title"));
                    if (i != numberOfMovieByDuoActor - 1)
                        inforequet.next();
                }
                setFromPartership.add(inforequet.getString("title"));
                ret.put((inforequet.getString("actor1")  + ", " + inforequet.getString("actor2")), setFromPartership);
            }

            return Optional.of(ret);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

/**
 * Avoid the redondance of the code
 * By making some interface usefull
 */
interface Util{

    public static Optional<Set<String>> getSetWithOneData(ResultSet directname, String str) throws SQLException{
        Set<String> ret = new LinkedHashSet<>();
        while (directname.next())
            ret.add(directname.getString(str));

        return Optional.of(ret);
    }

    public static Optional<Map<String,Long>> mapFromRequest(ResultSet inforequet, String str1, String str2)
            throws SQLException{
        Map<String, Long> map = new HashMap<>();
        while (inforequet.next())
            map.put(inforequet.getString(str1),
                    inforequet.getLong(str2));

        return Optional.of(map);
    }

    public static Optional<Map<String, Set<String>>> BuildListOfMoviesByPeople
            (ResultSet inforequet, String name) throws SQLException{
        Map<String, Set<String>> ret = new HashMap<>();
        while (inforequet.next()){
            Set<String> map_set = new HashSet();
            int NumberOfMovie = inforequet.getInt("numOfMovies");
            for (int i = 0;  i <  NumberOfMovie; i++){
                map_set.add(inforequet.getString("title"));
                if (i != NumberOfMovie - 1)
                    inforequet.next();
            }
            ret.put(inforequet.getString(name), map_set);
        }

        return Optional.of(ret);
    }



    public static <T> Optional<T> executeQueryAndGetResult(String dbURL, String query, Consumer<PreparedStatement> setParamsFunction, Function<ResultSet, Optional<T>> getResultFromSetFunction) {
    try (Connection con = DriverManager.getConnection(dbURL)) {
        // prepare statements with generic params
        PreparedStatement stmt = con.prepareStatement(query);
        setParamsFunction.accept(stmt);

        // execute query
        ResultSet set = stmt.executeQuery();

        // build result from result set
        Optional<T> result = getResultFromSetFunction.apply(set);
        return result;
    } catch (SQLException e) {
        e.printStackTrace();
        return Optional.empty();
    }
}/*
    Exo 3
        return Util.executeQueryAndGetResult(dbURL, MovieSQLs.moviesOfTop9ActorSQL,
                    set -> Util.GetSetWithOneData(inforequet, "title"));
     */
}

class MovieSQLs {
    // ex01
    static final String moviesOfDirectorSQL = """
            SELECT m.title AS title
            FROM movies m, movie_directors md, directors d
            WHERE m.id = md.movie_id AND md.director_id = d.id AND d.name = ?
            """;

    // ex02
    static final String moviesOfActorSQL = """
            SELECT m.title AS title
            FROM movies m, movie_actors ma, actors a
            WHERE m.id = ma.movie_id AND ma.actor_id = a.id AND a.name = ?
            """;

    // ex03
    static final String numberOfMoviesPerDirectorSQL = """
            SELECT d.name AS director, count (*) AS numOfMovies
            FROM directors d, movie_directors md
            WHERE d.id = md.director_id
            GROUP BY d.name
            """;

    // ex04
    static final String numOfMoviesPerTop10DirectorSQL = """
            SELECT d.name AS director, count (*) AS numOfMovies
            FROM directors d, movie_directors md
            WHERE d.id = md.director_id
            GROUP BY d.name
            ORDER BY numOfMovies DESC
            LIMIT 10
            """;

    // ex05
    static final String moviesOfTop10DirectorsSQL = """
            SELECT d.name AS director, m.title AS title,
              (SELECT count(*) FROM movie_directors WHERE director_id = d.id GROUP BY director_id) AS numOfMovies
            FROM directors d, movie_directors md, movies m
            WHERE d.id = md.director_id
            AND md.movie_id = m.id
            AND d.id IN (SELECT d.id
                         FROM directors d, movie_directors md
                         WHERE d.id = md.director_id
                         GROUP BY d.id
                         ORDER BY count (*) DESC
                         LIMIT 10)
            ORDER BY numOfMovies DESC, d.name
            """;

    // ex06
    static final String numberOfMoviesPerActorSQL = """
            SELECT a.name AS actor, count (*) AS numOfMovies
            FROM actors a, movie_actors ma
            WHERE a.id = ma.actor_id
            GROUP BY a.name
            """;

    // ex07
    static final String numOfMoviesPerTop9ActorSQL = """
            SELECT a.name AS actor, count (*) AS numOfMovies
            FROM actors a, movie_actors ma
            WHERE a.id = ma.actor_id
            GROUP BY a.name
            ORDER BY numOfMovies DESC
            LIMIT 9
            """;

    // ex08
    static final String moviesOfTop9ActorSQL = """
            SELECT a.name AS actor, m.title AS title,
              (SELECT count(*) FROM movie_actors WHERE actor_id = a.id GROUP BY actor_id) AS numOfMovies
            FROM actors a, movie_actors ma, movies m
            WHERE a.id = ma.actor_id
            AND ma.movie_id = m.id
            AND a.id IN (SELECT a.id
                         FROM actors a, movie_actors ma
                         WHERE a.id = ma.actor_id
                         GROUP BY a.id
                         ORDER BY count (*) DESC
                         LIMIT 9)
            ORDER BY numOfMovies DESC, a.name
            """;

    // ex09
    static final String top5ActorPartnershipsSQL = """
            SELECT t1.name AS actor1, t2.name AS actor2, count(*) cnt
            FROM (SELECT a.id, a.name, ma.movie_id
                  FROM actors a, movie_actors ma
                  WHERE a.id = ma.actor_id) t1
            JOIN (SELECT a.id, a.name, ma.movie_id
                  FROM actors a, movie_actors ma
                  WHERE a.id = ma.actor_id) t2
            ON t1.id < t2.id AND t1.movie_id = t2.movie_id
            GROUP BY 1,2
            ORDER BY cnt DESC
            LIMIT 5
            """;

    // ex10
    static final String moviesOfTop5ActorPartnershipsSQL = """
            SELECT actor1, actor2, cnt, title
            FROM (SELECT t1.id AS a1_id, t1.name AS actor1, t2.id AS a2_id, t2.name as actor2, count(*) cnt
                  FROM (SELECT a.id, a.name, ma.movie_id
                        FROM actors a, movie_actors ma
                        WHERE a.id = ma.actor_id) t1
                  JOIN (SELECT a.id, a.name, ma.movie_id
                        FROM actors a, movie_actors ma
                        WHERE a.id = ma.actor_id) t2
                  ON t1.id < t2.id AND t1.movie_id = t2.movie_id
                  GROUP BY a1_id, a2_id
                  ORDER BY cnt DESC
                  LIMIT 5)
            JOIN (SELECT t3.title, t3.actor_id AS a3_id, t4.actor_id AS a4_id
                  FROM (SELECT m.title, m.id, ma.actor_id
                        FROM movies m, movie_actors ma
                        WHERE m.id = ma.movie_id) t3
                  JOIN (SELECT m.title, m.id, ma.actor_id
                        FROM movies m, movie_actors ma
                        WHERE m.id = ma.movie_id) t4
                  ON t3.actor_id < t4.actor_id AND t3.title = t4.title)
            ON (a1_id = a3_id AND a2_id = a4_id) OR (a1_id = a4_id AND a2_id = a3_id)
            ORDER BY cnt DESC, actor1, actor2
            """;
}

