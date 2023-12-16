create table competition_teams (
    competition BIGINT NOT NULL,
    team BIGINT NOT NULL,
	foreign key (competition) references competition(id) ON UPDATE cascade ON DELETE RESTRICT,
	foreign key (team) references team(id) ON UPDATE cascade ON DELETE RESTRICT
);

create table team_players (
    team BIGINT NOT NULL,
    player BIGINT NOT NULL,
    foreign key (team) references team(id) ON UPDATE cascade ON DELETE RESTRICT,
    foreign key (player) references player(id) ON UPDATE cascade ON DELETE RESTRICT
);