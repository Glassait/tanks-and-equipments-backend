create table shells
(
    id      int unsigned auto_increment
        primary key,
    tank_id int unsigned  not null,
    name    varchar(255)  null,
    amount  int           null,
    premium int default 0 null,
    constraint shell_tanks_id_fk
        foreign key (tank_id) references tanks (id)
            on update cascade
);

INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (1, 1, 'AP', 5, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (2, 1, 'HEAT', 25, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (3, 1, 'HE', 5, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (4, 2, 'APCR', 10, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (5, 2, 'HEAT', 25, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (6, 2, 'HE', 5, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (7, 3, 'APCR', 14, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (8, 3, 'HEAT', 30, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (9, 3, 'HE', 1, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (10, 4, 'APCR', 22, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (11, 4, 'HEAT', 30, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (12, 4, 'HE', 1, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (13, 5, 'APCR', 0, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (14, 5, 'APCR', 34, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (15, 5, 'HE', 6, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (16, 6, 'APCR', 0, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (17, 6, 'APCR', 33, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (18, 6, 'HE', 7, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (19, 7, 'AP', 0, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (20, 7, 'APCR', 40, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (21, 7, 'HE', 10, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (22, 8, 'AP', 0, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (23, 8, 'APCR', 19, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (24, 8, 'HE', 8, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (25, 9, 'APCR', 15, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (26, 9, 'HEAT', 10, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (27, 9, 'HE', 10, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (28, 10, 'AP', 5, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (29, 10, 'HEAT', 30, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (30, 10, 'HE', 5, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (31, 11, 'AP', 16, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (32, 11, 'HEAT', 10, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (33, 11, 'HE', 4, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (34, 12, 'APCR', 0, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (35, 12, 'APCR', 55, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (36, 12, 'HE', 5, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (37, 13, 'APCR', 0, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (38, 13, 'APCR', 46, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (39, 13, 'HE', 4, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (40, 14, 'AP', 0, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (41, 14, 'APCR', 23, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (42, 14, 'HE', 7, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (43, 15, 'APCR', 10, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (44, 15, 'HEAT', 30, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (45, 15, 'HE', 5, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (46, 16, 'AP', 0, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (47, 16, 'APCR', 48, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (48, 16, 'HE', 8, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (49, 17, 'AP', 10, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (50, 17, 'HEAT', 15, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (51, 17, 'HE', 5, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (52, 18, 'AP', 6, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (53, 18, 'HEAT', 20, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (54, 18, 'HE', 4, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (55, 19, 'AP', 8, 0);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (56, 19, 'HEAT', 30, 1);
INSERT INTO shells (id, tank_id, name, amount, premium) VALUES (57, 19, 'HE', 4, 0);
