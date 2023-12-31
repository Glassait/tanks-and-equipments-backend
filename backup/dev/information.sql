create table information
(
    id       int unsigned auto_increment
        primary key,
    text     varchar(520) null,
    url      varchar(255) null,
    text_url varchar(255) null
);

INSERT INTO information (id, text, url, text_url) VALUES (1, 'La Clan War débute le lundi 14 août 2023. Nous espérons que vous vous amuserez pendant ces 14 jours. Si vous souhaitez consulter les Line-ups, veuillez cliquer sur le lien suivant :', 'path.clanWar', 'Visualisation LU clan war');
INSERT INTO information (id, text, url, text_url) VALUES (2, 'Nous tenons à exprimer notre gratitude envers chacun d\'entre vous pour votre participation à ce format particulier de Clan War. Les résultats obtenus sont extrêmement satisfaisants, comptabilisant un total de 20 chars LCHP et HTX, ainsi que des points de renommée personnels offrant la possibilité d\'acquérir divers objets dans la boutique de l\'événement "Manœuvres". Notre performance nous a permis de figurer dans le top 10 % des clans en Europe, ce qui nous place fièrement parmi les premiers clans français.', null, null);
