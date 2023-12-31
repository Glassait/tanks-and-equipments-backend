create table directives
(
    id      int unsigned auto_increment
        primary key,
    tank_id int unsigned not null,
    name    varchar(255) null,
    image   varchar(255) null,
    constraint directives_tanks_id_fk
        foreign key (tank_id) references tanks (id)
            on update cascade
);

INSERT INTO directives (id, tank_id, name, image) VALUES (1, 1, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (2, 2, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (3, 3, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (4, 4, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (5, 5, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (6, 6, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (7, 7, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (8, 8, 'Lentille polie', 'visée_améliorée');
INSERT INTO directives (id, tank_id, name, image) VALUES (9, 9, 'Étalonnage optique', 'optiques_traitées');
INSERT INTO directives (id, tank_id, name, image) VALUES (10, 10, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (11, 11, 'Maintenance d\'avant-bataille', 'configuration_modifiée');
INSERT INTO directives (id, tank_id, name, image) VALUES (12, 12, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (13, 13, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (14, 14, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
INSERT INTO directives (id, tank_id, name, image) VALUES (15, 15, 'Râtelier de munitions en ordre', 'fouloir_de_canon');
