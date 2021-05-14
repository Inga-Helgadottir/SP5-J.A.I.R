CREATE DATABASE IF NOT EXISTS film_pedia DEFAULT CHARSET = utf8mb4;
USE film_pedia;

 CREATE TABLE IF NOT EXISTS films(
    id INT UNIQUE AUTO_INCREMENT,
    film_name VARCHAR(255) NOT NULL,
    film_genre VARCHAR(255) NOT NULL,
    secondary_film_genre VARCHAR(255) NOT NULL,
    film_year_of_release VARCHAR(255) NOT NULL,
    film_description VARCHAR(255) NOT NULL,
    film_image VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS film_actors(
    id INT UNIQUE AUTO_INCREMENT,
	film_id INT NOT NULL,
    actor_name VARCHAR(255) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(film_id) REFERENCES films(id)
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS film_directors( 
    id INT UNIQUE AUTO_INCREMENT,
	film_id INT NOT NULL,
    director_name VARCHAR(255) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(film_id) REFERENCES films(id)
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS film_user(
    id INT UNIQUE AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS liked_list(
    id INT UNIQUE AUTO_INCREMENT,
    film_id INT,
    film_user_id INT,
    FOREIGN KEY(film_user_id) REFERENCES film_user(id),
    FOREIGN KEY(film_id) REFERENCES films(id)
)ENGINE=InnoDB AUTO_INCREMENT=1;

-- users
INSERT INTO film_user(user_name, user_email, user_password) VALUES ("Martin Olsen", "martin.olsen@mail.dk", "Olsen");
INSERT INTO film_user(user_name, user_email, user_password) VALUES ("Inga Helgadottir", "sih@gmail.com", "Password"); -- \\SP5-J.A.I.R\Film

-- film, director, actors
INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (1, "The Mitchells vs the Machines", "Animation", "Comedy", "30 April 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/The Mitchells vs the Machines.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (1, "Michael Rianda");
INSERT INTO film_actors(film_id, actor_name) VALUES (1, "Abbi Jacobson");
INSERT INTO film_actors(film_id, actor_name) VALUES (1, "Danny McBride");
INSERT INTO film_actors(film_id, actor_name) VALUES (1, "Maya Rudolph");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (2, "22 vs. Earth", "Animation", "Adventure", "25 Marts 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/22 vs. Earth.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (2, "Kevin Nolting");
INSERT INTO film_actors(film_id, actor_name) VALUES (2, "Tina Fey");
INSERT INTO film_actors(film_id, actor_name) VALUES (2, "Richard Ayoade");
INSERT INTO film_actors(film_id, actor_name) VALUES (2, "Alice Braga");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (3, "The Falcon and the Winter Soldier", "Action", "Adventure", "15 january 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/The Falcon and the Winter Soldier.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (3, "Malcolm Spellman");
INSERT INTO film_actors(film_id, actor_name) VALUES (3, "Anthony Mackie");
INSERT INTO film_actors(film_id, actor_name) VALUES (3, "Sebastian Stan");
INSERT INTO film_actors(film_id, actor_name) VALUES (3, "Wyatt Russell");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (4, "Those Who Wish Me Dead", "Action", "Thriller", "14 May 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Those Who Wish Me Dead.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (4, "Taylor Sheridan");
INSERT INTO film_actors(film_id, actor_name) VALUES (4, "Angelina Jolie");
INSERT INTO film_actors(film_id, actor_name) VALUES (4, "Nicholas Hoult");
INSERT INTO film_actors(film_id, actor_name) VALUES (4, "Finn Little");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (5, "Love and Monsters", "Action", "Adventure", "16 October 2020", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Love and Monsters.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (5, "Michael Matthews");
INSERT INTO film_actors(film_id, actor_name) VALUES (5, "Dylan O'Brien");
INSERT INTO film_actors(film_id, actor_name) VALUES (5, "Jessica Henwick");
INSERT INTO film_actors(film_id, actor_name) VALUES (5, "Michael Rooker");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (6, "Endangered Species", "Action", "Thriller", "28 May 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Endangered Species.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (6, "M.J. Bassett");
INSERT INTO film_actors(film_id, actor_name) VALUES (6, "Rebecca Romijn");
INSERT INTO film_actors(film_id, actor_name) VALUES (6, "Philip Winchester");
INSERT INTO film_actors(film_id, actor_name) VALUES (6, "Isabel Bassett");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (7, "Candyman", "Horror", "Thriller", "27 August 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Candyman.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (7, "Nia DaCosta");
INSERT INTO film_actors(film_id, actor_name) VALUES (7, "Yahya Abdul-Mateen II");
INSERT INTO film_actors(film_id, actor_name) VALUES (7, "Teyonah Parris");
INSERT INTO film_actors(film_id, actor_name) VALUES (7, "Nathan Stewart-Jarrett");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (8, "King Richard", "Drama", "", "18 November 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/King Richard.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (8, "Reinaldo Marcus Green");
INSERT INTO film_actors(film_id, actor_name) VALUES (8, "Will Smith");
INSERT INTO film_actors(film_id, actor_name) VALUES (8, "Jon Bernthal");
INSERT INTO film_actors(film_id, actor_name) VALUES (8, "Dylan McDermott");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (9, "Funhouse", "Horror", "", "25 September 2020", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Funhouse.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (9, "Jason William Lee");
INSERT INTO film_actors(film_id, actor_name) VALUES (9, "Valter Skarsgaard");
INSERT INTO film_actors(film_id, actor_name) VALUES (9, "Khamisa Wilsher");
INSERT INTO film_actors(film_id, actor_name) VALUES (9, "Gigi Saul Guerrero");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (10, "La piscine", "Drama", "Romance", "14 July 1970", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/La piscine.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (10, "Jacques Deray");
INSERT INTO film_actors(film_id, actor_name) VALUES (10, "Alain Delon");
INSERT INTO film_actors(film_id, actor_name) VALUES (10, "Romy Schneider");
INSERT INTO film_actors(film_id, actor_name) VALUES (10, "Maurice Ronet");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (11, "The Killing of Two", "Drama", "", "14 May 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/The Killing of Two.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (11, "Robert Machoian");
INSERT INTO film_actors(film_id, actor_name) VALUES (11, "Chris Coy");
INSERT INTO film_actors(film_id, actor_name) VALUES (11, "Clayne Crawford");
INSERT INTO film_actors(film_id, actor_name) VALUES (11, "Arri Graham");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (12, "Things Heard & Seen", "Drama", "Horror", "29 April 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Things Heard & Seen.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (12, "Shari Springer Berman");
INSERT INTO film_actors(film_id, actor_name) VALUES (12, "Amanda Seyfried");
INSERT INTO film_actors(film_id, actor_name) VALUES (12, "James Norton");
INSERT INTO film_actors(film_id, actor_name) VALUES (12, "Natalia Dyer");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (13, "Judas and the Black Messiah", "Drama", "History", "12 February 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Judas and the Black Messiah.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (13, "Shaka King");
INSERT INTO film_actors(film_id, actor_name) VALUES (13, "Daniel Kaluuya");
INSERT INTO film_actors(film_id, actor_name) VALUES (13, "LaKeith Stanfield");
INSERT INTO film_actors(film_id, actor_name) VALUES (13, "Jesse Plemons");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (14, "The Trial of the Chicago", "History", "Thriller", "16 October 2020", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/The Trial of the Chicago.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (14, "Aaron Sorkin");
INSERT INTO film_actors(film_id, actor_name) VALUES (14, "Eddie Redmayne");
INSERT INTO film_actors(film_id, actor_name) VALUES (14, "Alex Sharp");
INSERT INTO film_actors(film_id, actor_name) VALUES (14, "Sacha Baron Cohen");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (15, "Thunder Force", "Comedy", "Adventure", "9 April 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Thunder Force.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (15, "Ben Falcone");
INSERT INTO film_actors(film_id, actor_name) VALUES (15, "Melissa McCarthy");
INSERT INTO film_actors(film_id, actor_name) VALUES (15, "Octavia Spencer");
INSERT INTO film_actors(film_id, actor_name) VALUES (15, "Jason Bateman");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (16, "Shang-Chi and the Legend of the Ten Rings", "Action", "Adventure", "2 September 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Shang-Chi and the Legend of the Ten Rings.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (16, "Destin Daniel Cretton");
INSERT INTO film_actors(film_id, actor_name) VALUES (16, "Simu Liu");
INSERT INTO film_actors(film_id, actor_name) VALUES (16, "Awkwafina");
INSERT INTO film_actors(film_id, actor_name) VALUES (16, "Tony Chiu-Wai Leung");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (17, "Black Widow", "Action", "Sci-Fi", "9 July 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Black Widow.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (17, "Cate Shortland");
INSERT INTO film_actors(film_id, actor_name) VALUES (17, "Scarlett Johansson");
INSERT INTO film_actors(film_id, actor_name) VALUES (17, "Florence Pugh");
INSERT INTO film_actors(film_id, actor_name) VALUES (17, "David Harbour");
 
 INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (18, "Wonder Woman (1984)", "Action", "Adventure", "16 December 2020", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Wonder Woman 1984.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (18, "Patty Jenkins");
INSERT INTO film_actors(film_id, actor_name) VALUES (18, "Gal Gadot");
INSERT INTO film_actors(film_id, actor_name) VALUES (18, "Chris Pine");
INSERT INTO film_actors(film_id, actor_name) VALUES (18, "Kristen Wiig"); 

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (19, "Black Panther", "Adventure", "Sci-Fi", "15 February 2018", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Black Panther.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (19, "Ryan Coogler");
INSERT INTO film_actors(film_id, actor_name) VALUES (19, "Chadwick Boseman");
INSERT INTO film_actors(film_id, actor_name) VALUES (19, "Michael B. Jordan");
INSERT INTO film_actors(film_id, actor_name) VALUES (19, "Lupita Nyong'o");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (20, "Sleepers", "Drama", "Thriller", "20 December 1996", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Sleepers.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (20, "Barry Levinson");
INSERT INTO film_actors(film_id, actor_name) VALUES (20, "Robert De Niro");
INSERT INTO film_actors(film_id, actor_name) VALUES (20, "Kevin Bacon");
INSERT INTO film_actors(film_id, actor_name) VALUES (20, "Brad Pitt");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (21, "Avengers Infinity War", "Action", "Sci-Fi", "25 April 2018", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Avengers Infinity War.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (21, "Anthony Russo");
INSERT INTO film_actors(film_id, actor_name) VALUES (21, "Robert Downey Jr.");
INSERT INTO film_actors(film_id, actor_name) VALUES (21, "Chris Hemsworth");
INSERT INTO film_actors(film_id, actor_name) VALUES (21, "Mark Ruffalo");   

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (22, "The Dark Knight", "Action", "Drama", "22 July 2008", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/The Dark Knight.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (22, "Christopher Nolan");
INSERT INTO film_actors(film_id, actor_name) VALUES (22, "Christian Bale");
INSERT INTO film_actors(film_id, actor_name) VALUES (22, "Heath Ledger");
INSERT INTO film_actors(film_id, actor_name) VALUES (22, "Aaron Eckhart"); 

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (23, "Saving Private Ryan", "Drama", "", "23 October 1998", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Saving Private Ryan.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (23, "Steven Spielberg");
INSERT INTO film_actors(film_id, actor_name) VALUES (23, "Tom Hanks");
INSERT INTO film_actors(film_id, actor_name) VALUES (23, "Matt Damon");
INSERT INTO film_actors(film_id, actor_name) VALUES (23, "Tom Sizemore"); 

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (24, "The Wolf of Wall Street", "Crime", "Drama", "9 January 2014", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/The Wolf of Wall Street.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (24, "Martin Scorsese");
INSERT INTO film_actors(film_id, actor_name) VALUES (24, "Leonardo DiCaprio");
INSERT INTO film_actors(film_id, actor_name) VALUES (24, "Jonah Hill");
INSERT INTO film_actors(film_id, actor_name) VALUES (24, "Margot Robbie");

INSERT INTO films (id, film_name, film_genre, secondary_film_genre, film_year_of_release, film_description, film_image) VALUES (25, "Luca", "Animation", "Comedy", "18 June 2021", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", "src/Film/Luca.jpg");
INSERT INTO film_directors(film_id, director_name) VALUES (25, "Enrico Casarosa");
INSERT INTO film_actors(film_id, actor_name) VALUES (25, "Jacob Tremblay");
INSERT INTO film_actors(film_id, actor_name) VALUES (25, "Jack Dylan Grazer");
INSERT INTO film_actors(film_id, actor_name) VALUES (25, "Maya Rudolph");

-- liked list
INSERT INTO liked_list(film_id, film_user_id) VALUES (11, 1);
INSERT INTO liked_list(film_id, film_user_id) VALUES (5, 1);
INSERT INTO liked_list(film_id, film_user_id) VALUES (10, 1);

INSERT INTO liked_list(film_id, film_user_id) VALUES (1, 2);
INSERT INTO liked_list(film_id, film_user_id) VALUES (22, 2);
INSERT INTO liked_list(film_id, film_user_id) VALUES (20, 2);
