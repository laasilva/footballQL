alter table public.competition
add constraint fk_competition_area
foreign key (area_id) references public.area(id)
on update cascade on delete cascade;

alter table public.player
add constraint fk_player_person
foreign key (person_id) references public.person(id)
on update cascade on delete cascade;

alter table public.coach
add constraint fk_coach_person
foreign key (person_id) references public.person(id)
on update cascade on delete cascade;

alter table public.team
add constraint fk_team_coach
foreign key (coach_id) references public.coach(id)
on update cascade on delete cascade;

alter table public.team
add constraint fk_team_area
foreign key (area_id) references public.area(id)
on update cascade on delete cascade;
