package recommendation;

import java.util.Objects;

public class Film {

    private final String name;

    private final int vote;

    public Film(String name, int vote) {
        if (vote < 0 || vote > 10) {
            throw new IllegalArgumentException("Vote must be between 0 and 10.");
        }
        this.name = name;
        this.vote = vote;
    }

    public int getVote() {
        return vote;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(getName(), film.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                '}';
    }
}
