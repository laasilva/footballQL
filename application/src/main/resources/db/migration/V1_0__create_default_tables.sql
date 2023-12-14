create table sys.competition (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(6) NOT NULL,
    area BIGINT,
);

create table sys.area (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(6) NOT NULL,
    flag VARCHAR(255),
);

create table sys.game_position (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

create table sys.person (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    nationality BIGINT,
    shirt_number INTEGER,
    game_position BIGINT
);

create table sys.player (
    id SERIAL PRIMARY KEY NOT NULL,
    person BIGINT NOT NULL,
    current_team BIGINT
);

create table sys.coach (
    id SERIAL PRIMARY KEY NOT NULL,
    person BIGINT NOT NULL,
    current_team BIGINT
);

create table sys.team (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    short_name VARCHAR(96),
    tla VARCHAR(3),
    area BIGINT,
    address VARCHAR(510)
);