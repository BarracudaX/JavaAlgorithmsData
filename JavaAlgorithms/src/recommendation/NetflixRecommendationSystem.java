package recommendation;

import java.util.*;

public class NetflixRecommendationSystem {

    private final Set<User> users = new HashSet<>();


    public void addUser(User user) {
        users.add(user);
    }

    public Set<Film> getRecommendations(User user) {
        if (!users.contains(user)) {
            throw new IllegalArgumentException("The user is not a netflix user.");
        }

        Set<Film> films = new HashSet<>();

        User[] nearestNeighbors = new User[(int) Math.sqrt(users.size() - 1)];

        Map<User, Integer> diff = new HashMap<>();

        for (User propNeighbor : users) {

            if (user.equals(propNeighbor)) {
                continue;
            }

            int sum = 0;

            for (Map.Entry<Category, Integer> entry : propNeighbor.getCategoriesVotes().entrySet()) {
                if (user.hasVotedFor(entry.getKey())) {
                    sum = (int) (sum + Math.pow((user.getVote(entry.getKey()) - entry.getValue()), 2));
                }
            }

            diff.put(propNeighbor, (int) Math.sqrt(sum));
        }

        for (int i = 0; i < nearestNeighbors.length; i++) {
            Iterator<User> iterator = diff.keySet().iterator();

            User nearest = iterator.next();

            for (User nextUser = iterator.next(); iterator.hasNext(); nextUser = iterator.next()) {
                if (diff.get(nearest) > diff.get(nextUser)) {
                    nearest = nextUser;
                }
            }

            nearestNeighbors[i] = nearest;

            diff.remove(nearest);
        }

        for (User nearestNeighbor : nearestNeighbors) {
            films.addAll(nearestNeighbor.getTopFilms());
        }

        return films;
    }

}
