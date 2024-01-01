create table equipments
(
    id         int unsigned auto_increment
        primary key,
    tank_id    int unsigned             not null,
    first      int unsigned default '1' null,
    name       varchar(255)             null,
    modernized int unsigned default '0' null,
    constraint equipments_tanks_id_fk
        foreign key (tank_id) references tanks (id)
            on update cascade
);

INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (1, 1, 1, 'Gamme d\'amélioration de la survie', 1);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (2, 1, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (3, 1, 1, 'Système d\'amélioration de la mobilité', 1);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (4, 1, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (5, 1, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (6, 1, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (7, 2, 1, 'Gamme d\'amélioration de la survie', 1);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (8, 2, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (9, 2, 1, 'Système d\'amélioration de la mobilité', 1);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (10, 2, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (11, 2, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (12, 2, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (13, 3, 1, 'Stabilisateur vertical', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (14, 3, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (15, 3, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (16, 3, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (17, 3, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (18, 3, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (19, 4, 1, 'Stabilisateur vertical', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (20, 4, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (21, 4, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (22, 4, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (23, 4, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (24, 4, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (25, 5, 1, 'Gamme d\'amélioration de la survie', 1);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (26, 5, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (27, 5, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (28, 5, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (29, 5, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (30, 5, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (31, 6, 1, 'Gamme d\'amélioration de la survie', 1);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (32, 6, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (33, 6, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (34, 6, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (35, 6, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (36, 6, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (37, 7, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (38, 7, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (39, 7, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (40, 7, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (41, 7, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (42, 7, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (43, 8, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (44, 8, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (45, 8, 1, 'Visée améliorée', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (46, 8, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (47, 8, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (48, 8, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (49, 9, 1, 'Système de vision du chef de char', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (50, 9, 1, 'Silencieux de système d\'échapement', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (51, 9, 1, 'Optiques traitées', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (52, 9, 0, 'Ventilation améliorée', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (53, 9, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (54, 9, 0, 'Optiques traitées', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (55, 10, 1, 'Gamme d\'amélioration de la survie', 1);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (56, 10, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (57, 10, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (58, 10, 0, 'Configuration modifiée', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (59, 10, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (60, 10, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (61, 11, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (62, 11, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (63, 11, 1, 'Configuration modifiée', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (64, 11, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (65, 11, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (66, 11, 0, 'Configuration modifiée', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (67, 12, 1, 'Ventilation améliorée', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (68, 12, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (69, 12, 1, 'Stabilisateur vertical', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (70, 12, 0, 'Ventilation améliorée', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (71, 12, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (72, 12, 0, 'Stabilisateur vertical', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (73, 13, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (74, 13, 1, 'Ventilation améliorée', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (75, 13, 1, 'Filet de camouflage', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (76, 13, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (77, 13, 0, 'Ventilation améliorée', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (78, 13, 0, 'Filet de camouflage', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (79, 14, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (80, 14, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (81, 14, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (82, 14, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (83, 14, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (84, 14, 0, 'Optiques traitées', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (85, 15, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (86, 15, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (87, 15, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (88, 15, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (89, 15, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (90, 15, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (91, 16, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (92, 16, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (93, 16, 1, 'Stabilisateur vertical', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (94, 16, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (95, 16, 0, 'Ventilation améliorée', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (96, 16, 0, 'Stabilisateur vertical', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (97, 17, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (98, 17, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (99, 17, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (100, 17, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (101, 17, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (102, 17, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (103, 18, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (104, 18, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (105, 18, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (106, 18, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (107, 18, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (108, 18, 0, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (109, 19, 1, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (110, 19, 1, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (111, 19, 1, 'Turbocompresseur', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (112, 19, 0, 'Durcissant amélioré', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (113, 19, 0, 'Fouloir de canon', 0);
INSERT INTO equipments (id, tank_id, first, name, modernized) VALUES (114, 19, 0, 'Turbocompresseur', 0);
