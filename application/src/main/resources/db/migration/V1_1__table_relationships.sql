alter table sys.competition
add constraint fk_competition_area
foreign key (area)
references sys.area(id)
on update cascade on delete cascade;

alter table sys.person
add constraint fk_person_nationality
foreign key (nationality)
references sys.area(id)
on update cascade on delete cascade;

alter table sys.person
add constraint fk_person_game_position
foreign key (game_position)
references sys.game_position(id)
on update cascade on delete cascade;

alter table sys.player
add constraint fk_player_person
foreign key (person)
references sys.person(id)
on update cascade on delete cascade;

alter table sys.coach
add constraint fk_coach_person
foreign key (person)
references sys.person(id)
on update cascade on delete cascade;