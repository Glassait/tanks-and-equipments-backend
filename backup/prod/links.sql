create table links
(
    id      int unsigned auto_increment
        primary key,
    tank_id int unsigned not null,
    name    varchar(255) null,
    url     varchar(255) null,
    constraint links_tanks_id_fk
        foreign key (tank_id) references tanks (id)
            on update cascade
);

INSERT INTO links (id, tank_id, name, url) VALUES (1, 1, 'Tanks.gg', 'https://tanks.gg/tank/obj-277');
INSERT INTO links (id, tank_id, name, url) VALUES (2, 1, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/22017-object-277/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (3, 2, 'Tanks.gg', 'https://tanks.gg/tank/obj-260');
INSERT INTO links (id, tank_id, name, url) VALUES (4, 2, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/58369-object-260/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (5, 3, 'Tanks.gg', 'https://tanks.gg/tank/obj-907');
INSERT INTO links (id, tank_id, name, url) VALUES (6, 3, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/15617-object-907/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (7, 4, 'Tanks.gg', 'https://tanks.gg/tank/obj-140');
INSERT INTO links (id, tank_id, name, url) VALUES (8, 4, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/16897-object-140/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (9, 5, 'Tanks.gg', 'https://tanks.gg/tank/t95fv4201');
INSERT INTO links (id, tank_id, name, url) VALUES (10, 5, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/57937-t95fv4201-chieftain/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (11, 6, 'Tanks.gg', 'https://tanks.gg/tank/s-conqueror');
INSERT INTO links (id, tank_id, name, url) VALUES (12, 6, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/15697-super-conqueror/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (13, 7, 'Tanks.gg', 'https://tanks.gg/tank/cs-63');
INSERT INTO links (id, tank_id, name, url) VALUES (14, 7, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/5265-cs63/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (15, 8, 'Tanks.gg', 'https://tanks.gg/tank/t110e3');
INSERT INTO links (id, tank_id, name, url) VALUES (16, 8, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/13857-t110e3/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (17, 9, 'Tanks.gg', 'https://tanks.gg/tank/ebr-105');
INSERT INTO links (id, tank_id, name, url) VALUES (18, 9, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/19009-panhard-ebr-105/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (19, 10, 'Tanks.gg', 'https://tanks.gg/tank/obj-279-e');
INSERT INTO links (id, tank_id, name, url) VALUES (20, 10, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/46849-object-279-early/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (21, 11, 'Tanks.gg', 'https://tanks.gg/tank/obj-2684');
INSERT INTO links (id, tank_id, name, url) VALUES (22, 11, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/20225-object-268-version-4/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (23, 12, 'Tanks.gg', 'https://tanks.gg/tank/leopard-1');
INSERT INTO links (id, tank_id, name, url) VALUES (24, 12, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/14609-leopard-1/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (25, 13, 'Tanks.gg', 'https://tanks.gg/tank/strv-103b');
INSERT INTO links (id, tank_id, name, url) VALUES (26, 13, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/4737-strv-103b/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (27, 14, 'Tanks.gg', 'https://tanks.gg/tank/is-7');
INSERT INTO links (id, tank_id, name, url) VALUES (28, 14, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/7169-is7/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (29, 15, 'Tanks.gg', 'https://tanks.gg/tank/kpz-07-pe');
INSERT INTO links (id, tank_id, name, url) VALUES (30, 15, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/22801-kampfpanzer-07-pe/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (31, 16, 'Tanks.gg', 'https://tanks.gg/tank/amx-50-b');
INSERT INTO links (id, tank_id, name, url) VALUES (32, 16, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/6209-amx-50-b/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (33, 17, 'Tanks.gg', 'https://tanks.gg/tank/60tp');
INSERT INTO links (id, tank_id, name, url) VALUES (34, 17, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/3473-60tp-lewandowskiego/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (35, 18, 'Tanks.gg', 'https://tanks.gg/tank/bz-75');
INSERT INTO links (id, tank_id, name, url) VALUES (36, 18, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/9009-bz75/?mode=xray.modules');
INSERT INTO links (id, tank_id, name, url) VALUES (37, 19, 'Tanks.gg', 'https://tanks.gg/tank/t110e5');
INSERT INTO links (id, tank_id, name, url) VALUES (38, 19, 'WoT Inspector', 'https://armor.wotinspector.com/en/pc/10785-t110e5/?mode=xray.modules');
