CREATE TABLE users
(
  id bigserial NOT NULL,
  name character varying(255),
  email character varying(255),
  phone character varying(255),
  address character varying(255),
  CONSTRAINT contact_pkey PRIMARY KEY (id)
);

ALTER TABLE users OWNER TO postgres;

insert into users (name, email, phone, address)
values
  ('Timur Galeev', 'galeev@timzu.com', '123456789', 'Germany, Brunswick'),
  ('Daniel Garden', 'garden@garden.com', '541236985', 'Los Angeles, California'),
  ('Denis Chek', 'denis@check.com', '4545698785', 'France, Paris'),
  ('Lily Demis', 'lile@demis.com', '584289487524303', 'Poland, Wrocław'),
  -- ('Jane Gord', 'jane@gord.com', '419584879', null),
  -- ('Viktor Brand', 'viktor@brand.com', '419584879', null)
