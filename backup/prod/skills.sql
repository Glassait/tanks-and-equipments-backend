create table skills
(
    id      int unsigned auto_increment
        primary key,
    tank_id int unsigned not null,
    skill   varchar(255) null,
    constraint skill_tanks_id_fk
        foreign key (tank_id) references tanks (id)
            on update cascade
);

INSERT INTO skills (id, tank_id, skill) VALUES (76, 1, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (77, 1, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (78, 1, 'Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (79, 1, 'Longue-vue,Précision,Maintenance préventive,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (80, 1, 'Œil de lynx,Coup mortel,Conduite souple,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (81, 2, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (82, 2, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (83, 2, 'Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (84, 2, 'Longue-vue,Précision,Maintenance préventive,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (85, 2, 'Œil de lynx,Coup mortel,Conduite souple,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (86, 3, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (87, 3, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (88, 3, 'Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (89, 3, 'Longue-vue,Précision,Conduite souple,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (90, 3, 'Œil de lynx,Coup mortel,Maintenance préventive,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (91, 4, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (92, 4, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (93, 4, 'Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (94, 4, 'Longue-vue,Précision,Conduite souple,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (95, 4, 'Œil de lynx,Coup mortel,Maintenance préventive,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (96, 5, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (97, 5, 'Réparations,Coup mortel,Conduite souple,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (98, 5, 'Œil de lynx,Réparations,Réparations,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (99, 5, 'Lutte contre les incendies,Précision,As du volant,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (100, 5, 'Dissimulation,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (101, 6, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (102, 6, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (103, 6, 'Lutte contre les incendies,Précision,Conduite souple,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (104, 6, 'Longue-vue,Coup mortel,As du volant,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (105, 6, 'Œil de lynx,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (106, 7, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (107, 7, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (108, 7, 'Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (109, 7, 'Longue-vue,Précision,Maintenance préventive,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (110, 7, 'Œil de lynx,Dissimulation,Conduite souple,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (111, 8, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (112, 8, 'Réparations,Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (113, 8, 'Longue-vue,Coup mortel,Conduite souple,Intuition,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (114, 8, 'Lutte contre les incendies,Précision,As du volant,Râtelier sécurisé,Poussée d\'adrénaline');
INSERT INTO skills (id, tank_id, skill) VALUES (115, 8, 'Œil de lynx,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (116, 9, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (117, 9, 'Dissimulation,Dissimulation,Dissimulation,Dissimulation');
INSERT INTO skills (id, tank_id, skill) VALUES (118, 9, 'Intuition,Précision,Conduite souple,Longue-vue');
INSERT INTO skills (id, tank_id, skill) VALUES (119, 9, 'Œil de lynx,Réparations,Bélier,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (120, 9, 'Réparations,Coup mortel,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (121, 10, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (122, 10, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (123, 10, 'Longue-vue,Précision,Conduite souple,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (124, 10, 'Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (125, 10, 'Œil de lynx,Coup mortel,Maintenance préventive,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (126, 11, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (127, 11, 'Réparations,Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (128, 11, 'Longue-vue,Coup mortel,Conduite souple,Râtelier sécurisé,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (129, 11, 'Lutte contre les incendies,Précision,As du volant,Lutte contre les incendies,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (130, 11, 'Œil de lynx,Lutte contre les incendies,Lutte contre les incendies,Intuition,Poussée d\'adrénaline');
INSERT INTO skills (id, tank_id, skill) VALUES (131, 12, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (132, 12, 'Longue-vue,Dissimulation,Dissimulation,Dissimulation');
INSERT INTO skills (id, tank_id, skill) VALUES (133, 12, 'Œil de lynx,Réparations,Conduite souple,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (134, 12, 'Dissimulation,Lutte contre les incendies,Réparations,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (135, 12, 'Réparations,Précision,Maintenance préventive,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (136, 13, 'Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (137, 13, 'Dissimulation,Dissimulation,Dissimulation');
INSERT INTO skills (id, tank_id, skill) VALUES (138, 13, 'Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (139, 13, 'Œil de lynx,Lutte contre les incendies,Longue-vue');
INSERT INTO skills (id, tank_id, skill) VALUES (140, 13, 'Lutte contre les incendies,Maintenance préventive,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (141, 14, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (142, 14, 'Réparations,Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (143, 14, 'Longue-vue,Coup mortel,Conduite souple,Râtelier sécurisé,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (144, 14, 'Détection sonore,Précision,Bélier,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (145, 14, 'Œil de lynx,Lutte contre les incendies,As du volant,Intuition,Poussée d\'adrénaline');
INSERT INTO skills (id, tank_id, skill) VALUES (146, 15, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (147, 15, 'Réparations,Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (148, 15, 'Longue-vue,Précision,Conduite souple,Intuition,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (149, 15, 'Lutte contre les incendies,Coup mortel,As du volant,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (150, 15, 'Dissimulation,Lutte contre les incendies,Lutte contre les incendies,Dissimulation,Dissimulation');
INSERT INTO skills (id, tank_id, skill) VALUES (151, 16, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (152, 16, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (153, 16, 'Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (154, 16, 'Œil de lynx,Précision,Conduite souple,Longue-vue');
INSERT INTO skills (id, tank_id, skill) VALUES (155, 16, 'Expert,Râtelier sécurisé,Maintenance préventive,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (156, 17, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (157, 17, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (158, 17, 'Lutte contre les incendies,Précision,Conduite souple,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (159, 17, 'Longue-vue,Coup mortel,As du volant,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (160, 17, 'Œil de lynx,Lutte contre les incendies,Lutte contre les incendies,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (161, 18, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (162, 18, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (163, 18, 'Lutte contre les incendies,Précision,Conduite souple,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (164, 18, 'Longue-vue,Coup mortel,As du volant,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (165, 18, 'Œil de lynx,Lutte contre les incendies,Lutte contre les incendies,Râtelier sécurisé');
INSERT INTO skills (id, tank_id, skill) VALUES (166, 19, 'Frères d\'armes,Frères d\'armes,Frères d\'armes,Frères d\'armes');
INSERT INTO skills (id, tank_id, skill) VALUES (167, 19, 'Réparations,Réparations,Réparations,Réparations');
INSERT INTO skills (id, tank_id, skill) VALUES (168, 19, 'Lutte contre les incendies,Précision,Conduite souple,Intuition');
INSERT INTO skills (id, tank_id, skill) VALUES (169, 19, 'Longue-vue,Coup mortel,As du volant,Lutte contre les incendies');
INSERT INTO skills (id, tank_id, skill) VALUES (170, 19, 'Œil de lynx,Lutte contre les incendies,Lutte contre les incendies,Râtelier sécurisé');
