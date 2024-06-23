INSERT INTO user (username) VALUES
('User1'),
('User2');

INSERT INTO flight (departure, destination, passengersCapacity, avaliableSeats, cost) VALUES
('KRK', 'ATN' 100, 80, 50.0),
('KRK', 'WAW' 120, 60, 65.0),
('KRK', 'BHX' 140, 40, 80.0);

INSERT INTO  reservation (user_id, flight_id, numberOfPassengers) VALUES
(1, 1, 4),
(1, 2, 5),
(2, 1, 2),
(2, 2, 7);