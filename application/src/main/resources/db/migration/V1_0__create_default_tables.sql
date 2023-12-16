create table competition (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(6) NOT NULL,
    area BIGINT
);

create table area (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(6) NOT NULL,
    flag VARCHAR(255)
);

create table person (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    nationality VARCHAR(96),
    game_position VARCHAR(96)
);

create table player (
    id BIGINT PRIMARY KEY NOT NULL,
    person BIGINT NOT NULL,
    current_team BIGINT
);

create table coach (
    id BIGINT PRIMARY KEY NOT NULL,
    person BIGINT NOT NULL,
    current_team BIGINT
);

create table team (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    short_name VARCHAR(96),
    tla VARCHAR(3),
    area BIGINT,
    address VARCHAR(510),
    coach BIGINT
);