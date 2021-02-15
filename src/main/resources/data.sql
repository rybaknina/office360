DROP TABLE IF EXISTS persons;

CREATE TABLE persons
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    email      VARCHAR(250) NOT NULL,
    skype      VARCHAR(100) NOT NULL,
    info       VARCHAR(500) DEFAULT NULL,
    positionX  DECIMAL(5.2) default 0,
    positionY  DECIMAL (5.2) default 0,
    positionZ  DECIMAL (5.2) default 0,
    pixelX  int default 0,
    pixelY  int default 0,
    panorama_id INT NOT NULL,
    active     boolean      default true
);
DROP TABLE IF EXISTS panoramas;

CREATE TABLE panoramas
(
    id             INT PRIMARY KEY,
    image_panorama VARCHAR(500) NOT NULL
);

DROP TABLE IF EXISTS panorama_link;

CREATE TABLE panorama_link
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    panorama_id INT,
    link_id     INT,
    positionX   DECIMAL(5.2) default 0,
    positionY  DECIMAL (5.2) default 0,
    positionZ  DECIMAL (5.2) default 0,
    image_scale INT default 300,
    image_link VARCHAR(500) DEFAULT './image/orange_arrow.png'
);

INSERT INTO persons (first_name, last_name, email, skype, info, positionX, positionY, positionZ, panorama_id)
VALUES ('Aliko', 'Dangote', 'billionaire@Industrialist.com', 'skype_personal_1', 'First info about person not so long',
        '-565.0', '-1112.0', '4837.0', 1),
       ('Bill', 'Gates', 'billionaireTech@Entrepreneur.com', 'skype_personal_2', 'second info', '3425.0', '-772.0',
        '3550.0', 1),
       ('Folrunsho', 'Alakija', 'billionaireOil@Magnate.com', 'skype_personal_3', 'third info', '4188.0', '-428.0',
        '2682.0', 1),
       ('Julia', 'Alshevskaya', 'julia@Magnate.com', 'skype_personal_4', 'fourth info', '3791.0', '-1213.0',
        '3012.0', 2);


insert into panoramas (id, image_panorama)
values (1, './image/office_senla_panorama_1.jpeg'),
       (2, './image/office_senla_panorama_2.jpeg');

insert into panorama_link (panorama_id, link_id, positionX, positionY, positionZ, image_scale, image_link)
values (1, 2, '3463.0', '-205.0', '-3586.0', 150, './image/orange_arrow.png'),
       (2, 1, '567.0', '-146.0', '4959.0', 400, './image/blue_arrow.png');