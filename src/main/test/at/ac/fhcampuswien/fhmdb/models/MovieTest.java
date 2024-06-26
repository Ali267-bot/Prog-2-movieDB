package at.ac.fhcampuswien.fhmdb.models;

import static org.junit.jupiter.api.Assertions.*;

import at.ac.fhcampuswien.fhmdb.models.Genres;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

class MovieTest {
    private List<Movie> getListofMovies() {
        List<Movie> expected = new ArrayList<>();

        expected.add(new Movie(
                "1",
                "Interstellar",
                "Set in a dystopian future where humanity is embroiled in a catastrophic blight " +
                        "and famine, the film follows a group of astronauts who travel through a wormhole " +
                        "near Saturn in search of a new home for humankind.",
                Arrays.asList(Genres.SCIENCE_FICTION, Genres.ACTION, Genres.ADVENTURE),
                "",
                1,
                0.0,
                new ArrayList<>(), new TreeSet<>()
        ));
        expected.add(new Movie(
                "2",
                "SpongeBob SquarePants",
                "After King Neptune's crown is stolen, SpongeBob and Patrick go on a quest in 6 " +
                        "days to retrieve his crown. On the way SpongeBob and Patrick defeat many evildoers " +
                        "using their brains and bronzes.",
                Arrays.asList(Genres.COMEDY, Genres.ACTION, Genres.ADVENTURE),
                "",
                1,
                0.0,
                new ArrayList<>(), new TreeSet<>()
        ));
        expected.add(new Movie(
                "3",
                "The Usual Suspects",
                "A sole survivor tells of the twisty events leading up to a horrific gun battle on" +
                        " a boat, which begin when five criminals meet at a seemingly random police lineup.",
                Arrays.asList(Genres.CRIME, Genres.DRAMA, Genres.MYSTERY),
                "",
                1,
                0.0,
                new ArrayList<>(), new TreeSet<>()
        ));
        expected.add(new Movie(
                "4",
                "The Wolf of Wall Street",
                "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker" +
                        " living the high life to his fall involving crime, corruption and the federal government.",
                Arrays.asList(Genres.DRAMA, Genres.ROMANCE, Genres.BIOGRAPHY),
                "",
                1,
                0.0,
                new ArrayList<>(), new TreeSet<>()
        ));
        expected.add(new Movie(
                "5",
                "Avatar",
                "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn " +
                        "between following his orders and protecting the world he feels is his home. äää",
                Arrays.asList(Genres.ANIMATION, Genres.DRAMA, Genres.ACTION),
                "",
                1,
                0.0,
                new ArrayList<>(), new TreeSet<>()
        ));
        expected.add(new Movie(
                "6",
                "One Piece film red",
                "The Straw Hat Pirates leave for the island of Elegia to attend a concert by Uta," +
                        " a world-famous singer. After Uta performs her first song (\"New Genesis\"), Luffy" +
                        " goes on stage to reunite with her, revealing that the two of them know each" +
                        " other because Uta is the adopted daughter of \"Red-Haired\" Shanks.",
                Arrays.asList(Genres.ADVENTURE, Genres.COMEDY, Genres.ACTION),
                "",
                1,
                0.0,
                new ArrayList<>(), new TreeSet<>()
        ));

        return expected;
    }

    @Test
    void initializeMovie_is_not_null() {
        //Given
        List<Movie> actual;

        //When
        actual = Movie.initializeMovies();

        //Then
        assertNotNull(actual);

    }

    @Test
    void initializeMovie_all_Movie_titles_stay_the_same_after_initialization() {
        //Given
        List<Movie> actual;


        //When
        actual = Movie.initializeMovies();
        List<Movie> expected = getListofMovies();

        //Then
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getTitle(), actual.get(i).getTitle());
        }
    }

    @Test
    void initializeMovie_all_Movie_descriptions_stay_the_same_after_initialization() {
        //Given
        List<Movie> actual;


        //When
        actual = Movie.initializeMovies();
        List<Movie> expected = getListofMovies();

        //Then
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getDescription(), actual.get(i).getDescription());
        }
    }

    @Test
    void initializeMovie_all_Movie_titleLowercaseNormalized_stay_the_same_after_initialization() {
        //Given
        List<Movie> actual;


        //When
        actual = Movie.initializeMovies();
        List<Movie> expected = getListofMovies();

        //Then
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getTitleLowercaseNormalized(), actual.get(i).getTitleLowercaseNormalized());
        }
    }

    @Test
    void initializeMovie_all_Movie_descriptionLowercaseNormalized_stay_the_same_after_initialization() {
        //Given
        List<Movie> actual;


        //When
        actual = Movie.initializeMovies();
        List<Movie> expected = getListofMovies();

        //Then
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getDescriptionLowercaseNormalized(), actual.get(i).getDescriptionLowercaseNormalized());
        }
    }

    @Test
    void initializeMovie_all_Movie_Genres_stay_the_same_after_initialization() {
        //Given
        List<Movie> actual;


        //When
        actual = Movie.initializeMovies();
        List<Movie> expected = getListofMovies();

        //Then
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getGenres(), actual.get(i).getGenres());
        }
    }

    @Test
    void normalizeString_The_Wolf_of_Wall_Street_to_the_wolf_of_wall_street() {
        //Given
        String actual = "The Wolf of Wall Street";

        //When
        actual = Movie.normalizeString(actual);

        //Then
        String expected = "the wolf of wall street";
        assertEquals(expected, actual);
    }

    @Test
    void normalizeString_AvAtAr_to_avatar() {
        //Given
        String actual = "AvAtAr";

        //When
        actual = Movie.normalizeString(actual);

        //Then
        String expected = "avatar";
        assertEquals(expected, actual);
    }
}