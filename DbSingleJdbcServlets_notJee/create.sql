DROP TABLE IF EXISTS users;
CREATE TABLE  users (
  id bigint(20) NOT NULL auto_increment,
  name_id bigint(20) NOT NULL,
  surname_id bigint(20) NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS names;
CREATE TABLE  names (
  id bigint(20) NOT NULL auto_increment,
  name varchar(45) NOT NULL,
  PRIMARY KEY  (id),
  CONSTRAINT unique_name UNIQUE (name)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS surnames;
CREATE TABLE  surnames (
  id bigint(20) NOT NULL auto_increment,
  surname varchar(45) NOT NULL,
  PRIMARY KEY  (id),
  CONSTRAINT unique_surname UNIQUE (surname)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

