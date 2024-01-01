create table tanks
(
    id       int unsigned auto_increment
        primary key,
    name     tinytext      not null,
    priority int           not null,
    meta     int default 0 not null
);

INSERT INTO tanks (id, name, priority, meta) VALUES (1, 'Object 277', 4, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (2, 'Object 260', 4, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (3, 'Object 907', 4, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (4, 'Object 140', 4, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (5, 'T95/FV4201 Chieftain', 4, 0);
INSERT INTO tanks (id, name, priority, meta) VALUES (6, 'Super Conqueror', 2, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (7, 'CS-63', 3, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (8, 'T110E3', 4, 0);
INSERT INTO tanks (id, name, priority, meta) VALUES (9, 'Panhard EBR 105', 3, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (10, 'Object 279 early', 4, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (11, 'Object 268 version 4', 4, 0);
INSERT INTO tanks (id, name, priority, meta) VALUES (12, 'Leopard 1', 4, 0);
INSERT INTO tanks (id, name, priority, meta) VALUES (13, 'STRV 103B', 4, 0);
INSERT INTO tanks (id, name, priority, meta) VALUES (14, 'IS-7', 4, 0);
INSERT INTO tanks (id, name, priority, meta) VALUES (15, 'Kampfpanzer 07 P(E)', 3, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (16, 'AMX 50 B', 5, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (17, '60TP LEWANDOWSKIEGO', 5, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (18, 'BZ-75', 3, 1);
INSERT INTO tanks (id, name, priority, meta) VALUES (19, 'T110E5', 2, 1);
