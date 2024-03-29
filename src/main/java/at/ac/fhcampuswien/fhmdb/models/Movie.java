package at.ac.fhcampuswien.fhmdb.models;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private String titleLowercaseNormalized;
    private String descriptionLowercaseNormalized;

    private final List<Genres> genres;

    public Movie(String title, String description, List<Genres> genres) {
        this.title = title;
        this.description = description;
        this.titleLowercaseNormalized = normalizeString(title);
        this.descriptionLowercaseNormalized = normalizeString(description);
        this.genres = genres;
    }

    public String getTitleLowercaseNormalized() {
        return titleLowercaseNormalized;
    }

    public String getDescriptionLowercaseNormalized() {
        return descriptionLowercaseNormalized;
    }


    /**
     * Normalizes text by removing diacritical marks and converting to lowercase. This enhances string comparison
     * by making it insensitive to case and accents.
     *
     * @param input The string to be normalized.
     * @return The normalized string, lowercase and without diacritical marks.
     */
    public static String normalizeString(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genres> getGenres() { return genres; }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(
                "Interstellar",
                " Set in a dystopian future where humanity is embroiled in a catastrophic blight " +
                        "and famine, the film follows a group of astronauts who travel through a wormhole " +
                        "near Saturn in search of a new home for humankind.",
                Arrays.asList(Genres.SCIENCE_FICTION, Genres.ACTION, Genres.ADVENTURE)
        ));
        movies.add(new Movie(
                "SpongeBob SquarePants",
                "After King Neptune's crown is stolen, SpongeBob and Patrick go on a quest in 6 " +
                        "days to retrieve his crown. On the way SpongeBob and Patrick defeat many evildoers " +
                        "using their brains and bronzes.",
                Arrays.asList(Genres.COMEDY, Genres.ACTION, Genres.ADVENTURE)
        ));
        movies.add(new Movie(
                "The Usual Suspects",
                "A sole survivor tells of the twisty events leading up to a horrific gun battle on" +
                        " a boat, which begin when five criminals meet at a seemingly random police lineup.",
                Arrays.asList(Genres.CRIME, Genres.DRAMA, Genres.MYSTERY)));
        movies.add(new Movie(
                "The Wolf of Wall Street",
                "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker" +
                        " living the high life to his fall involving crime, corruption and the federal government.",
                Arrays.asList(Genres.DRAMA, Genres.ROMANCE, Genres.BIOGRAPHY)));
        movies.add(new Movie(
                "Avatar",
                "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn " +
                        "between following his orders and protecting the world he feels is his home. äää",
                Arrays.asList(Genres.ANIMATION, Genres.DRAMA, Genres.ACTION)));
        movies.add(new Movie(
                "One Piece film red",
                "The Straw Hat Pirates leave for the island of Elegia to attend a concert by Uta," +
                        " a world-famous singer. After Uta performs her first song (\"New Genesis\"), Luffy" +
                        " goes on stage to reunite with her, revealing that the two of them know each" +
                        " other because Uta is the adopted daughter of \"Red-Haired\" Shanks.",
                Arrays.asList(Genres.ADVENTURE, Genres.COMEDY, Genres.ACTION)
        ));

        return movies;
    }
}
