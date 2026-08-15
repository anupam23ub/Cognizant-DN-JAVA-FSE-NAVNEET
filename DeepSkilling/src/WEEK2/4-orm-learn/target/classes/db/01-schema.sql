-- ===========================================================================
-- 01-schema.sql  -  all tables for the orm-learn project
-- Run this first against the `ormlearn` schema:
--     mysql> create schema if not exists ormlearn;
--     mysql> use ormlearn;
--     mysql> source 01-schema.sql;
-- ===========================================================================

-- ---- Doc 1: country (co_code / co_name to match the populate script) ----
CREATE TABLE IF NOT EXISTS country (
    co_code VARCHAR(2)  PRIMARY KEY,
    co_name VARCHAR(80)
);

-- ---- Doc 2 / Hands-on 2: stock ----
CREATE TABLE IF NOT EXISTS stock (
    st_id     INT NOT NULL AUTO_INCREMENT,
    st_code   VARCHAR(10),
    st_date   DATE,
    st_open   NUMERIC(10,2),
    st_close  NUMERIC(10,2),
    st_volume NUMERIC(15),
    PRIMARY KEY (st_id)
);

-- ---- Doc 2 / Hands-on 3: payroll (department, employee, skill, link) ----
CREATE TABLE IF NOT EXISTS department (
    dp_id   INT NOT NULL AUTO_INCREMENT,
    dp_name VARCHAR(60),
    PRIMARY KEY (dp_id)
);

CREATE TABLE IF NOT EXISTS employee (
    em_id            INT NOT NULL AUTO_INCREMENT,
    em_name          VARCHAR(60),
    em_salary        DOUBLE,
    em_permanent     BIT,
    em_date_of_birth DATE,
    em_dp_id         INT,
    PRIMARY KEY (em_id),
    CONSTRAINT fk_employee_department
        FOREIGN KEY (em_dp_id) REFERENCES department (dp_id)
);

CREATE TABLE IF NOT EXISTS skill (
    sk_id   INT NOT NULL AUTO_INCREMENT,
    sk_name VARCHAR(60),
    PRIMARY KEY (sk_id)
);

CREATE TABLE IF NOT EXISTS employee_skill (
    es_em_id INT NOT NULL,
    es_sk_id INT NOT NULL,
    PRIMARY KEY (es_em_id, es_sk_id),
    CONSTRAINT fk_es_employee FOREIGN KEY (es_em_id) REFERENCES employee (em_id),
    CONSTRAINT fk_es_skill    FOREIGN KEY (es_sk_id) REFERENCES skill (sk_id)
);

-- ---- Doc 3 / Hands-on 3: quiz schema ----
CREATE TABLE IF NOT EXISTS quiz_user (
    us_id   INT NOT NULL AUTO_INCREMENT,
    us_name VARCHAR(60),
    PRIMARY KEY (us_id)
);

CREATE TABLE IF NOT EXISTS question (
    qu_id    INT NOT NULL AUTO_INCREMENT,
    qu_text  VARCHAR(255),
    qu_score DOUBLE,
    PRIMARY KEY (qu_id)
);

CREATE TABLE IF NOT EXISTS options (
    op_id      INT NOT NULL AUTO_INCREMENT,
    op_qu_id   INT,
    op_text    VARCHAR(120),
    op_correct BIT,
    PRIMARY KEY (op_id),
    CONSTRAINT fk_options_question FOREIGN KEY (op_qu_id) REFERENCES question (qu_id)
);

CREATE TABLE IF NOT EXISTS attempt (
    at_id      INT NOT NULL AUTO_INCREMENT,
    at_us_id   INT,
    at_date    DATE,
    PRIMARY KEY (at_id),
    CONSTRAINT fk_attempt_user FOREIGN KEY (at_us_id) REFERENCES quiz_user (us_id)
);

CREATE TABLE IF NOT EXISTS attempt_question (
    aq_id      INT NOT NULL AUTO_INCREMENT,
    aq_at_id   INT,
    aq_qu_id   INT,
    PRIMARY KEY (aq_id),
    CONSTRAINT fk_aq_attempt  FOREIGN KEY (aq_at_id) REFERENCES attempt (at_id),
    CONSTRAINT fk_aq_question FOREIGN KEY (aq_qu_id) REFERENCES question (qu_id)
);

CREATE TABLE IF NOT EXISTS attempt_option (
    ao_id       INT NOT NULL AUTO_INCREMENT,
    ao_aq_id    INT,
    ao_op_id    INT,
    ao_selected BIT,
    PRIMARY KEY (ao_id),
    CONSTRAINT fk_ao_attempt_question FOREIGN KEY (ao_aq_id) REFERENCES attempt_question (aq_id),
    CONSTRAINT fk_ao_option           FOREIGN KEY (ao_op_id) REFERENCES options (op_id)
);
