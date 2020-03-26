package recommendation;

import java.util.*;

public class User {

    private final Map<Category, Integer> categories = new HashMap<>();

    private final Film[] lastTenFilmsWithGoodVotes = new Film[10];

    private int nextFreeFilmPos = 0;

    public void voteCategory(Category category, int vote) {
        if (vote < 0 || vote > 10) {
            throw new IllegalArgumentException("Vote must be between 0 and 10");
        }
        categories.put(category, vote);
    }

    public Map<Category,Integer> getCategoriesVotes(){
        return Collections.unmodifiableMap(categories);
    }

    public int getVote(Category category) {
        return categories.get(category);
    }

    public boolean hasVotedFor(Category category) {
        return categories.get(category) != null;
    }

    public void addWatchedFilm(Film film) {
        if (nextFreeFilmPos < lastTenFilmsWithGoodVotes.length) {
            lastTenFilmsWithGoodVotes[nextFreeFilmPos] = film;
            nextFreeFilmPos = nextFreeFilmPos + 1;
            return ;
        }

        Film filmWithMinVote = lastTenFilmsWithGoodVotes[0];

        int positionOfFilWithMinVote = 0;

        for (int i = 1; i < lastTenFilmsWithGoodVotes.length; i++) {
            if (filmWithMinVote.getVote() > lastTenFilmsWithGoodVotes[i].getVote()) {
                filmWithMinVote = lastTenFilmsWithGoodVotes[i];
                positionOfFilWithMinVote = i;
            }
        }

        if (film.getVote() > lastTenFilmsWithGoodVotes[positionOfFilWithMinVote].getVote()) {
            lastTenFilmsWithGoodVotes[positionOfFilWithMinVote] = film;
        }
    }

    public List<Film> getTopFilms() {
        List<Film> films = new ArrayList<>();

        for (int i = 0; i < nextFreeFilmPos; i++) {
            films.add(lastTenFilmsWithGoodVotes[i]);
        }

        return films;
    }
}
