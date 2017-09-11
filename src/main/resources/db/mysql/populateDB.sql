# pass - admin
INSERT INTO users VALUES (1, 'admin', '$2a$11$UxhGJ1ofAGqAXEEoIkoKNOwLvdu7no.MIcIz.yyGoXR1TaPFb.HKS');

INSERT INTO roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles VALUES (2, 'ROLE_USER');



INSERT INTO user_roles VALUES (1, 1);