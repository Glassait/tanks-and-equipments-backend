create table consumables
(
    id      int unsigned auto_increment
        primary key,
    tank_id int unsigned not null,
    first   varchar(255) null,
    second  varchar(255) null,
    constraint consumables_tanks_id_fk
        foreign key (tank_id) references tanks (id)
            on update cascade
);

INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (1, 1, 'Huile prêt-bail,Grand kit de réparation,Rations de combat supplémentaires', 'Grande trousse de premiers secours,Grand kit de réparation,Rations de combat supplémentaires');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (2, 2, 'Huile prêt-bail,Grand kit de réparation,Rations de combat supplémentaires', 'Grande trousse de premiers secours,Grand kit de réparation,Rations de combat supplémentaires');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (3, 3, 'Grande trousse de premiers secours,Grand kit de réparation,Rations de combat supplémentaires', 'Retrait du régulateur de vitesse,Grand kit de réparation,Rations de combat supplémentaires');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (4, 4, 'Grande trousse de premiers secours,Grand kit de réparation,Rations de combat supplémentaires', 'Retrait du régulateur de vitesse,Grand kit de réparation,Rations de combat supplémentaires');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (5, 5, 'Grande trousse de premiers secours,Grand kit de réparation,Pudding et thé', 'Grande trousse de premiers secours,Grand kit de réparation,Pudding et thé');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (6, 6, 'Grande trousse de premiers secours,Grand kit de réparation,Pudding et thé', 'Grande trousse de premiers secours,Grand kit de réparation,Pudding et thé');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (7, 7, 'Grande trousse de premiers secours,Grand kit de réparation,Tartines de smalec', 'Essence indice d\'octane 105,Grand kit de réparation,Tartines de smalec');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (8, 8, 'Grande trousse de premiers secours,Grand kit de réparation,Caisse de cola', 'Grande trousse de premiers secours,Grand kit de réparation,Caisse de cola');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (9, 9, 'Grande trousse de premiers secours,Grand kit de réparation,Café fort', 'Grande trousse de premiers secours,Grand kit de réparation,Café fort');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (10, 10, 'Grande trousse de premiers secours,Grand kit de réparation,Rations de combat supplémentaires', 'Grande trousse de premiers secours,Grand kit de réparation,Rations de combat supplémentaires');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (11, 11, 'Grande trousse de premiers secours,Grand kit de réparation,Rations de combat supplémentaires', 'Grande trousse de premiers secours,Grand kit de réparation,Rations de combat supplémentaires');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (12, 12, 'Grande trousse de premiers secours,Grand kit de réparation,Chocolat', 'Grande trousse de premiers secours,Grand kit de réparation,Chocolat');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (13, 13, 'Grande trousse de premiers secours,Grand kit de réparation,Café avec brioches à la cannelle', 'Grande trousse de premiers secours,Grand kit de réparation,Café avec brioches à la cannelle');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (14, 14, 'Grande trousse de premiers secours,Grand kit de réparation,Rations de combat supplémentaires', 'Huile prêt-bail,Grand kit de réparation,Rations de combat supplémentaires');
INSERT INTO s2yjl4uhwlgfakcs.consumables (id, tank_id, first, second) VALUES (15, 15, 'Grande trousse de premiers secours,Grand kit de réparation,Chocolat', 'Grande trousse de premiers secours,Grand kit de réparation,Chocolat');
