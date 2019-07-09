INSERT INTO user values(101, sysdate(), 'AB');
INSERT INTO user values(102, sysdate(), 'Jill');
INSERT INTO user values(103, sysdate(), 'Jam');
INSERT INTO POST values (101, 'My First post', 101);
INSERT INTO POST values (102, 'My Second post', 101);

INSERT INTO DEPT (id, code, name, is_active, last_updator_id, date_created, last_updated)
VALUES (101, 'ABC', 'ABC', 1, 1, sysdate(), sysdate());

INSERT INTO WORKER (id, login_id, name, is_active, password, mobile_phone_no, email, is_accessible_to_patron, is_super_admin, last_updator_id, expiry_date, date_created, last_updated)
VALUES (101, 'inek4gut', '아이네크' , 1, 'abc', '01022233333', 'tanbbang01@inek.co.kr', 1, 1, 1, sysdate() + 1, sysdate(), sysdate());