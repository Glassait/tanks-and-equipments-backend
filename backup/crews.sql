create table crews
(
    id      int unsigned auto_increment
        primary key,
    tank_id int unsigned not null,
    crew    varchar(255) null,
    constraint crew_tanks_id_fk
        foreign key (tank_id) references tanks (id)
            on update cascade
);

INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (1, 1, 'Commandant,Tireur,Pilote de char,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (2, 2, 'Commandant,Tireur,Pilote de char,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (3, 3, 'Commandant,Tireur,Pilote de char,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (4, 4, 'Commandant,Tireur,Pilote de char,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (5, 5, 'Commandant,Tireur,Pilote de char,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (6, 6, 'Commandant,Tireur,Pilote de char,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (7, 7, 'Commandant,Tireur,Pilote de char,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (8, 8, 'Commandant,Tireur,Pilote de char,Chargeur,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (9, 9, 'Commandant,Tireur,Pilote de char,Opérateur radio');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (10, 10, 'Commandant,Tireur,Pilote de char,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (11, 11, 'Commandant,Tireur,Pilote de char,Chargeur,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (12, 12, 'Commandant,Tireur,Pilote de char,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (13, 13, 'Commandant,Pilote de char,Opérateur radio');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (14, 14, 'Commandant,Tireur,Pilote de char,Chargeur,Chargeur');
INSERT INTO s2yjl4uhwlgfakcs.crews (id, tank_id, crew) VALUES (15, 15, 'Commandant,Tireur,Pilote de char,Chargeur,Chargeur');
