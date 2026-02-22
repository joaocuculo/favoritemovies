INSERT INTO tb_movie (imdb_id, title, year, type, poster, plot, imdb_rating, box_office) VALUES
('tt0111161', 'The Shawshank Redemption', '1994', 'movie',
'https://m.media-amazon.com/images/M/MV5BMDAyY2FhYjctNDc5OS00MDNlLThiMGUtY2UxYWVkNGY2ZjljXkEyXkFqcGc@._V1_SX300.jpg',
'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.',
9.3, 28341469),

('tt0068646', 'The Godfather', '1972', 'movie',
'https://m.media-amazon.com/images/M/MV5BNGEwYjgwOGQtYjg5ZS00Njc1LTk2ZGEtM2QwZWQ2NjdhZTE5XkEyXkFqcGc@._V1_SX300.jpg',
'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.',
9.2, 134966411),

('tt0468569', 'The Dark Knight', '2008', 'movie',
'https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzMtYTAwMC00ZjQ3LWFmNTEtODM1ZmRlY2RhZGIxXkEyXkFqcGc@._V1_SX300.jpg',
'Batman faces the Joker, a criminal mastermind who seeks to undermine his influence in Gotham.',
9.0, 1004558444),

('tt0109830', 'Forrest Gump', '1994', 'movie',
'https://m.media-amazon.com/images/M/MV5BMTk3OTQzMDM0OV5BMl5BanBnXkFtZTcwODkzNTU3Mw@@._V1_SX300.jpg',
'The presidencies of Kennedy and Johnson, the Vietnam War, and other historical events unfold from the perspective of an Alabama man.',
8.8, 678226465),

('tt0133093', 'The Matrix', '1999', 'movie',
'https://m.media-amazon.com/images/M/MV5BNzQzOTk3NTAtYTAwMC00ZjQ3LWFmNTEtODM1ZmRlY2RhZGIxXkEyXkFqcGc@._V1_SX300.jpg',
'A computer hacker learns about the true nature of his reality and his role in the war against its controllers.',
8.7, 466364845),

('tt0120737', 'The Lord of the Rings: The Fellowship of the Ring', '2001', 'movie',
'https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzMtYTAwMC00ZjQ3LWFmNTEtODM1ZmRlY2RhZGIxXkEyXkFqcGc@._V1_SX300.jpg',
'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the One Ring.',
8.8, 888379579),

('tt0167260', 'The Lord of the Rings: The Return of the King', '2003', 'movie',
'https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzMtYTAwMC00ZjQ3LWFmNTEtODM1ZmRlY2RhZGIxXkEyXkFqcGc@._V1_SX300.jpg',
'Gandalf and Aragorn lead the World of Men against Sauron to draw his gaze from Frodo and Sam.',
9.0, 1146030912),

('tt1375666', 'Inception', '2010', 'movie',
'https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjY1Nl5BMl5BanBnXkFtZTcwNTkzNTU3Mw@@._V1_SX300.jpg',
'A thief who steals corporate secrets through dream-sharing technology is given the inverse task of planting an idea.',
8.8, 836848102),

('tt0816692', 'Interstellar', '2014', 'movie',
'https://m.media-amazon.com/images/M/MV5BMjIxNTU4MzYzNl5BMl5BanBnXkFtZTgwNzUxNjk3MjE@._V1_SX300.jpg',
'A team of explorers travel through a wormhole in space in an attempt to ensure humanity survival.',
8.6, 773350147),

('tt0137523', 'Fight Club', '1999', 'movie',
'https://m.media-amazon.com/images/M/MV5BMmEzNTYxNTAtYTAwMC00ZjQ3LWFmNTEtODM1ZmRlY2RhZGIxXkEyXkFqcGc@._V1_SX300.jpg',
'An insomniac office worker and a soap maker form an underground fight club that evolves into something much more.',
8.8, 100853753);

INSERT INTO tb_users (name, email, password, role) VALUES
('Pedro', 'pedro@email.com', '$2a$10$oE.hIOSW3O5YQI8HwuK0COR4mY1X7gli7yL9zdzKHgxqNbYRMCfQ.', 'ADMIN');

INSERT INTO tb_favorites (favorited_at, user_id, movie_id) VALUES
('2026-02-17T10:00:00Z', 1, 1),
('2026-02-17T10:05:00Z', 1, 3),
('2026-02-17T10:10:00Z', 1, 5),
('2026-02-17T10:15:00Z', 1, 7),
('2026-02-17T10:20:00Z', 1, 9);
