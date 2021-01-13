CREATE TABLE `users`
(
  `id` BIGINT
(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR
(255) NOT NULL,
  `email` VARCHAR
(255) NOT NULL,
  `phone` VARCHAR
(255),
  `address` VARCHAR
(255),
  PRIMARY KEY
(`id`)
) ENGINE=MYISAM DEFAULT CHARSET=latin1;

CREATE UNIQUE INDEX id_user_email ON users (email
(255));

insert into users
  (`name`, email, phone, address
)
values
('Timur Galeev', 'galeev@timzu.com', '123456789', 'Germany, Brunswick'),
('Daniel Garden', 'garden@garden.com', '541236985', 'Los Angeles, California'),
('Denis Chek', 'denis@check.com', '4545698785', 'France, Paris'),
('Lily Demis', 'lile@demis.com', '584289487524303', 'Poland, Wrocław'),
('Jane Gord', 'jane@gord.com', '419584879', null),
('Viktor Brand', 'viktor@brand.com', 'dsadasda', null)
