package recommendation;

public class TestDrive {

    public static void main(String[] args) {
        NetflixRecommendationSystem netflix = new NetflixRecommendationSystem();

        User maria = new User();
        maria.voteCategory(Category.DRAMA, 8);
        maria.voteCategory(Category.ACTION, 3);
        maria.voteCategory(Category.ADVENTURE, 10);
        maria.voteCategory(Category.COMEDY, 7);

        User giwrgos = new User();
        giwrgos.voteCategory(Category.DRAMA, 3);
        giwrgos.voteCategory(Category.ACTION, 9);
        giwrgos.voteCategory(Category.ADVENTURE, 7);
        giwrgos.voteCategory(Category.COMEDY, 4);

        User stephano = new User();
        stephano.voteCategory(Category.DRAMA, 10);
        stephano.voteCategory(Category.ACTION, 0);
        stephano.voteCategory(Category.ADVENTURE, 1);
        stephano.voteCategory(Category.COMEDY, 10);

        User nikoleta = new User();
        nikoleta.voteCategory(Category.DRAMA, 7);
        nikoleta.voteCategory(Category.ACTION, 8);
        nikoleta.voteCategory(Category.ADVENTURE, 5);
        nikoleta.voteCategory(Category.COMEDY, 4);

        User anna = new User();
        anna.voteCategory(Category.DRAMA, 4);
        anna.voteCategory(Category.ACTION, 3);
        anna.voteCategory(Category.ADVENTURE, 9);
        anna.voteCategory(Category.COMEDY, 5);

        User petros = new User();
        petros.voteCategory(Category.DRAMA, 3);
        petros.voteCategory(Category.ACTION, 10);
        petros.voteCategory(Category.ADVENTURE, 4);
        petros.voteCategory(Category.COMEDY, 2);

        User rodya = new User();
        rodya.voteCategory(Category.DRAMA, 10);
        rodya.voteCategory(Category.ACTION, 5);
        rodya.voteCategory(Category.ADVENTURE, 6);
        rodya.voteCategory(Category.COMEDY, 10);

        User razumixin = new User();
        razumixin.voteCategory(Category.DRAMA, 4);
        razumixin.voteCategory(Category.ACTION, 10);
        razumixin.voteCategory(Category.ADVENTURE, 8);
        razumixin.voteCategory(Category.COMEDY, 9);

        User dunya = new User();
        dunya.voteCategory(Category.DRAMA, 7);
        dunya.voteCategory(Category.ACTION, 8);
        dunya.voteCategory(Category.ADVENTURE, 9);
        dunya.voteCategory(Category.COMEDY, 1);

        User thanos = new User();
        thanos.voteCategory(Category.DRAMA, 4);
        thanos.voteCategory(Category.ACTION, 3);
        thanos.voteCategory(Category.ADVENTURE, 8);
        thanos.voteCategory(Category.COMEDY, 7);

        netflix.addUser(giwrgos);
        netflix.addUser(anna);
        netflix.addUser(dunya);
        netflix.addUser(maria);
        netflix.addUser(nikoleta);
        netflix.addUser(petros);
        netflix.addUser(razumixin);
        netflix.addUser(rodya);
        netflix.addUser(stephano);
        netflix.addUser(thanos);

        giwrgos.addWatchedFilm(new Film("Game Of Thrones",8));
        giwrgos.addWatchedFilm(new Film("Titans",9));
        giwrgos.addWatchedFilm(new Film("Marvel Superheroes",7));

        anna.addWatchedFilm(new Film("The Black Panther",7));
        anna.addWatchedFilm(new Film("The Government",5));
        anna.addWatchedFilm(new Film("Maria 2",9));

        dunya.addWatchedFilm(new Film("The Pirates",4));
        dunya.addWatchedFilm(new Film("The Assassins",10));

        maria.addWatchedFilm(new Film("The Princess",9));
        maria.addWatchedFilm(new Film("The World Of Warcraft",4));

        nikoleta.addWatchedFilm(new Film("The Princess",9));
        nikoleta.addWatchedFilm(new Film("The World Of Warcraft",4));

        petros.addWatchedFilm(new Film("Breaking Bad",8));
        petros.addWatchedFilm(new Film("Heroes",7));
        petros.addWatchedFilm(new Film("Pirates Of The Black Messa",9));

        razumixin.addWatchedFilm(new Film("Crime And Punishment",10));
        razumixin.addWatchedFilm(new Film("The Idiot",10));
        razumixin.addWatchedFilm(new Film("Underground",10));

        rodya.addWatchedFilm(new Film("What Shall Be Done Then?",8));
        rodya.addWatchedFilm(new Film("Confession",4));

        stephano.addWatchedFilm(new Film("The Cozzet",7));
        stephano.addWatchedFilm(new Film("War And Peace",9));

        System.out.println(netflix.getRecommendations(thanos));

    }

}
