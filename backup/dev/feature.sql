create table feature
(
    id        int unsigned auto_increment
        primary key,
    feature   varchar(255) null,
    activated int unsigned not null
);

INSERT INTO feature (id, feature, activated) VALUES (1, 'clanWar', 0);
