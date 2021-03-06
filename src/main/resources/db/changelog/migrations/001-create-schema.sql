CREATE TABLE singer
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(256)
);

CREATE TABLE recording
(
    id           BIGSERIAL PRIMARY KEY,
    song_code    VARCHAR(32),
    title        VARCHAR(4096),
    version      VARCHAR(128),
    release_time TIMESTAMP,
    singer_id    BIGINT REFERENCES singer (id)
);

CREATE TABLE company
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(256)
);

create table rule
(
    id bigint generated by default as identity,
    end_date timestamp,
    price double,
    start_date timestamp,
    company_id bigint not null,
    primary key (id)
);

create table rule_recording
(
    recording_id bigint not null,
    rule_id bigint not null,
    primary key (recording_id, rule_id)
);

alter table rule add constraint FKbtjg2r9q7yqe25h05najp0e05 foreign key (company_id) references company;

alter table rule_recording add constraint FK57xmwx95g2n6k5b6bng1mi82x foreign key (rule_id) references rule;

alter table rule_recording add constraint FK3huh5sxvxudlidibde7fyrs3t foreign key (recording_id) references recording;

