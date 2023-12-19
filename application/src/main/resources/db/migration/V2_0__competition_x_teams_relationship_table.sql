create table public.competition_teams (
    competition_id BIGINT NOT NULL,
    team_id BIGINT NOT NULL,
	foreign key (competition_id) references competition(id) ON UPDATE cascade ON DELETE RESTRICT,
	foreign key (team_id) references team(id) ON UPDATE cascade ON DELETE RESTRICT
);

create table public.team_players (
    team_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    foreign key (team_id) references team(id) ON UPDATE cascade ON DELETE RESTRICT,
    foreign key (player_id) references player(id) ON UPDATE cascade ON DELETE RESTRICT
);