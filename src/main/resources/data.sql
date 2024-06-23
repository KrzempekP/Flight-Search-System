INSERT INTO "user" (username)
VALUES ('User1'),
       ('User2'),
       ('User3');

INSERT INTO flight (departure, destination, passengers_Capacity, available_seats, cost)
VALUES ('KRK', 'ATN', 100, 80, 50.0),
       ('KRK', 'WAW', 120, 60, 65.0),
       ('KRK', 'BHX', 140, 40, 80.0);

INSERT INTO reservation (user_id, flight_id, number_of_passengers, total_cost)
VALUES (1, 1, 4, 100),
       (1, 2, 5, 100),
       (2, 1, 2, 150),
       (2, 2, 7, 300);