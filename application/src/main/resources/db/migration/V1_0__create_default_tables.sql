create table public.competition (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(6) NOT NULL,
    coach_id BIGINT,
    area_id BIGINT
);

create table public.area (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(6) NOT NULL,
    flag VARCHAR(255)
);

create table public.person (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    date_of_birth DATE,
    nationality VARCHAR(96),
    game_position VARCHAR(96)
);

create table public.player (
    id BIGINT PRIMARY KEY NOT NULL,
    person_id INT NOT NULL
);

create table public.coach (
    id BIGINT PRIMARY KEY NOT NULL,
    person_id INT NOT NULL
);

create table public.team (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    short_name VARCHAR(96),
    tla VARCHAR(3),
    area_id BIGINT,
    address VARCHAR(510),
    coach_id BIGINT
);