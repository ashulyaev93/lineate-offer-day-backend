INSERT INTO singer (name) VALUES
('Madonna'),
('Michael Jackson'),
('Billie Eilish'),
('Metallica');
commit;

INSERT INTO company (name) VALUES
('Black Company'),
('The best company'),
('Europe label'),
('Imagine label');
commit;


INSERT INTO recording (song_code, title, version, release_time, singer_id ) VALUES
('SN 123', 'Frozen', '1', '1008-01-15', 1);

INSERT INTO recording (song_code, title, version, release_time, singer_id ) VALUES
('SN 125', 'Earth songs', '1', '1982-01-15', 2);

INSERT INTO recording (song_code, title, version, release_time, singer_id ) VALUES
('SN 126', 'Bad Guy', '1', '2019-01-15', 3);

INSERT INTO recording (song_code, title, version, release_time, singer_id ) VALUES
('SN 127', 'Nothing else matters', '1', '1991-01-15', 4);


INSERT INTO rule (end_date, price, start_date, company_id) VALUES
('2022-03-15', 11.3, '2022-02-15', 1);

INSERT INTO rule (end_date, price, start_date, company_id) VALUES
('2022-04-15', 30.3, '2022-01-15', 3);


INSERT INTO rule_recording (recording_id, rule_id) VALUES
(1, 1);

INSERT INTO rule_recording (recording_id, rule_id) VALUES
(1, 2);