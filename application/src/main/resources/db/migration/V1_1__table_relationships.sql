alter table competition
add constraint fk_competition_area
foreign key (area) references area(id)
on update cascade on delete cascade;

alter table player
add constraint fk_player_person
foreign key (person) references person(id)
on update cascade on delete cascade;

alter table coach
add constraint fk_coach_person
foreign key (person) references person(id)
on update cascade on delete cascade;

alter table team
add constraint fk_team_coach
foreign key (coach) references coach(id)
on update cascade on delete cascade;